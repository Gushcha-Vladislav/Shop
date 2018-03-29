package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Secured({"ROLE_USER","ROLE_ANONYMOUS"})
    @RequestMapping(value = {"/","/catalog"}, method = RequestMethod.GET)
    public ModelAndView showProductsList() {
        ModelAndView modelAndView=new ModelAndView("productList");
        modelAndView.addObject("products",productService.findAllProducts(false));
        modelAndView.addObject("categories",categoryService.findRootCategories());
        return modelAndView;
    }

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET)
    public ModelAndView showProductPage(final @PathVariable("id") int id) {
        ModelAndView modelAndView;
        Product product =productService.findProductById(id,false);
        if(product != null) {
            modelAndView = new ModelAndView("product");
            modelAndView.addObject("product", product);
        }else{
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/catalog/{id}/quantity", method = RequestMethod.GET)
    @ResponseBody
    public String quantityProductById(final @PathVariable("id") int id) {

        return productService.getQuantityProductInStickById(id).toString();
    }

}
