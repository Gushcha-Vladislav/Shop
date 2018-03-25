package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.service.api.BasketProductService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.service.api.UserService;
import com.tsystems.javaschoolshop.session.BasketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@Secured({"ROLE_USER"})
@RequestMapping(value = "/")
public class OrderController {

    private final OrderService orderService;
    private final BasketBean basketBean;
    private final UserService userService;
    private final BasketProductService basketProductService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, BasketBean basketBean,ProductService productService,
                           UserService userService, BasketProductService basketProductService) {
        this.orderService = orderService;
        this.basketBean = basketBean;
        this.userService = userService;
        this.basketProductService=basketProductService;
        this.productService =productService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView orderPage () {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("totalPriceForPay", basketProductService.totalPrice((basketBean.getBasket())));
        modelAndView.addObject("user", userService.findUserFromSecurityContextHolder());
        modelAndView.addObject("basket", basketBean.getBasket());
        return modelAndView;
    }

    @RequestMapping(value = "/order/pay")
    public String orderPay(@RequestParam(name = "idAddress") int idAddress,
                           @RequestParam(name = "paymentType") String paymentType) {

        Order order = orderService.saveOrder(idAddress,paymentType,(basketBean.getBasket()));
        orderService.sendMessage(order,userService.findUserFromSecurityContextHolder(),basketBean.getBasket(),idAddress);
        basketBean.setBasket(new ArrayList<>());
        try {
            productService.sendMessage();
        } catch (JmsException e) {
        }
        return "redirect:/catalog";
    }
}
