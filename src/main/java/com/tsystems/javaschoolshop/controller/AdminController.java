package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.CategoryDto;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.OrderService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import com.tsystems.javaschoolshop.service.api.UserService;
import com.tsystems.javaschoolshop.session.filter.CatalogFilter;
import com.tsystems.javaschoolshop.util.ImageUtil;
import com.tsystems.javaschoolshop.util.pdf.ByteArrayConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping(value = "/admin")
public class AdminController {

    private static final String PARAM_CATEGORIES = "categories";
    private static final String PAGE_CATEGORY = "categoryManager";
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CatalogFilter catalogFilter;

    @Autowired
    public AdminController(final UserService userService, final OrderService orderService,
                           ProductService productService, CategoryService categoryService, CatalogFilter catalogFilter) {

        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.catalogFilter = catalogFilter;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView adminOrderList() {
        return new ModelAndView("orderManager", "orders", orderService.findAllOrder());
    }

    @RequestMapping(value = "/orderStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean orderStatus(final @PathVariable("status") String orderStatus,
                               final @PathVariable("id") int idOrder) {
        return orderService.changeOrderStatusById(idOrder, orderStatus);
    }

    @RequestMapping(value = "/paymentStatus/{status}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean paymentStatus(final @PathVariable("status") String paymentStatus,
                                 final @PathVariable("id") int idOrder) {
        return orderService.changePaymentStatusById(idOrder, paymentStatus);
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView showStatisticsPage() {
        ModelAndView modelAndView = new ModelAndView("statistics");
        modelAndView.addObject("topProducts", productService.convertProductsToProductsDto(
                productService.findTop10Products(true)));
        modelAndView.addObject("topUsers", userService.findTopNUsers());
        modelAndView.addObject("incomePerWeek", orderService.findRevenuePerNDay(8));
        modelAndView.addObject("incomePerMonth", orderService.findRevenuePerNDay(31));
        return modelAndView;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showFormProduct() {

        return new ModelAndView("formProduct", PARAM_CATEGORIES, categoryService.findCategoryByHierarchyNumber(2));
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@RequestParam("image") MultipartFile image, @Valid ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/product";
        }
        ImageUtil.createImagesDirectoryIfNeeded();
        Product product = productService.createProduct(productDto);
        ImageUtil.uploadImage(String.valueOf(product.getId()), image);
        return "redirect:/account";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ModelAndView addOrChangeCategories(@Valid CategoryDto categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(PAGE_CATEGORY, PARAM_CATEGORIES, categoryService.findRootCategories(true));
        }
        if (categoryDto.getId() == 0) categoryService.saveCategory(categoryDto);
        else categoryService.changeCategory(categoryDto);
        return new ModelAndView(PAGE_CATEGORY, PARAM_CATEGORIES, categoryService.findRootCategories(true));
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView showCategories() {
        return new ModelAndView(PAGE_CATEGORY, PARAM_CATEGORIES, categoryService.findRootCategories(true));
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean changeHierarchy(@PathVariable("id") int idCategory) {
        if (idCategory == 0) return true;
        return categoryService.findCategoryById(idCategory).getHierarchyNumber() == 2;
    }

    @RequestMapping(value = "/categories/status/{id}", method = RequestMethod.GET)
    public ModelAndView changeStatusCategory(@PathVariable("id") int idCategory) {
        categoryService.changeStatus(idCategory);
        return new ModelAndView(PAGE_CATEGORY, PARAM_CATEGORIES, categoryService.findRootCategories(true));

    }

    @RequestMapping(value = "/statistics/download/pdf")
    public ModelAndView showOrDownloadStatisticsPdf() throws IOException {
        ModelAndView modelAndView = new ModelAndView("pdfView");
        modelAndView.addObject("topProducts", productService.convertProductsToProductsDto(
                productService.findTop10Products(true)));
        modelAndView.addObject("topUsers", userService.findTopNUsers());
        modelAndView.addObject("incomePerWeek", orderService.findRevenuePerNDay(8));
        modelAndView.addObject("incomePerMonth", orderService.findRevenuePerNDay(31));
        Map<Integer, Byte[]> imageMap = new HashMap<>();
        for (Product product : productService.findTop10Products(true)) {
            File serverFile = new File(ImageUtil.getAbsoluteRootPath() + product.getImage());
            imageMap.put(product.getId(), ByteArrayConverterUtil.convertBytes(Files.readAllBytes(serverFile.toPath())));
        }
        modelAndView.addObject("imagesMap", imageMap);
        return modelAndView;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView showProductsList() {
        catalogFilter.setIdCategory(0);
        catalogFilter.setTypeCort(0);
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", productService.findAllProducts(true));
        modelAndView.addObject(PARAM_CATEGORIES, categoryService.findRootCategories(true));
        modelAndView.addObject("mode", productService.findAllProducts(false));
        return modelAndView;
    }

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET)
    public ModelAndView showProductPage(final @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("product", "product", productService.findProductById(id, true));
        modelAndView.addObject(PARAM_CATEGORIES, categoryService.findCategoryByHierarchyNumber(2));
        modelAndView.addObject("mode", true);
        return modelAndView;
    }

    @RequestMapping(value = "/catalog/change", method = RequestMethod.POST)
    public String changeProduct(@Valid ProductDto productDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/catalog/" + productDto.getId();
        }
        productService.changeProduct(productDto);
        return "redirect:/catalog/" + productDto.getId();
    }
}
