package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;


public interface UserService {

    User findUserByEmail(String email);
    void saveNewUser(User user);
    User findUserFromSecurityContextHolder();
    boolean isEmailFree(String email);
    boolean isPhoneFree(String phone);
    boolean changePassword(String oldPassword, String newPassword);
    void saveAddress(Address address);
    void deleteAddress(Address address);
}
