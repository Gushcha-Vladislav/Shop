package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts(final boolean adminMode);
    Product findProductById(int id, boolean adminMode);
    Product saveProduct(Product product);
    Integer getQuantityProductInStickById(int id);
    List<Product> findTop10Products(boolean adminMode);
    int findNumberOfSalesById(int id);
}
