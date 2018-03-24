package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
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

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        Product saved = em.merge(product);
        em.flush();
        return saved;
    }

    @Override
    public List<Product> findTop10Products(boolean adminMode) {
        String subQuery = "SELECT MIN(p1.id), p1.order.id, p1.product.id FROM OrdersProducts p1"
                + " GROUP BY(p1.order.id, p1.product.id)";
        Query topListQuery;
        if (adminMode) {
            topListQuery = em.createQuery("SELECT p.product.id FROM OrdersProducts p"
                    + " WHERE (p.id, p.order.id, p.product.id) IN(" + subQuery + ") GROUP BY p.product.id"
                    + " ORDER BY COUNT(p.product.id) DESC");
        } else {
            topListQuery = em.createQuery("SELECT p.product.id FROM OrdersProducts p"
                    + " WHERE (p.id, p.order.id, p.product.id) IN(" + subQuery + ") AND p.product.active=true GROUP BY p.product.id"
                    + " ORDER BY COUNT(p.product.id) DESC");
        }
        topListQuery.setMaxResults(10);
        List<Product> products = new ArrayList<>();
        for (Integer id : (List<Integer>)topListQuery.getResultList()) {
            products.add(findProductById(id));
        }
        return products;
    }
}
