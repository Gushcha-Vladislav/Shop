package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@Secured({"ROLE_ANONYMOUS"})
@RequestMapping(value = "/")
public class LoginController extends GenericController{

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService,UserDetailsService userDetailsService) {
        super(userDetailsService);
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(User user, Address address) {
        return "signUp";
    }


    @RequestMapping(value = "/signUp/email", method = RequestMethod.POST)
    @ResponseBody
    public boolean isEmailFree(@RequestParam(name = "email") String email) {

        return userService.isEmailFree(email);
    }
    @RequestMapping(value = "/signUp/phone", method = RequestMethod.POST)
    @ResponseBody
    public boolean isPhoneFree(@RequestParam(name = "phone") String phone) {

        return userService.isPhoneFree(phone);
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@Valid Address address,@Valid User user, BindingResult result,
                        final HttpServletRequest request) {
        if (result.hasErrors()) {
            List<ObjectError> errorsValid=result.getAllErrors();
            return "signUp";

        }else{
            if (!userService.isEmailFree(user.getEmail())) return "/signUp";
            address.setUser(user);
            user.getAddresses().add(address);
            userService.saveNewUser(user);
            authenticateUserAndSetSession(address.getUser().getEmail(), request);
        }
        return "redirect:/catalog";
    }

}
