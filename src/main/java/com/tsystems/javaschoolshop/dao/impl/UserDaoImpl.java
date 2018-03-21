package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.UserDao;
import com.tsystems.javaschoolshop.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl extends GenericDao implements UserDao {

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM User u WHERE email = :email");
        query.setParameter("email", email);
        List<User> result = (List<User>) query.getResultList();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }
    @Override
    @Transactional
    public User findUserByPhone(String phone) {
        Query query = em.createQuery("SELECT u FROM User u WHERE phone = :phone");
        query.setParameter("phone", phone);
        List<User> result = (List<User>) query.getResultList();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        em.merge(user);
        em.flush();
    }
}
