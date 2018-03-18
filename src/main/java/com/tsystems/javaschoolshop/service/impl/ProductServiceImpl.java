package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAllProducts(final boolean adminMode) {
        if (adminMode) return productDao.findAllProducts();
        else return productDao.findAllProducts()
                .stream()
                .filter(Product::isStatus)
                .collect(Collectors.toList());
    }

    @Override
    public Product findProductById(int id, boolean adminMode) {
        Product product = productDao.findProductById(id);
        if (adminMode) return product;
        else return product.isStatus() ? product : null;
    }

    @Override
    public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }
}
