package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findRootCategories();
}
