package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Address;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public LoginController(UserService userService,UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService=userDetailsService;
    }

    @Secured({"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @Secured({"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(User user, Address address) {
        return "signUp";
    }

    @Secured({"ROLE_ANONYMOUS"})
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@Valid Address address,@Valid User user, BindingResult result,
                        final HttpServletRequest request) {
        if (result.hasErrors()) {
            List<ObjectError> errorsValid=result.getAllErrors();
            return "signUp";

        }else{
            if (!userService.isEmailFree(user.getEmail())) return "/signUp";
            userService.saveNewUser(user,address);
            authenticateUserAndSetSession(address.getUser().getEmail(), request);
        }
        return "redirect:/catalog";
    }

    public void authenticateUserAndSetSession(final String email, final HttpServletRequest request) {
        request.getSession();
        UserDetails user = userDetailsService.loadUserByUsername(email);
        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
