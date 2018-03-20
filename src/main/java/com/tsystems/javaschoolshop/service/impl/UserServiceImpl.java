package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.UserDao;
import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(final UserDao userDao,PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder=passwordEncoder;    }

    @Override
    public User findUserByEmail(final String email) {
        if (email == null || email.isEmpty()) return null;
        return userDao.findUserByEmail(email);
    }

    @Override
    public User findUserFromSecurityContextHolder() {
        return findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public boolean isEmailFree(final String email) {
        if (email == null || email.isEmpty()) return false;
        return userDao.findUserByEmail(email) == null;
    }

    @Override
    public void saveNewUser(User user) {
        if(user.getPhone().trim().length() == 0) user.setPhone(null);
        if(user.getAddresses().get(0).getApartment().trim().length() == 0) user.getAddresses().get(0).setApartment(null);
        if(user.getAddresses().get(0).getPostcode().trim().length() == 0) user.getAddresses().get(0).setPostcode(null);
        user.setRole(UserRoleEnum.ROLE_USER.name());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }
}
