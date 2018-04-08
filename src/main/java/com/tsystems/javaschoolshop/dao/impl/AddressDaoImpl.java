package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.AddressDao;
import com.tsystems.javaschoolshop.model.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Class which implements all necessary methods which allow us
 * to work with database and users.
 */
@Repository
public class AddressDaoImpl extends GenericDao implements AddressDao {


    /**
     * See {@link AddressDao}
     * @param idAddress of the address.
     * @return reference to an found Address object.
     */
    @Override
    public Address findAddressById(int idAddress) {
        Query query = em.createQuery("SELECT u FROM Address u WHERE id = :id");
        query.setParameter("id", idAddress);
        return (Address) query.getSingleResult();
    }
}
