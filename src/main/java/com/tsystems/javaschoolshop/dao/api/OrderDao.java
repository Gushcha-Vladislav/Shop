package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;

import java.util.List;

public interface OrderDao {

    void saveOrder(Order order);
}
