package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.OrderDao;
import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.OrderStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Class which implements all necessary methods which allow us
 * to work with database and orders.
 */
@Repository
public class OrderDaoImpl  extends GenericDao implements OrderDao {

    /**
     * See {@link OrderDao}
     * @param order - directly, the mapped object we need to save.
     * @return reference to an saved Order object.
     */
    @Override
    @Transactional
    public Order saveOrder(Order order) {
        Order temp =em.merge(order);
        em.flush();
        return temp;
    }

    /**
     * See {@link OrderDao}.
     * @param user .
     * @return list of found orders.
     */
    @Override
    public List<Order> findOrderByUser(User user){
        Query query = em.createQuery("SELECT o FROM Order o WHERE user.email = :email");
        query.setParameter("email", user.getEmail());
        return (List<Order>) query.getResultList();
    }

    /**
     * See {@link OrderDao}
     * @param idOrder of the order we want to find
     * @return reference to an found Order object
     */
    @Override
    public Order findOrderById(int idOrder){
        Query query = em.createQuery("SELECT p FROM Order p WHERE id = :id");
        query.setParameter("id", idOrder);
        return (Order) query.getSingleResult();
    }

    /**
     * See {@link OrderDao}
     * @return list of found orders.
     */
    @Override
    public List<Order> findAllOrder(){
        return  em.createQuery("select e from Order e", Order.class).getResultList();
    }

    /**
     * See {@link OrderDao}.
     * @param startDate - start period.
     * @param endDate - finish period
     * @return list of found orders.
     */
    @Override
    public List<Order> findOrderByDate(Date startDate, Date endDate) {
        Query query = em.createQuery("SELECT e FROM Order e WHERE e.dateOrder BETWEEN :startDate AND :endDate AND orderStatus =:orderStatus");
        query.setParameter("startDate", startDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);
        query.setParameter("orderStatus", OrderStatusEnum.DONE.toString());
        return (List<Order>) query.getResultList();
    }
}
