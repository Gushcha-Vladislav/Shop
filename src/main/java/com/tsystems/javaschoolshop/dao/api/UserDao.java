package com.tsystems.javaschoolshop.dao.api;


import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;

import java.util.List;


public interface UserDao {

    User findUserByEmail(String email);
    User findUserByPhone(String phone);
    void saveUser(User user);
    Address findAddressById(int idAddress);
    User findUserById(int id);
    List<User> findTopNUsers(int n);
    List<User> findSimpleAdmins();
    void deleteUser(int id);
}
