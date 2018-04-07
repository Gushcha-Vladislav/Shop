package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.UserDao;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    /**
     * Injected by spring userDao bean
     */
    private final UserDao userDao;

    /**
     * Injected by spring passwordEncoder bean
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Injecting constructor.
     *
     * @param userDao that must be injected.
     * @param passwordEncoder that must be injected.
     */
    @Autowired
    public UserServiceImpl(final UserDao userDao,PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder=passwordEncoder;    }

    /**
     * Method looks for user by his email.
     *
     * @param email of the user.
     * @return found user object.
     */
    @Override
    public User findUserByEmail(final String email) {
        if (email == null || email.isEmpty()) return null;
        return userDao.findUserByEmail(email);
    }

    /**
     * Every user have their own SecurityContextHolder which is connected with session.
     * So, this method allow us to get User object from this SecurityContextHolder
     * and it will always return different User objects for all users. Users always will get themselves.
     *
     * @return User object {@link User}
     */
    @Override
    public User findUserFromSecurityContextHolder() {
        return findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    /**
     * Method checks whether email is already occupied.
     *
     * @param email that must be checked.
     * @return true if email is already occupied and false otherwise.
     */
    @Override
    public boolean isEmailFree(final String email) {
        if (email == null || email.isEmpty() || email.trim().length()>45) return false;
        return userDao.findUserByEmail(email) == null;
    }

    /**
     * Method checks whether phone is already occupied.
     *
     * @param phone that must be checked.
     * @return true if email is already occupied and false otherwise.
     */
    @Override
    public boolean isPhoneFree(final String phone) {
        if (phone == null || phone.trim().length()>20) return false;
        return userDao.findUserByPhone(phone) == null;
    }

    /**
     * Method add new user to database.
     *
     * @param user that must be added.
     */
    @Override
    public void createUser(User user,String role) {
        if(user.getPhone().trim().length() == 0) user.setPhone(null);
        if(user.getLastNameUser().trim().length() == 0) user.setLastNameUser(null);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    /**
     * Method change password of user.
     *
     * @param oldPassword - old password.
     * @param newPassword - new password.
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        User user = findUserFromSecurityContextHolder();
        if(passwordEncoder.matches(oldPassword,user.getPassword())){
            user.setPassword(passwordEncoder.encode(newPassword));
            userDao.saveUser(user);
        }
    }

    /**
     * Method merge user to database.
     *
     * @param user that must be added.
     */
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * Method looks for top N users. The more money the spent the higher rating they have.
     *
     * @return list of found users.
     */
    @Override
    public List<User> findTopNUsers() {
        return userDao.findTopNUsers(5);
    }

    /**
     * Method looks for all admins.
     *
     * @return list of found users with admin role. See {@link UserRoleEnum}
     */
    @Override
    public List<User> findSimpleAdmins() {
        return userDao.findSimpleAdmins();
    }

    /**
     * Method delete certain User by his ID.
     *
     * @param id of the user that must be deleted.
     */
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
