package com.tsystems.javaschoolshop.listener;


import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.StatisticTopProduct;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.session.BasketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Session listener. When session is timed out it clears user bag
 * and put all items in database again.
 */
public class SessionListener implements ServletContextListener, HttpSessionListener {

    /**
     * Injected product service which allows us to work with database products.
     */
    @Autowired
    private ProductService productService;

    /**
     * Injected basket bean which allows us to work with basket products.
     */
    @Autowired
    private BasketBean basketBean;

    /**
     * Event when user's session is created.
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setMaxInactiveInterval(60*60*2);
    }

    /**
     * Event when user's session must be destroyed.
     * It also happens when user successfully becomes authorised.
     * And our goal is preventing bag clearing in this case(SPRING_SECURITY_SAVED_REQUEST).
     * In other cases we should clear bag and put items back to the database.
     */
    @Override
    @Transactional
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if (httpSessionEvent.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST") != null) return;
        for (BasketProductDto productDto : basketBean.getBasket()) {
            Product product = productService.findProductById(productDto.getId(), true);
            product.setQuantityInStock(product.getQuantityInStock()+productDto.getAmount());
            product.setStatisticTopProduct(new StatisticTopProduct(product,product.getStatisticTopProduct().getAmount() - productDto.getAmount()));
            productService.saveProduct(product);
        }
        basketBean.getBasket().clear();
    }

    /**
     * Spring can't inject any bean into listeners by standard tools.
     * And we should do it to use product service.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //don't need config
    }

}
