package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Address;

/**
 * This interface provide us API through which we will communicate with database.
 */
public interface AddressDao {

    /**
     * Method should find address by his ID.
     * @param idAddress of the address.
     * @return reference to an found Address object.
     */
    Address findAddressById(int idAddress);
}
