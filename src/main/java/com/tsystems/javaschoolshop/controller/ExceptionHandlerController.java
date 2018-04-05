package com.tsystems.javaschoolshop.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        ModelAndView modelAndView = new ModelAndView("error","message","Unknown error, return to the main page or contact the admin");
        modelAndView.addObject("exception",sw);
        return modelAndView;
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView exceptionAccess(Exception e) {
        StringWriter sw = stackTraceToString(e);
        ModelAndView modelAndView = new ModelAndView("error","message","Access error, leave the page");
        modelAndView.addObject("exception",sw);
        return modelAndView;
    }

    private StringWriter stackTraceToString(Exception e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw;
    }
}
