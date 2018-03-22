package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDaoImpl  extends GenericDao implements OrderDao {

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        Order temp =em.merge(order);
        em.flush();
        return temp;
    }
}
