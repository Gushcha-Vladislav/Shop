package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.session.filter.CatalogFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
@RequestMapping(value = "/")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final CatalogFilter catalogFilter;

    @Autowired
    ProductController(ProductService productService, CategoryService categoryService,CatalogFilter catalogFilter) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.catalogFilter = catalogFilter;
    }

    @Secured({"ROLE_USER","ROLE_ANONYMOUS"})
    @RequestMapping(value = {"/","/catalog"}, method = RequestMethod.GET)
    public ModelAndView showProductsList() {
        ModelAndView modelAndView=new ModelAndView("productList");
        modelAndView.addObject("products",productService.findAllProducts(false));
        modelAndView.addObject("categories",categoryService.findRootCategories());
        return modelAndView;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filter(@RequestParam(name = "idCategory") int idCategory,
                               @RequestParam(name = "typeSort") int typeSort) {
        if(idCategory !=-1) catalogFilter.setIdCategory(idCategory);
        if(typeSort !=-1) catalogFilter.setTypeCort(typeSort);
        return new ModelAndView("productItem","products",productService.filter(catalogFilter.getIdCategory(),catalogFilter.getTypeCort(),false));
    }
    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET)
    public ModelAndView showProductPage(final @PathVariable("id") int id) {
        ModelAndView modelAndView;
        Product product =productService.findProductById(id,false);
        if(product != null) {
            modelAndView = new ModelAndView("product");
            modelAndView.addObject("product", product);
        }else{
            modelAndView = new ModelAndView("error","message","There is no such product");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/catalog/{id}/quantity", method = RequestMethod.GET)
    @ResponseBody
    public String quantityProductById(final @PathVariable("id") int id) {

        return productService.getQuantityProductInStickById(id).toString();
    }

}
