package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.util.ComparatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.TextMessage;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final JmsTemplate jmsTemplate;

    @Autowired
    ProductServiceImpl(ProductDao productDao,JmsTemplate jmsTemplate) {

        this.productDao = productDao;
        this.jmsTemplate =jmsTemplate;
    }

    @Override
    public List<Product> findAllProducts(final boolean adminMode) {
        if (adminMode) return productDao.findAllProducts();
        else return productDao.findAllProducts()
                .stream()
                .filter(Product::isStatus)
                .sorted(ComparatorUtil.getAscendingNameProductComparator())
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

    @Override
    public Integer getQuantityProductInStickById(int id) {
        return productDao.findProductById(id).getQuantityInStock();
    }

    @Override
    public List<Product> findTop10Products(boolean adminMode) {
        return productDao.findTop10Products(adminMode);
    }
    @Override
    public int findNumberOfSalesById(int id){
        return productDao.findNumberOfSalesById(id);
    }

    @Override
    public void sendMessage() {
        jmsTemplate.send("advertising.stand", session -> {
            TextMessage msg = session.createTextMessage();
            msg.setText("update");
            return msg;
        });
    }
}
