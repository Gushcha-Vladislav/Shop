package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;

import java.util.List;

public interface OrderService {
    void saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket);
    void sendMessage(Order order, User user, List<BasketProductDto> bag, int idAddress);
}
