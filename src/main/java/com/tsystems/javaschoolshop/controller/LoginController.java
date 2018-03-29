package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Secured({"ROLE_ANONYMOUS","ROLE_SUPER_ADMIN"})
public class LoginController extends GenericController{

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService,UserDetailsService userDetailsService) {
        super(userDetailsService);
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        return new ModelAndView("formUser","user",new User());
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
    public String signUp(@Valid User user, BindingResult result,
                         final HttpServletRequest request) {
        if (result.hasErrors()) {
            return "formUser";
        }else{
            if (!userService.isEmailFree(user.getEmail())) return "formUser";
            userService.createUser(user, UserRoleEnum.ROLE_USER.name());
            authenticateUserAndSetSession(user.getEmail(), request);
        }
        return "redirect:/account/formAddress";
    }
}
