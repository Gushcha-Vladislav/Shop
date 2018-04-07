package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Product;
import java.util.List;
import java.util.Map;

/**
 * This interface provide us API through which we will communicate with database.
 */
public interface ProductDao {

    /**
     * Method should find all products in the database.
     * @return list of the found products.
     */
    List<Product> findAllProducts();

    /**
     * Method should find product in database by his ID.
     * @param id of the product.
     * @return reference to a mapped Product object.
     */
    Product findProductById(final int id);

    /**
     * Method should save some product in database.
     * @param product reference to a product object.
     * @return reference to a saved object.
     */
    Product saveProduct(Product product);

    /**
     * Method should find top 10 products of the shop.
     * @param adminMode - parameter which signalize is this top needed for admin or user.
     * @return list of found products.
     */
    List<Product> findTop10Products(boolean adminMode);

    /**
     * Method should find number of sales of the product by his ID.
     * @param id of the product.
     * @return number of sales.
     */
    int findNumberOfSalesById(int id);
}
