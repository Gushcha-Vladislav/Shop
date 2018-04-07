package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.model.dto.ProductSendDto;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.util.ComparatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final JmsTemplate jmsTemplate;
    private final CategoryService categoryService;
    @Autowired
    ProductServiceImpl(ProductDao productDao,JmsTemplate jmsTemplate,CategoryService categoryService) {

        this.productDao = productDao;
        this.jmsTemplate =jmsTemplate;
        this.categoryService =categoryService;
    }

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
    public List<ProductSendDto> convertProductsToProductsDto(List<Product> products) {
        List<ProductSendDto> result = new ArrayList<>();
        if (products == null) return result;
        for (Product product : products) {
            result.add(new ProductSendDto(product.getId(),product.getNameProduct(),product.getPrice(),
                    findNumberOfSalesById(product.getId()), product.getImage()));
        }
        return result;
    }

    @Override
    public void sendMessage() {
        jmsTemplate.send("advertising.stand", session -> {
            TextMessage msg = session.createTextMessage();
            msg.setText("update");
            return msg;
        });
    }
    @Override
    public List<Product> findProductByCategory(int id) {
        return categoryService.findCategoryById(id).getProducts();
    }

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
