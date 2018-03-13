package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/")
public class CommonController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    CommonController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Secured({"ROLE_USER","ROLE_ANONYMOUS"})
    @RequestMapping(value = {"/","/catalog"})
    public ModelAndView test1() {
        ModelAndView modelAndView=new ModelAndView("listProduct");
        modelAndView.addObject("products",productService.findAllProducts(false));
        modelAndView.addObject("categories",categoryService.findRootCategories());
        return modelAndView;
    }

    @Secured({"ROLE_USER","ROLE_ANONYMOUS"})
    @RequestMapping(value = "/catalog/{id}")
    public ModelAndView showProductPage(final @PathVariable("id") int id, final HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("product", productService.findProductById(id));
        return modelAndView;

    }
}
