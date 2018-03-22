package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.UserService;
import com.tsystems.javaschoolshop.session.BasketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Secured({"ROLE_USER"})
@RequestMapping(value = "/")
public class OrderController {

    private final OrderService orderService;
    private final BasketBean basketBean;
    private final UserService userService;
    private final BasketProductService basketProductService;

    @Autowired
    public OrderController(OrderService orderService, BasketBean basketBean,
                           UserService userService, BasketProductService basketProductService) {
        this.orderService = orderService;
        this.basketBean = basketBean;
        this.userService = userService;
        this.basketProductService=basketProductService;
    }

    @RequestMapping(value = "/order")
    public ModelAndView orderPage () {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("totalPriceForPay", basketProductService.totalPrice((basketBean.getBasket())));
        modelAndView.addObject("user", userService.findUserFromSecurityContextHolder());
        return modelAndView;
    }

    @RequestMapping(value = "/order/pay")
    public String orderPay(@RequestParam(name = "idAddress") int idAddress,
                           @RequestParam(name = "paymentType") String paymentType) {

        orderService.saveOrder(idAddress,paymentType,(basketBean.getBasket()));
        return "redirect:/catalog";
    }
}
