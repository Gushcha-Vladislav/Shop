package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Address;

public interface AddressService {

    /**
     * Method add address to database.
     * @param address that must be added.
     */
    void saveAddress(Address address);

    /**
     * Method delete address to database.
     * @param idAddress - parameter id address.
     */
    void deleteAddress(int idAddress);

    /**
     * Method looks for address by id.
     * @param idAddress - parameter id address.
     * @return found address object.
     */
    Address findAddressById(int idAddress);
}
