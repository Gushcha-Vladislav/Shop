package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketProductServiceImpl implements BasketProductService {


    private final ProductDao productDao;

    @Autowired
    public BasketProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public boolean addToBasket(BasketProductDto basketProductDto, List<BasketProductDto> basket) {

        Product product = productDao.findProductById(basketProductDto.getId());
        boolean isFoundInBag = false;
        for (BasketProductDto basketProduct : basket) {
            if (basketProduct.getId() == basketProductDto.getId()) {
                if (product.getQuantityInStock() <= basketProductDto.getAmount() - basketProduct.getAmount())
                    return false;
                basketProduct.setAmount(basketProductDto.getAmount());
                basketProduct.setPrice(basketProductDto.getPrice());
                product.setQuantityInStock(product.getQuantityInStock() - basketProductDto.getAmount() + basketProduct.getAmount());
                isFoundInBag = true;
                break;
            }
        }

        if (!isFoundInBag && product.getQuantityInStock() >= basketProductDto.getAmount()) {
            basket.add(basketProductDto);
            product.setQuantityInStock(product.getQuantityInStock() - basketProductDto.getAmount());
        } else return false;
        productDao.saveProduct(product);
        return true;
    }

    @Override
    public boolean deleteFromBasket(int id, List<BasketProductDto> basket) {

        for (BasketProductDto product : basket) {
            if (product.getId() == id) {
                Product originalProduct = productDao.findProductById(id);
                originalProduct.setQuantityInStock(originalProduct.getQuantityInStock() + product.getAmount());
                productDao.saveProduct(originalProduct);
            }
            basket.remove(product);
            break;
        }
        return true;
    }
}
