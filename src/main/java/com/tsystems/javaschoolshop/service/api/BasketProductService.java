package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import java.util.List;

public interface BasketProductService {
    boolean addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket);
    boolean deleteFromBasket(int id, List<BasketProductDto> basket);
}
