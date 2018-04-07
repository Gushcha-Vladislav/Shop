package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;

import java.util.Date;
import java.util.List;

/**
 * This interface provide us API through which we will communicate with database.
 */
public interface OrderDao {

    /**
     * Method save order in database.
     * @param order - directly, the mapped object we need to save.
     * @return reference to an saved object.
     */
    Order saveOrder(Order order);

    /**
     * Method find all orders by the user .
     * @param user .
     * @return list of found orders.
     */
    List<Order> findOrderByUser(User user);

    /**
     * Method find in database Order by ID
     * @param idOrder of the order we want to find
     * @return necessary Order
     */
    Order findOrderById(int idOrder);

    /**
     * Method find all orders from the database.
     * @return list of found orders.
     */
    List<Order> findAllOrder();

    /**
     * Method find orders in a certain period.
     * @param startDate - start period.
     * @param endDate - finish period
     * @return list of found orders.
     */
    List<Order> findOrderByDate(Date startDate, Date endDate);
}
