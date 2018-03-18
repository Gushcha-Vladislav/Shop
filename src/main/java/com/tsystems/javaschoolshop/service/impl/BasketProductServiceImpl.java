package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketProductServiceImpl implements BasketProductService {

    @Override
    public void addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket) {
        basket.add(basketProductDto);
    }
}
