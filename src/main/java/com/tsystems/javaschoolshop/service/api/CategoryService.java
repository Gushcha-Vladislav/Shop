package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findRootCategories();
    Category findCategoryById(int id);
}
