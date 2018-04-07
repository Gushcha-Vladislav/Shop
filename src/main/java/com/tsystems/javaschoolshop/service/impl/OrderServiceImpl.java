package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.*;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.model.enums.OrderStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentTypeEnum;
import com.tsystems.javaschoolshop.service.api.AddressService;
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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Order service. It is used to order manipulations.
 */
@Service
@PropertySource(value = { "classpath:mail.properties" })
public class OrderServiceImpl implements OrderService {

    /**
     * Injected by spring orderDao bean.
     */
    private final OrderDao orderDao;

    /**
     * Injected by spring mailSender bean.
     */
    private final MailSender mailSender;

    /**
     * Injected by spring user service bean.
     */
    private final UserService userService;

    /**
     * Injected by spring basket product service bean.
     */
    private final BasketProductService basketProductService;

    /**
     * Injected by spring basket address service bean.
     */
    private final AddressService addressService;

    private final Environment environment;

    /**
     * Injecting constructor.
     * @param orderDao that must be injected.
     * @param mailSender that must be injected.
     * @param userService that must be injected.
     * @param basketProductService that must be injected.
     * @param environment that must be injected.
     */
    @Autowired
    public OrderServiceImpl(OrderDao orderDao, MailSender mailSender, UserService userService,
                            BasketProductService basketProductService, Environment environment,
                            AddressService addressService) {
        this.orderDao = orderDao;
        this.mailSender = mailSender;
        this.userService = userService;
        this.basketProductService = basketProductService;
        this.addressService = addressService;
        this.environment = environment;
    }

    /**
     * Method saves new orders with necessary parameters.
     * @param  idAddress - shipping address id.
     * @param paymentType - tells is card payment type.
     * @param basket - list with bag products.
     * @return reference to a saved object.
     */
    @Override
    @Transactional
    public Order saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket) {
        User user = userService.findUserFromSecurityContextHolder();
        Address address = addressService.findAddressById(idAddress);
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

    /**
     * Method finds orders by user.
     * @return list of found orders.
     */
    @Override
    public List<Order> findOrderByUser(){
        User user = userService.findUserFromSecurityContextHolder();
        return orderDao.findOrderByUser(user)
                .stream()
                .sorted(ComparatorUtil.getDescendingIdOrderComparator())
                .collect(Collectors.toList());
    }

    /**
     * Method repeat order by id.
     * @param idOrder - id of the order.
     * @return list of found orders.
     */
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

    /**
     * Method finds all orders in database.
     * @return list of found orders.
     */
    @Override
    public List<Order> findAllOrder(){
        return orderDao.findAllOrder();
    }

    /**
     * Method of  change the order of an status in database.
     * @param idOrder - id of the order.
     * @param orderStatus - new status.
     */
    @Override
    public boolean changeOrderStatusById(int idOrder, String orderStatus) {
        Order order =orderDao.findOrderById(idOrder);
        switch(orderStatus){
            case "AWAITING_PAYMENT":
                order.setOrderStatus(OrderStatusEnum.AWAITING_PAYMENT.toString());
                break;
            case "AWAITING_SHIPMENT":
                order.setOrderStatus(OrderStatusEnum.AWAITING_SHIPMENT.toString());
                break;
            case "SHIPPED":
                order.setOrderStatus(OrderStatusEnum.SHIPPED.toString());
                break;
            case "DELIVERED":
                order.setOrderStatus(OrderStatusEnum.DELIVERED.toString());
                break;
            case "DONE":
                order.setOrderStatus(OrderStatusEnum.DONE.toString());
                break;
            default:
                break;
        }
        orderDao.saveOrder(order);
        return true;
    }

    /**
     * Method of  change the payment of an status in database.
     * @param idOrder - id of the order.
     * @param paymentStatus - new status.
     */
    @Override
    public boolean changePaymentStatusById(int idOrder, String paymentStatus) {
        Order order =orderDao.findOrderById(idOrder);
        switch(paymentStatus){
            case "AWAITING_PAYMENT":
                order.setDelivery(PaymentStatusEnum.AWAITING_PAYMENT.toString());
                break;
            case "PAID":
                order.setDelivery(PaymentStatusEnum.PAID.toString());
                break;
            default:
                break;
        }
        orderDao.saveOrder(order);
        return true;
    }

    /**
     * This method sends message to the customer email.
     */
    @Override
    public void sendMessage(Order order, User user, List<BasketProductDto> bag, int idAddress) {
        SimpleMailMessage msg = new SimpleMailMessage();

        StringBuilder products = new StringBuilder();
        int counter = 0;
        for (BasketProductDto productDto : bag) {
            products.append(++counter).append(") ")
                    .append(productDto.getNameProduct()).append(" - ")
                    .append(productDto.getAmount()).append(" items.").append(" Price - \u20BD ")
                    .append(productDto.getPrice() * productDto.getAmount()).append(".").append(System.lineSeparator());
        }

        String message = "Hi, " + user.getNameUser() + "!" + System.lineSeparator()
                + "Your order[ID=" + order.getId() + "] is confirmed." + System.lineSeparator()
                + "List of products: " + System.lineSeparator()
                + products.toString() + System.lineSeparator()
                + "Delivery address: " + addressService.findAddressById(idAddress).toStringForEmail() + System.lineSeparator() + System.lineSeparator()
                + "Thank you for choosing us!";

        msg.setFrom(environment.getRequiredProperty("mail.username"));
        msg.setTo(user.getEmail());
        msg.setSubject(environment.getRequiredProperty("shop.name"));
        msg.setText(message);
        mailSender.send(msg);
    }

    /**
     * Method finds revenue for the last N days.
     * @param dayAgo days.
     * @return revenue.
     */
    @Override
    public int findRevenuePerNDay(int dayAgo) {
        int amount = 0;
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().minusDays(dayAgo);
        List<Order> orders = orderDao.findOrderByDate(Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        for (Order order : orders) {
            amount += order.getOrderPrice();
        }
        return amount;
    }

}
