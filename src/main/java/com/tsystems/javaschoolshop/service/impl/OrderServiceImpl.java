package com.tsystems.javaschoolshop.service.impl;


import com.tsystems.javaschoolshop.config.MailConfig;
import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.*;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.model.enums.OrderStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentTypeEnum;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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
    public void saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket) {
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
        order.setOrderPrice(basketProductService.totalPrice(basket));
        for (BasketProductDto bagItem : basket) {
            Product product = basketProductService.convertBasketProductDtoToProduct(bagItem);
            OrdersProducts ordersProducts = new OrdersProducts(order, product, bagItem.getAmount(), product.getPrice());
            order.getProducts().add(ordersProducts);
        }
        sendMessage(orderDao.saveOrder(order),userService.findUserFromSecurityContextHolder(),basket,idAddress);
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
