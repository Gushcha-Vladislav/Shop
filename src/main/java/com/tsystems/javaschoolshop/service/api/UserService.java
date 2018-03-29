package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;

import java.util.List;


public interface UserService {

    User findUserByEmail(String email);
    void createUser(User user, String role);
    User findUserFromSecurityContextHolder();
    boolean isEmailFree(String email);
    boolean isPhoneFree(String phone);
    boolean changePassword(String oldPassword, String newPassword);
    void saveAddress(Address address);
    void deleteAddress(int idAddress);
    Address findAddressById(int idAddress);
    void saveUser(User user);
    List<User> findTopNUsers();
    List<User> findSimpleAdmins();
    void deleteUser(int id);
}
