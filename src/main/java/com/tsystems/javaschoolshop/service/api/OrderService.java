package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;

import java.util.List;

/**
 * Interface provide us API we can use to manipulate categories.
 */
public interface OrderService {

    /**
     * Method saves new orders with necessary parameters.
     * @param  idAddress - shipping address id.
     * @param paymentType - tells is card payment type.
     * @param basket - list with bag products.
     * @return reference to a saved object.
     */
    Order saveOrder(int idAddress, String paymentType, List<BasketProductDto> basket);

    /**
     * Method finds orders by user.
     * @return list of found orders.
     */
    List<Order> findOrderByUser();

    /**
     * Method repeat order by id.
     * @param idOrder - id of the order.
     * @return list of found orders.
     */
    List<BasketProductDto> repeatOrderById(int idOrder);

    /**
     * Method finds all orders in database.
     * @return list of found orders.
     */
    List<Order> findAllOrder();

    /**
     * Method of  change the order of an status in database.
     * @param idOrder - id of the order.
     * @param orderStatus - new status.
     */
    boolean changeOrderStatusById(int idOrder,String orderStatus);

    /**
     * Method of  change the payment of an status in database.
     * @param idOrder - id of the order.
     * @param paymentStatus - new status.
     */
    boolean changePaymentStatusById(int idOrder,String paymentStatus);

    /**
     * This method sends message to the customer email.
     */
    void sendMessage(Order order, User user, List<BasketProductDto> bag, int idAddress);

    /**
     * Method finds revenue for the last N days.
     * @param dayAgo days.
     * @return revenue.
     */
    int findRevenuePerNDay(int dayAgo);
}
