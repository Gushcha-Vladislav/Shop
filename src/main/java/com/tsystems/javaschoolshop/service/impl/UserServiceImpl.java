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
        if (email == null || email.isEmpty() || email.trim().length()>45) return false;
        return userDao.findUserByEmail(email) == null;
    }

    @Override
    public boolean isPhoneFree(final String phone) {
        if (phone == null || phone.isEmpty() || phone.trim().length()>20 || phone.trim().length()<11) return false;
        return userDao.findUserByPhone(phone) == null;
    }

    @Override
    public void saveNewUser(User user) {
        if(user.getPhone().trim().length() == 0) user.setPhone(null);
        if(user.getLastNameUser().trim().length() == 0) user.setLastNameUser(null);
        if(user.getAddresses().get(0).getApartment().trim().length() == 0) user.getAddresses().get(0).setApartment(null);
        if(user.getAddresses().get(0).getPostcode().trim().length() == 0) user.getAddresses().get(0).setPostcode(null);
        user.setRole(UserRoleEnum.ROLE_USER.name());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        User user = findUserFromSecurityContextHolder();
        if(passwordEncoder.matches(oldPassword,user.getPassword())){
            user.setPassword(passwordEncoder.encode(newPassword));
            userDao.saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void saveAddress(Address address) {
        User user = findUserFromSecurityContextHolder();
        user.getAddresses().add(address);
        userDao.saveUser(user);
    }

    @Override
    public void deleteAddress(Address address){
        User user = findUserFromSecurityContextHolder();
        user.getAddresses().remove(address);
        userDao.saveUser(user);
    }
}
