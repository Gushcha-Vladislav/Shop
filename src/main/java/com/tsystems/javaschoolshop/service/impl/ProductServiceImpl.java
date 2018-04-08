package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.model.dto.ProductSendDto;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.util.ComparatorUtil;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Interface provide us API we can use to manipulate products.
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Injected by spring productDao bean
     */
    private final ProductDao productDao;

    /**
     * This injected object allow us to send messages to the JMS server
     * without any difficulties through sendMessage() API.
     */
    private final JmsTemplate jmsTemplate;

    /**
     * Injected by spring category service bean
     */
    private final CategoryService categoryService;

    /**
     * Injecting constructor.
     * @param productDao that must be injected.
     * @param jmsTemplate that must be injected.
     * @param categoryService that must be injected.
     */
    @Autowired
    ProductServiceImpl(ProductDao productDao,JmsTemplate jmsTemplate,CategoryService categoryService) {

        this.productDao = productDao;
        this.jmsTemplate =jmsTemplate;
        this.categoryService =categoryService;
    }

    /**
     * Method finds all products in shop. If activeMode is true,
     * method will return all found products, otherwise only not hidden
     * products.
     *
     * @param adminMode see above.
     * @return list of found products.
     */
    @Override
    public List<Product> findAllProducts(final boolean adminMode) {
        if (adminMode) return productDao.findAllProducts()
                .stream().sorted(ComparatorUtil.getAscendingNameProductComparator()).collect(Collectors.toList());
        else return productDao.findAllProducts()
                .stream()
                .filter(Product::isStatus)
                .sorted(ComparatorUtil.getAscendingNameProductComparator())
                .collect(Collectors.toList());
    }

    /**
     * Method finds all products in shop by id. If activeMode is true,
     * method will return all found products, otherwise only not hidden
     * products.
     *
     * @param id products.
     * @param adminMode see above.
     * @return product.
     */
    @Override
    public Product findProductById(int id, boolean adminMode) {
        Product product = productDao.findProductById(id);
        if (adminMode) return product;
        else return product.isStatus() ? product : null;
    }

    /**
     * Method saves products.
     *
     * @param product that must be saved in database.
     * @return reference to a saved product.
     */
    @Override
    public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    /**
     * Method returns available amount by id product.
     *
     * @return available amount of size;
     */
    @Override
    public Integer getQuantityProductInStickById(int id) {
        return productDao.findProductById(id).getQuantityInStock();
    }

    /**
     * Method finds top 10 products. If activeMode is true,
     * method will return all found top products, otherwise only not hidden
     * top products.
     *
     * @param adminMode see above.
     * @return list of found products.
     */
    @Override
    public List<Product> findTop10Products(boolean adminMode) {
        return productDao.findTop10Products(adminMode);
    }

    /**
     * Method return number of sales by id product.
     *
     * @return available amount of size;
     */
    @Override
    public int findNumberOfSalesById(int id){
        return productDao.findNumberOfSalesById(id);
    }

    /**
     * Method converts list Product object {@link Product} to list ProductDto object {@link ProductSendDto}.
     *
     * @param products that must be converted.
     * @return ProductDto object as a result of converting.
     */
    @Override
    public List<ProductSendDto> convertProductsToProductsDto(List<Product> products) {
        List<ProductSendDto> result = new ArrayList<>();
        if (products == null) return result;
        for (Product product : products) {
            result.add(new ProductSendDto(product.getId(),product.getNameProduct(),product.getPrice(),
                    findNumberOfSalesById(product.getId()), product.getImage()));
        }
        return result;
    }

    /**
     * Method should try to send message to the ActiveMQ server.
     * If advertising stand application is available it will receive this message
     * and will make an attempt to update top products list.
     */
    @Logger
    @Override
    public void sendMessage() {
        jmsTemplate.send("advertising.stand", session -> {
            TextMessage msg = session.createTextMessage();
            msg.setText("update");
            return msg;
        });
    }

    /**
     * Method finds products in certain category.
     *
     * @param id  category.
     * @return list of found products.
     */
    @Override
    public List<Product> findProductByCategory(int id) {
        return categoryService.findCategoryById(id).getProducts();
    }

    /**
     * Method creates a product by productDto
     *
     * @param productDto valid version of the product without dependencies.
     * @return reference to a saved product.
     */
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product= new Product();
        product.setNameProduct(productDto.getNameProduct());
        product.setCategory(categoryService.findCategoryById(productDto.getIdCategory()));
        product.setPrice(productDto.getPrice());
        product.setBrand(productDto.getBrand());
        product.setDescription(productDto.getDescription());
        product.setQuantityInStock(productDto.getQuantityInStock());
        product.setImage("image");
        product = saveProduct(product);
        product.setImage("image/food/item"+product.getId()+".jpeg");
        product = saveProduct(product);
        return product;
    }

    /**
     * Method change a product by productDto
     *
     * @param productDto valid version of the product without dependencies.
     */
    @Override
    public void changeProduct(ProductDto productDto) {
        Product product = findProductById(productDto.getId(),false);
        product.setNameProduct(productDto.getNameProduct());
        if (productDto.getBrand().equals("")) product.setBrand(null);
        else product.setBrand(productDto.getBrand());
        if(!productDto.getIdCategory().equals(product.getCategory().getId()))
            product.setCategory(categoryService.findCategoryById(product.getCategory().getId()));
        product.setDescription(productDto.getDescription());
        product.setQuantityInStock(productDto.getQuantityInStock());
        product.setPrice(productDto.getPrice());
        productDao.saveProduct(product);
    }

    /**
     * Method filter products by their cost(lower cost bound and upper cost bound) and size
     * in certain category.
     *
     * @param idCategory - id of the selected category.
     * @param typeSort - type of product sorting.
     * @param adminMode see above.
     * @return list of found products.
     */
    @Override
    public List<Product> filter(int idCategory, int typeSort, boolean adminMode) {
        List<Product> products;
        if(idCategory == 0)  products=findAllProducts(adminMode);
        else products= findProductByCategory(idCategory);
        switch(typeSort){
            case 2:
                    return products.stream().sorted(ComparatorUtil.getAscendingNameProductComparator()).collect(Collectors.toList());
            case 3:
                    return products.stream().sorted(ComparatorUtil.getDescendingNameProductComparator()).collect(Collectors.toList());
            case 1:
                    return products.stream().sorted(ComparatorUtil.getDescendingPriceProductComparator()).collect(Collectors.toList());
            case 0:
                    return products.stream().sorted(ComparatorUtil.getAscendingPriceProductComparator()).collect(Collectors.toList());
            default:
                    return products.stream().sorted(ComparatorUtil.getAscendingPriceProductComparator()).collect(Collectors.toList());
        }
    }
}
