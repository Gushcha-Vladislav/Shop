package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.session.BasketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/basket")
public class BasketController {

    private final BasketProductService basketProductService;
    private final BasketBean basketBean;
    @Autowired
    public BasketController(BasketProductService basketProductService, BasketBean basketBean) {
        this.basketProductService = basketProductService;
        this.basketBean = basketBean;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String outView() {
        return "basket";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addToBag( BasketProductDto basketProductDto,
                           final @PathVariable("id") int id) {

        basketProductDto.setId(id);
        return basketProductService.addToBasket(basketProductDto,basketBean.getBasket());
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public boolean deleteProduct(final @PathVariable("id") int id) {
        return basketProductService.deleteFromBasket(id, basketBean.getBasket());
    }

    @RequestMapping(value = "/count/{id}")
    @ResponseBody
    public String countProductInBag(final @PathVariable("id") int id) {
        return basketProductService.countProductInBagById(id, basketBean.getBasket()).toString();
    }

    @RequestMapping(value = "/count")
    @ResponseBody
    public String countInBag(final HttpServletRequest request) {
        Object bag = request.getSession().getAttribute("bag");
        return new Long(basketProductService.countProductInBag((List<BasketProductDto>)bag)).toString();
    }
}
