package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import org.hibernate.envers.internal.tools.query.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

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
        String temp ="SELECT c.product FROM StatisticTopProduct c ";
        Query topListQuery;
        if(!adminMode) topListQuery= em.createQuery(temp+"WHERE c.product.status = TRUE ORDER BY c.amount DESC", Product.class);
        else topListQuery= em.createQuery(temp+" ORDER BY c.amount DESC", Product.class);
        return topListQuery.setMaxResults(10).getResultList();
    }

    @Override
    public int findNumberOfSalesById(int id) {
        Query query= em.createQuery("SELECT c.amount FROM StatisticTopProduct c WHERE c.product.id = :id");
        query.setParameter("id", id);
        try {
            return (int) query.getSingleResult();
        } catch (NoResultException e) {
            return  0;
        }
    }
}
