package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class UserController extends GenericController{

    private final UserService userService;

    @Autowired

    public UserController(UserDetailsService userDetailsService, UserService userService) {
        super(userDetailsService);
        this.userService = userService;
    }

    @RequestMapping(value = "/account", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView account() {
        return new ModelAndView("office", "user", userService.findUserFromSecurityContextHolder());
    }
    @RequestMapping(value = "/account/change", method = RequestMethod.POST)
    public String accountChange(User user) {
        return "redirect:/account";
        }

    @RequestMapping(value = "/account/password", method = RequestMethod.GET)
    public ModelAndView changePassword() {
        return new ModelAndView("passwordManager");
    }

    @RequestMapping(value = "/account/password", method = RequestMethod.POST)
    public String addPassword(@RequestParam(name = "oldPassword") String oldPassword,
                                    @RequestParam(name = "newPassword") String newPassword,
                                    final HttpServletRequest request) {
        userService.changePassword(oldPassword, newPassword);
        authenticateUserAndSetSession(userService.findUserFromSecurityContextHolder().getEmail(),request);
        return "redirect:/account";
    }

    @RequestMapping(value = "/account/addresses", method = RequestMethod.GET)
    public ModelAndView addressManager() {
        return new ModelAndView("addressesManager","user", userService.findUserFromSecurityContextHolder());
    }
    @RequestMapping(value = "/account/addresses/{id}", method = RequestMethod.POST)
    public ModelAndView deleteAddress(final @PathVariable("id") int id, final HttpServletRequest request) {
        userService.deleteAddress(id);
        authenticateUserAndSetSession(userService.findUserFromSecurityContextHolder().getEmail(),request);
        return new ModelAndView("addressItem","user",userService.findUserFromSecurityContextHolder());
    }
    @RequestMapping(value = "/account/addresses", method = RequestMethod.POST)
    public String addAddress(Address address, final HttpServletRequest request) {
        userService.saveAddress(address);
        authenticateUserAndSetSession(userService.findUserFromSecurityContextHolder().getEmail(),request);
        return "redirect:/account/addresses";
    }
}
