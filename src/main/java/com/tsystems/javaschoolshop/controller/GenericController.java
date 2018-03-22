package com.tsystems.javaschoolshop.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public class GenericController {


    private final UserDetailsService userDetailsService;

    public GenericController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    public void authenticateUserAndSetSession(final String email, final HttpServletRequest request) {
        request.getSession();
        UserDetails user = userDetailsService.loadUserByUsername(email);
        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
