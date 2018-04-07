package com.tsystems.javaschoolshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * generic for all DAO, have entity manager
 */
public abstract class GenericDao {

    /**
     * It's an exemplar created by EntityManagerFactory we created and configured in DatabaseConfig class.
     * EntityManager provide us special API for working with database.
     * In particular, we can create different HQL queries. After executing that queries will give us
     * all necessary data.
     */
    @PersistenceContext
    protected EntityManager em;
}
