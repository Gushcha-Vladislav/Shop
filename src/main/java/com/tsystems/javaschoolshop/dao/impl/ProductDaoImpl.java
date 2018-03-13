package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImpl extends GenericDao implements ProductDao {

    @Override
    public List<Product> findAllProducts() {
        Query query = em.createQuery("SELECT c FROM Product c");
        return (List<Product>) query.getResultList();
    }

    @Override
    public Product findProductById(final int id) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }
}
