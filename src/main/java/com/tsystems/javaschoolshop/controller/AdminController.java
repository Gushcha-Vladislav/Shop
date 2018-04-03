package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.service.api.UserService;
import com.tsystems.javaschoolshop.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final CategoryService categoryService;
    @Autowired
    public AdminController(final UserService userService, final OrderService orderService,
                           ProductService productService, CategoryService categoryService) {

        this.userService = userService;
        this.orderService=orderService;
        this.productService =productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView adminOrderList(){
        return new ModelAndView("orderManager","orders",orderService.findAllOrder());
    }

    @RequestMapping(value = "/orderStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean orderStatus(final @PathVariable("status") String orderStatus,
                            final @PathVariable("id") int idOrder){
        return orderService.changeOrderStatusById(idOrder,orderStatus);
    }
    @RequestMapping(value = "/paymentStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean paymentStatus(final @PathVariable("status") String paymentStatus,
                            final @PathVariable("id") int idOrder){
        return orderService.changePaymentStatusById(idOrder,paymentStatus);
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView showStatisticsPage() {
        ModelAndView modelAndView = new ModelAndView("statistics");
        modelAndView.addObject("topProducts", productService.convertProductsToProductsDto(
                productService.findTop10Products(true)));
        modelAndView.addObject("topUsers", userService.findTopNUsers());
        modelAndView.addObject("incomePerWeek", orderService.findRevenuePerNDay(31));
        modelAndView.addObject("incomePerMonth", orderService.findRevenuePerNDay(8));
        return modelAndView;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showFormProduct() {

        return new ModelAndView("formProduct", "categories", categoryService.findCategoryByHierarchyNumber(2));
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@RequestParam("image") MultipartFile image,@Valid ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/product";
        }
        ImageUtil.createImagesDirectoryIfNeeded();
        Product product = productService.createProduct(productDto);
        ImageUtil.uploadImage(String.valueOf(product.getId()),image);
        return "redirect:/account";
    }
}
