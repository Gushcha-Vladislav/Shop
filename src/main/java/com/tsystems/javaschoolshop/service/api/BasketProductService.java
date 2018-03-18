package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import java.util.List;

public interface BasketProductService {
    boolean addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket);
    boolean deleteFromBasketById(int id, List<BasketProductDto> basket);
    Integer countProductsInBagById(int id, List<BasketProductDto> basket);
    int totalPrice(List<BasketProductDto> basket);
    Integer countProductsInBag(List<BasketProductDto> basket);
    boolean deleteFromBasket(List<BasketProductDto> basket);
}
