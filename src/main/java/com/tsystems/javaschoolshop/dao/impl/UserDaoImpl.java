package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.UserDao;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import java.util.List;

/**
 * Class which implements all necessary methods which allow us
 * to work with database and users.
 */
@Repository
public class UserDaoImpl extends GenericDao implements UserDao {

    /**
     * See {@link UserDao}
     * @param email unique email of the user.
     * @return reference to a found user.
     */
    @Override
    @Transactional
    public User findUserByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM User u WHERE email = :email");
        query.setParameter("email", email);
        List<User> result = (List<User>) query.getResultList();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }

    /**
     * See {@link UserDao}
     * @param phone unique phone of the user.
     * @return reference to a found user.
     */
    @Override
    @Transactional
    public User findUserByPhone(String phone) {
        Query query = em.createQuery("SELECT u FROM User u WHERE phone = :phone");
        query.setParameter("phone", phone);
        List<User> result = (List<User>) query.getResultList();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }

    /**
     * See {@link UserDao}
     * @param user - reference to an User object we need to save.
     */
    @Override
    @Transactional
    public void saveUser(User user) {
        em.merge(user);
        em.flush();
    }

    /**
     * See {@link UserDao}
     * @param id of the user.
     * @return reference to a found user by his id.
     */
    @Override
    public User findUserById(int id) {
        Query query = em.createQuery("SELECT u FROM User u WHERE id = :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    /**
     * See {@link UserDao}
     * @param n is input parameter.
     * @return list of found top N users.
     */
    @Override
    public List<User> findTopNUsers(int n) {
        Query query = em.createQuery("SELECT u.user FROM StatisticTopUser u WHERE role =:role ORDER BY u.price DESC");
        query.setParameter("role", UserRoleEnum.ROLE_USER.name());
        return (List<User>) query.setMaxResults(n).getResultList();
    }

    /**
     * See {@link UserDao}
     * @return list of found simple admins.
     */
    @Override
    public List<User> findSimpleAdmins() {
        Query query = em.createQuery("SELECT u FROM User u WHERE role = :role");
        query.setParameter("role", UserRoleEnum.ROLE_ADMIN.name());
        return (List<User>) query.getResultList();
    }

    /**
     * This method allow us to delete User.
     * @param id of the user.
     */
    @Override
    @Transactional
    public void deleteUser(int id) {
        em.remove(findUserById(id));
        em.flush();
    }
}
