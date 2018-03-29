package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Product;
import java.util.List;
import java.util.Map;

public interface ProductDao {

    List<Product> findAllProducts();
    Product findProductById(final int id);
    Product saveProduct(Product product);
    List<Product> findTop10Products(boolean adminMode);
    int findNumberOfSalesById(int id);
}
