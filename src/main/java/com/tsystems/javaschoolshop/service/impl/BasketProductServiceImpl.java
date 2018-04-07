package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.StatisticTopProduct;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Basket product service. It is used to bag manipulations.
 */
@Service
public class BasketProductServiceImpl implements BasketProductService {

    /**
     * Injected by spring productDao bean
     */
    private final ProductDao productDao;

    /**
     * Injecting constructor
     * @param productDao that must be injected
     */
    @Autowired
    public BasketProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Method add product to the bag.
     *
     * @param basketProductDto  - the product that will be added.
     * @param basket existing products in basket
     */
    @Override
    @Transactional
    public boolean addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket) {
        Product product = productDao.findProductById(basketProductDto.getId());
        boolean isFoundInbasket = false;
        for (BasketProductDto basketProduct : basket) {
            if (basketProduct.getId() == basketProductDto.getId()) {
                if (product.getQuantityInStock() <= basketProductDto.getAmount() - basketProduct.getAmount())
                    return false;
                basketProduct.setAmount(basketProductDto.getAmount());
                basketProduct.setPrice(basketProductDto.getPrice());
                product.setQuantityInStock(product.getQuantityInStock() - basketProductDto.getAmount() + basketProduct.getAmount());
                product.getStatisticTopProduct().setAmount(product.getStatisticTopProduct().getAmount()+ basketProductDto.getAmount() - basketProduct.getAmount());
                isFoundInbasket = true;
                break;
            }
        }

        if (!isFoundInbasket)
            if(product.getQuantityInStock() >= basketProductDto.getAmount()) {
                basket.add(basketProductDto);
                if(product.getStatisticTopProduct()==null) product.setStatisticTopProduct(new StatisticTopProduct(product,0));
                product.setQuantityInStock(product.getQuantityInStock() - basketProductDto.getAmount());
                product.getStatisticTopProduct().setAmount(product.getStatisticTopProduct().getAmount()+ basketProductDto.getAmount());
            }else return false;
        productDao.saveProduct(product);
        return true;
    }

    /**
     * Method delete product from the basket by product id.
     *
     * @param id  - id of the product that will be deleted.
     * @param basket - existing products in basket.
     */
    @Override
    @Transactional
    public boolean deleteFromBasketById(int id, List<BasketProductDto> basket) {

        for (BasketProductDto product : basket) {
            if (product.getId() == id) {
                Product originalProduct = productDao.findProductById(id);
                originalProduct.setQuantityInStock(originalProduct.getQuantityInStock() + product.getAmount());
                originalProduct.getStatisticTopProduct().setAmount(originalProduct.getStatisticTopProduct().getAmount() - product.getAmount());
                productDao.saveProduct(originalProduct);
                basket.remove(product);
                break;
            }
        }
        return true;
    }

    /**
     * Method calculates count products of the user's basket by product id.
     *
     * @param id  - id of the product that will be deleted.
     * @param basket - given list of products(BasketProductDto)
     * @return total price in String format.
     */
    @Override
    public Integer countProductsInBasketById(int id, List<BasketProductDto> basket) {
        for (BasketProductDto product : basket) {
            if (product.getId() == id) {
                return product.getAmount();
            }
        }
        return 0;
    }

    /**
     * Method calculates total price of the user's basket.
     *
     * @param basket - given list of products(BagProductDto)
     * @return total price in String format.
     */
    @Override
    public int totalPrice(List<BasketProductDto> basket) {
        int totalPrice = 0;
        for (BasketProductDto product : basket) {
            totalPrice += product.getAmount() * product.getPrice();
        }
        return totalPrice;
    }

    /**
     * Method calculates count products of the user's basket.
     *
     * @param basket - given list of products(BasketProductDto)
     * @return total price in String format.
     */
    @Override
    public Integer countProductsInBasket(List<BasketProductDto> basket) {
        int count = 0;
        for (BasketProductDto product : basket) {
            count += product.getAmount();
        }
        return count;
    }

    /**
     * Method delete all product from the basket.
     *
     * @param basket - existing products in basket.
     */
    @Override
    @Transactional
    public List<BasketProductDto> deleteFromBasket(List<BasketProductDto> basket) {
        for (BasketProductDto product : basket) {
            Product originalProduct = productDao.findProductById(product.getId());
            originalProduct.setQuantityInStock(originalProduct.getQuantityInStock() + product.getAmount());
            originalProduct.getStatisticTopProduct().setAmount(originalProduct.getStatisticTopProduct().getAmount() - product.getAmount());
            productDao.saveProduct(originalProduct);
        }

        return new ArrayList<>();
    }

    /**
     * During the application execution we should have a possibility
     *
     * to convert our Product {@link Product}
     * to basket product object {@link BasketProductDto}.
     * @param product that will be converted
     * @return converted basketProductDto
     */
    @Override
    public  BasketProductDto createBasketProductFromProduct(Product product) {
        return new BasketProductDto (product.getId(),product.getNameProduct(), 1,
                product.getPrice(), product.getImage());
    }

    /**
     * During the application execution we should have a possibility
     *
     * to convert our basket product(basketProductDto as you remember {@link BasketProductDto})
     * to simple Product object {@link Product}.
     * @param basketProductDto one.
     * @return converted Product object.
     */
    @Override
    public Product convertBasketProductDtoToProduct(BasketProductDto basketProductDto) {
        if (basketProductDto == null) return null;
        return productDao.findProductById(basketProductDto.getId());
    }

}
