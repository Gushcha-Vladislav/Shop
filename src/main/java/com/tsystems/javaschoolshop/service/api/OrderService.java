package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;

import java.util.List;

public interface OrderService {
    Order saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket);
    List<Order> findOrderByUser();
    List<BasketProductDto> repeatOrderById(int idOrder);
    List<Order> findAllOrder();
    boolean changeOrderStatusById(int idOrder,String orderStatus);
    boolean changePaymentStatusById(int idOrder,String paymentStatus);
    void sendMessage(Order order, User user, List<BasketProductDto> bag, int idAddress);
}
