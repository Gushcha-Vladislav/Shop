package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import java.util.List;

public interface ProductService {

    List<Product> findAllProducts(final boolean adminMode);
    Product findProductById(int id, boolean adminMode);
    Product saveProduct(Product product);
    Integer getQuantityProductInStickById(int id);
    List<Product> findTop10Products(boolean adminMode);
    List<ProductDto> convertProductsToProductsDto(List<Product> products);
    List<ProductDto> findTop10ProductsDto(boolean adminMode);
}
