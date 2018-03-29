package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;

import java.util.Date;
import java.util.List;

public interface OrderDao {

    Order saveOrder(Order order);
    List<Order> findOrderByUser(User user);
    Order findOrderById(int idOrder);
    List<Order> findAllOrder();
    List<Order> findOrderByDate(Date startDate, Date endDate);
}
