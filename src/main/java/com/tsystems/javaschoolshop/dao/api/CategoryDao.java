package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findRootCategories();
    Category findCategoryById(int id);
    List<Category> findCategoryByHierarchyNumber(int hierarchyNumber);
    void saveCategory(Category category);
}
