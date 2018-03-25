package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Order;

public interface OrderDao {

    Order saveOrder(Order order);
}
