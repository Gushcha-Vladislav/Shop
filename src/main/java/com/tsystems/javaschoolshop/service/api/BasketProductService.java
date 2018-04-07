package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import java.util.List;

/**
 * Interface provide us API we can use to manipulate our Basket products.
 */
public interface BasketProductService {

    /**
     * Method add product to the basket.
     * @param basketProductDto - the product that will be added.
     * @param basket existing products in basket
     */
    boolean addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket);

    /**
     * Method delete product from the basket by product id.
     * @param id  - id of the product that will be deleted.
     * @param basket - existing products in basket.
     */
    boolean deleteFromBasketById(int id, List<BasketProductDto> basket);

    /**
     * Method calculates count products of the user's basket by product id.
     * @param id  - id of the product that will be deleted.
     * @param basket - given list of products(BasketProductDto)
     * @return total price in String format.
     */
    Integer countProductsInBasketById(int id, List<BasketProductDto> basket);
    /**
     * Method calculates total price of the user's basket.
     * @param basket - given list of products(BasketProductDto)
     * @return total price in String format.
     */
    int totalPrice(List<BasketProductDto> basket);

    /**
     * Method calculates count products of the user's basket.
     * @param basket - given list of products(BasketProductDto)
     * @return total price in String format.
     */
    Integer countProductsInBasket(List<BasketProductDto> basket);

    /**
     * Method delete all product from the basket.
     * @param basket - existing products in basket.
     */
    List<BasketProductDto> deleteFromBasket(List<BasketProductDto> basket);

    /**
     * During the application execution we should have a possibility
     * to convert our Product {@link Product}
     * to basket product object {@link BasketProductDto}.
     * @param product that will be converted
     * @return converted basketProductDto
     */
    BasketProductDto createBasketProductFromProduct(Product product);

    /**
     * During the application execution we should have a possibility
     * to convert our basket product(basketProductDto as you remember {@link BasketProductDto})
     * to simple Product object {@link Product}.
     * @param basketProductDto one.
     * @return converted Product object.
     */
    Product convertBasketProductDtoToProduct(BasketProductDto basketProductDto);
}
