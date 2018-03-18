package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Product;
import java.util.List;

public interface ProductDao {

    List<Product> findAllProducts();
    Product findProductById(final int id);
    Product saveProduct(Product product);
}
