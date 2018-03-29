package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final OrderService orderService;
    @Autowired
    public AdminController(final UserService userService, final OrderService orderService) {

        this.userService = userService;
        this.orderService=orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView adminOrderList(){
        return new ModelAndView("orderManager","orders",orderService.findAllOrder());
    }

    @RequestMapping(value = "/orderStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean orderStatus(final @PathVariable("status") String orderStatus,
                            final @PathVariable("id") int idOrder){
        return orderService.changeOrderStatusById(idOrder,orderStatus);
    }
    @RequestMapping(value = "/paymentStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean paymentStatus(final @PathVariable("status") String paymentStatus,
                            final @PathVariable("id") int idOrder){
        return orderService.changePaymentStatusById(idOrder,paymentStatus);
    }
}
