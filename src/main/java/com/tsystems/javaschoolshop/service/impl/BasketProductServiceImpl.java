package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.ProductDao;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean deleteFromBasketById(int id, List<BasketProductDto> basket) {

        for (BasketProductDto product : basket) {
            if (product.getId() == id) {
                Product originalProduct = productDao.findProductById(id);
                originalProduct.setQuantityInStock(originalProduct.getQuantityInStock() + product.getAmount());
                productDao.saveProduct(originalProduct);
                basket.remove(product);
            }
            break;
        }
        return true;
    }

    @Override
    public Integer countProductsInBagById(int id, List<BasketProductDto> basket) {
        for (BasketProductDto product : basket) {
            if (product.getId() == id) {
                return product.getAmount();
            }
        }
        return 0;
    }

    @Override
    public int totalPrice(List<BasketProductDto> basket) {
        int totalPrice = 0;
        for (BasketProductDto product : basket) {
            totalPrice += product.getAmount() * product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public Integer countProductsInBag(List<BasketProductDto> basket) {
        int count = 0;
        for (BasketProductDto product : basket) {
            count += product.getAmount();
        }
        return count;
    }

    @Override
    public List<BasketProductDto> deleteFromBasket(List<BasketProductDto> basket) {
        for (BasketProductDto product : basket) {
            Product originalProduct = productDao.findProductById(product.getId());
            originalProduct.setQuantityInStock(originalProduct.getQuantityInStock() + product.getAmount());
            productDao.saveProduct(originalProduct);
        }

        return new ArrayList<>();
    }
    @Override
    public  BasketProductDto createBagProductFromProduct(Product product) {
        return new BasketProductDto (product.getId(),product.getNameProduct(), 1,
                product.getPrice(), product.getImage());
    }

    @Override
    public Product convertBasketProductDtoToProduct(BasketProductDto basketProductDto) {
        if (basketProductDto == null) return null;
        return productDao.findProductById(basketProductDto.getId());
    }

}
