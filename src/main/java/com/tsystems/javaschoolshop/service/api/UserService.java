package com.tsystems.javaschoolshop.service.api;


import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;


public interface UserService {

    User findUserByEmail(String email);
    User findUserFromSecurityContextHolder();
}
