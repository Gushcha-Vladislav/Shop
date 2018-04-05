package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.model.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<Category> findRootCategories();
    Category findCategoryById(int id);
    List<Category> findCategoryByHierarchyNumber(int hierarchyNumber);
    void changeCategory(CategoryDto categoryDto);
    boolean changeStatus(int idCategory);
}
