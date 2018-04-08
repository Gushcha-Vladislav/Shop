package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.UserDto;
import com.tsystems.javaschoolshop.service.api.AddressService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Secured({"ROLE_USER","ROLE_ADMIN","ROLE_SUPER_ADMIN"})
@RequestMapping(value = "/account")
public class UserController extends GenericController{

    private final UserService userService;
    private final OrderService orderService;
    private final AddressService addressService;

    @Autowired
    public UserController(UserDetailsService userDetailsService, UserService userService,
                          OrderService orderService, AddressService addressService) {
        super(userDetailsService);
        this.userService = userService;
        this.orderService=orderService;
        this.addressService = addressService;
    }

    @RequestMapping(value = "", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView account(final HttpServletRequest request) {

        request.getSession().setAttribute("nameUser", userService.findUserFromSecurityContextHolder().getNameUser());
        return new ModelAndView("office", "user", userService.findUserFromSecurityContextHolder());
    }
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String accountChange(@Valid UserDto userDto, BindingResult result, final HttpServletRequest request) {
        if (result.hasErrors()) {
            return "redirect:/account";
        }
        User user =userService.findUserFromSecurityContextHolder().change(userDto);
        userService.saveUser(user);
        authenticateUserAndSetSession(user.getEmail(),request);
        return "redirect:/account";
        }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public ModelAndView changePassword() {
        return new ModelAndView("passwordManager");
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String addPassword(@RequestParam(name = "oldPassword") String oldPassword,
                                    @RequestParam(name = "newPassword") String newPassword,
                                    final HttpServletRequest request) {
        userService.changePassword(oldPassword, newPassword);
        authenticateUserAndSetSession(userService.findUserFromSecurityContextHolder().getEmail(),request);
        return "redirect:/account";
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public ModelAndView addressManager() {
        return new ModelAndView("addressesManager","user", userService.findUserFromSecurityContextHolder());
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/addresses/{id}", method = RequestMethod.POST)
    public ModelAndView deleteAddress(final @PathVariable("id") int id,final HttpServletRequest request) {
        addressService.deleteAddress(id);
        return new ModelAndView("addressItem","user",userService.findUserFromSecurityContextHolder());
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/addresses", method = RequestMethod.POST)
    public String saveAddress(@Valid Address address, BindingResult result, final HttpServletRequest request) {
        if (result.hasErrors()) {
            return "formAddress";
        }
        addressService.saveAddress(address);
        return "redirect:/account/addresses";
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/formAddress", method = RequestMethod.GET)
    public ModelAndView formAddress(final HttpServletRequest request) {
        request.getSession().setAttribute("nameUser", userService.findUserFromSecurityContextHolder().getNameUser());
        return new ModelAndView("formAddress", "address", new Address());
    }
    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView orderList() {
        return new ModelAndView("orderManager", "orders", orderService.findOrderByUser());
    }
}
