package com.tsystems.javaschoolshop.controller;

import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import com.tsystems.javaschoolshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/superAdmin")
public class SuperAdminController {

    private static final String PARAM_ADMINS = "admins";
    private static final String PAGE_ADMIN = "adminManager";
    private final UserService userService;

    @Autowired
    public SuperAdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/manager")
    public ModelAndView showManageAdminsPage() {
        return new ModelAndView(PAGE_ADMIN,PARAM_ADMINS, userService.findSimpleAdmins());
    }
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public ModelAndView addNewAdmin(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView(PAGE_ADMIN,PARAM_ADMINS, userService.findSimpleAdmins());
        }else{
            if (!userService.isEmailFree(user.getEmail())) return new ModelAndView(PAGE_ADMIN,PARAM_ADMINS, userService.findSimpleAdmins());
            userService.createUser(user, UserRoleEnum.ROLE_ADMIN.name());
        }
        return new ModelAndView(PAGE_ADMIN,PARAM_ADMINS, userService.findSimpleAdmins());
    }

    @RequestMapping(value = "/manager/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addNewAdmin(final @PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ModelAndView("adminItem",PARAM_ADMINS, userService.findSimpleAdmins());
    }

}
