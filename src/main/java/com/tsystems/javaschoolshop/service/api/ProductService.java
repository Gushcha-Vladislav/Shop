package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> findAllProducts(final boolean adminMode);
    Product findProductById(int id, boolean adminMode);
    Product saveProduct(Product product);
    Integer getQuantityProductInStickById(int id);
    List<Product> findTop10Products(boolean adminMode);
    int findNumberOfSalesById(int id);
    void sendMessage();
    List<ProductDto> convertProductsToProductsDto (List<Product> products);
    List<Product> findProductByCategory(int id);
}
