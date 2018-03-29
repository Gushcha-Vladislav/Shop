package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.*;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.model.enums.OrderStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentTypeEnum;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.UserService;
import com.tsystems.javaschoolshop.util.ComparatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@PropertySource(value = { "classpath:mail.properties" })
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final MailSender mailSender;
    private final UserService userService;
    private final BasketProductService basketProductService;
    private final Environment environment;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, MailSender mailSender, UserService userService,
                            BasketProductService basketProductService, Environment environment) {
        this.orderDao = orderDao;
        this.mailSender = mailSender;
        this.userService = userService;
        this.basketProductService = basketProductService;
        this.environment = environment;
    }

    @Override
    @Transactional
    public Order saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket) {
        User user = userService.findUserFromSecurityContextHolder();
        Address address = userService.findAddressById(idAddress);
        Order order = new Order();
        order.setUser(address.getUser());
        order.setAddress(address.toStringForEmail());
        if (paymentType.equals("CASH")) {
            order.setPayment(PaymentTypeEnum.CASH.toString());
            order.setDelivery(PaymentStatusEnum.AWAITING_PAYMENT.toString());
        } else {
            order.setPayment(PaymentTypeEnum.CREDIT.toString());
            order.setDelivery(PaymentStatusEnum.PAID.toString());
        }
        order.setOrderStatus(OrderStatusEnum.AWAITING_SHIPMENT.toString());
        order.setDateOrder(new Date());
        int totalPrise =basketProductService.totalPrice(basket);
        order.setOrderPrice(totalPrise);
        user.getStatisticTopUser().setPrice(user.getStatisticTopUser().getPrice()+totalPrise);
        for (BasketProductDto bagItem : basket) {
            Product product = basketProductService.convertBasketProductDtoToProduct(bagItem);
            OrdersProducts ordersProducts = new OrdersProducts(order, product, bagItem.getAmount());
            order.getProducts().add(ordersProducts);
        }
        userService.saveUser(user);
        return orderDao.saveOrder(order);
    }

    @Override
    public List<Order> findOrderByUser(){
        User user = userService.findUserFromSecurityContextHolder();
        return orderDao.findOrderByUser(user)
                .stream()
                .sorted(ComparatorUtil.getDescendingIdOrderComparator())
                .collect(Collectors.toList());
    }

    @Override
    public List<BasketProductDto> repeatOrderById(int idOrder){
        Order order =orderDao.findOrderById(idOrder);
        List<BasketProductDto> bag=new ArrayList<>();
        for(OrdersProducts orderProduct : order.getProducts()){
            BasketProductDto bagItem =new BasketProductDto(orderProduct.getProduct().getId(),
                    orderProduct.getProduct().getNameProduct(),orderProduct.getAmount(),orderProduct.getProduct().getPrice(),
                    orderProduct.getProduct().getImage());
            basketProductService.addToBasket(bagItem,bag);
        }
        return bag;

    }

    @Override
    public List<Order> findAllOrder(){
        return orderDao.findAllOrder();
    }

    @Override
    public void sendMessage(Order order, User user, List<BasketProductDto> bag, int idAddress) {
        SimpleMailMessage msg = new SimpleMailMessage();

        StringBuilder products = new StringBuilder();
        int counter = 0;
        for (BasketProductDto productDto : bag) {
            products.append(++counter).append(") ")
                    .append(productDto.getNameProduct()).append(" - ")
                    .append(productDto.getAmount()).append(" items.").append(" Price - $")
                    .append(productDto.getPrice() * productDto.getAmount()).append(".").append(System.lineSeparator());
        }

        String message = "Hi, " + user.getNameUser() + "!" + System.lineSeparator()
                + "Your order[ID=" + order.getId() + "] is confirmed." + System.lineSeparator()
                + "List of products: " + System.lineSeparator()
                + products.toString() + System.lineSeparator()
                + "Delivery address: " + userService.findAddressById(idAddress).toStringForEmail() + System.lineSeparator() + System.lineSeparator()
                + "Thank you for choosing us!";

        msg.setFrom(environment.getRequiredProperty("mail.username"));
        msg.setTo(user.getEmail());
        msg.setSubject("JavaShop");
        msg.setText(message);
        mailSender.send(msg);
    }
}
