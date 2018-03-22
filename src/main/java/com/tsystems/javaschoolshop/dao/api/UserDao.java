package com.tsystems.javaschoolshop.dao.api;


import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;


public interface UserDao {

    User findUserByEmail(String email);
    User findUserByPhone(String phone);
    void saveUser(User user);
    Address findAddressById(int idAddress);
}
