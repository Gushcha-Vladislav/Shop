package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDaoImpl  extends GenericDao implements OrderDao {

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        Order temp =em.merge(order);
        em.flush();
        return temp;
    }

    @Override
    public List<Order> findOrderByUser(User user){
        Query query = em.createQuery("SELECT o FROM Order o WHERE user.email = :email");
        query.setParameter("email", user.getEmail());
        return (List<Order>) query.getResultList();
    }
    @Override
    public Order findOrderById(int idOrder){
        Query query = em.createQuery("SELECT p FROM Order p WHERE id = :id");
        query.setParameter("id", idOrder);
        return (Order) query.getSingleResult();
    }

    @Override
    public List<Order> findAllOrder(){
        return  em.createQuery("select e from Order e", Order.class).getResultList();
    }

    @Override
    public List<Order> findOrderByDate(Date startDate, Date endDate) {
        Query query = em.createQuery("SELECT e FROM Order e WHERE e.dateOrder BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);
        return (List<Order>) query.getResultList();
    }
}
