package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Class which implements all necessary methods which allow us
 * to work with database and categories.
 */
@Repository
public class ProductDaoImpl extends GenericDao implements ProductDao {

    /**
     * See {@link ProductDao}
     * @return list of found products.
     */
    @Override
    public List<Product> findAllProducts() {
        Query query = em.createQuery("SELECT c FROM Product c");
        return (List<Product>) query.getResultList();
    }

    /**
     * See {@link ProductDao}
     * @param id of the product.
     * @return reference to a found Product object
     */
    @Override
    public Product findProductById(final int id) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }

    /**
     * See {@link ProductDao}
     * @param product reference to a product object.
     * @return reference to a saved Product object.
     */
    @Override
    @Transactional
    public Product saveProduct(Product product) {
        Product saved = em.merge(product);
        em.flush();
        return saved;
    }

    /**
     * See {@link ProductDao}
     * @param adminMode - parameter which signalize is this top needed for admin or user.
     * @return list of found products.
     */
    @Override
    public List<Product> findTop10Products(boolean adminMode) {
        String temp ="SELECT c.product FROM StatisticTopProduct c ";
        Query topListQuery;
        if(!adminMode) topListQuery= em.createQuery(temp+"WHERE c.product.status = TRUE ORDER BY c.sales DESC", Product.class);
        else topListQuery= em.createQuery(temp+" ORDER BY c.sales DESC", Product.class);
        return topListQuery.setMaxResults(10).getResultList();
    }

    /**
     * See {@link ProductDao}
     * @param id of the product.
     * @return number of sales of the product by his ID.
     */
    @Override
    public int findNumberOfSalesById(int id) {
        Query query= em.createQuery("SELECT c.sales FROM StatisticTopProduct c WHERE c.product.id = :id");
        query.setParameter("id", id);
        try {
            return (int) query.getSingleResult();
        } catch (NoResultException e) {
            return  0;
        }
    }
}
