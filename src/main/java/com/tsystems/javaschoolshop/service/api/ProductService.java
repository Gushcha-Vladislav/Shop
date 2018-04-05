package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.model.dto.ProductSendDto;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts(final boolean adminMode);
    Product findProductById(int id, boolean adminMode);
    Product saveProduct(Product product);
    Integer getQuantityProductInStickById(int id);
    List<Product> findTop10Products(boolean adminMode);
    int findNumberOfSalesById(int id);
    void sendMessage();
    List<ProductSendDto> convertProductsToProductsDto (List<Product> products);
    List<Product> findProductByCategory(int id);
    Product createProduct(ProductDto productDto);
    void changeProduct(ProductDto productDto);
    List<Product> filter(int idCategory,int typeSort, boolean adminMode);
}
