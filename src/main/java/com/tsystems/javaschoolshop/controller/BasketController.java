package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.session.BasketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Secured({"ROLE_USER","ROLE_ANONYMOUS"})
@RequestMapping(value = "/basket")
public class BasketController {

    private final BasketProductService basketProductService;
    private final BasketBean basketBean;
    @Autowired
    public BasketController(BasketProductService basketProductService, BasketBean basketBean) {
        this.basketProductService = basketProductService;
        this.basketBean = basketBean;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String basket() {
        return "basket";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addToBasketById( BasketProductDto basketProductDto,
                           final @PathVariable("id") int id) {

        basketProductDto.setId(id);
        return basketProductService.addToBasket(basketProductDto,basketBean.getBasket());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteProductsById(final @PathVariable("id") int id) {
        return basketProductService.deleteFromBasketById(id, basketBean.getBasket());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteProducts () {
        return basketProductService.deleteFromBasket(basketBean.getBasket());
    }

    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String countProductsInBagById(final @PathVariable("id") int id) {
        return basketProductService.countProductsInBagById(id, basketBean.getBasket()).toString();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String countProductsInBag() {
        return basketProductService.countProductsInBag(basketBean.getBasket()).toString();
    }
}
