package com.tsystems.javaschoolshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao {

    @PersistenceContext
    protected EntityManager em;
}
