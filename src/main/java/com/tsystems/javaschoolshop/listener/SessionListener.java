package com.tsystems.javaschoolshop.listener;


import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;


public class SessionListener implements ServletContextListener, HttpSessionListener {

    @Autowired
    private ProductService productService;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setMaxInactiveInterval(60*60*2);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        List<BasketProductDto> bag = (List<BasketProductDto>) httpSessionEvent.getSession().getAttribute("bag");
        if (httpSessionEvent.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST") != null) return;
        for (BasketProductDto productDto : bag) {
            Product product = productService.findProductById(productDto.getId(), true);
            product.setQuantityInStock(product.getQuantityInStock()+productDto.getAmount());
            productService.saveProduct(product);
        }
        bag.clear();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //don't need config
    }

}
