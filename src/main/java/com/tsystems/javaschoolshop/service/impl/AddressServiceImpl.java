package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.AddressDao;
import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.service.api.AddressService;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService {

    /**
     * Injected by spring userService bean
     */
    private final UserService userService;

    /**
     * Injected by spring addressDao bean
     */
    private final AddressDao addressDao;

    /**
     * Injecting constructor.
     *
     * @param userService that must be injected.
     * @param addressDao that must be injected.
     */
    @Autowired
    public AddressServiceImpl(UserService userService, AddressDao addressDao) {
        this.userService = userService;
        this.addressDao =addressDao;
    }

    /**
     * Method add address to database.
     *
     * @param address that must be added.
     */
    @Override
    public void saveAddress(Address address) {
        User user = userService.findUserFromSecurityContextHolder();
        address.setUser(user);
        user.getAddresses().add(address);
        userService.saveUser(user);
    }

    /**
     * Method delete address to database.
     *
     * @param idAddress - parameter id address.
     */
    @Override
    public void deleteAddress(int idAddress){
        User user = userService.findUserFromSecurityContextHolder();
        user.getAddresses().remove(findAddressById(idAddress));
        userService.saveUser(user);
    }

    /**
     * Method looks for address by id.
     *
     * @param idAddress - parameter id address.
     * @return found address object.
     */
    @Override
    public Address findAddressById(int idAddress) {
        return addressDao.findAddressById(idAddress);
    }

}
