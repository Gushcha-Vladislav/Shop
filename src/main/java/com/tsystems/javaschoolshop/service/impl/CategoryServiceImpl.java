package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.CategoryDao;
import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findRootCategories() {
        return categoryDao.findRootCategories();
    }
}
