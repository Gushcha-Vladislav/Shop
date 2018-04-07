package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.model.dto.CategoryDto;

import java.util.List;

/**
 * Interface provide us API we can use to manipulate categories.
 */
public interface CategoryService {

    /**
     * Find root categories.
     * @return list with root categories
     */
    List<Category> findRootCategories();

    /**
     * Find category by ID.
     * @param id of category that must be found.
     * @return found category object or null.
     */
    Category findCategoryById(int id);

    /**
     * Method finds categories by certain hierarchy number.
     * @param hierarchyNumber - products with this hierarchy number must be found.
     * @return list of found categories.
     */
    List<Category> findCategoryByHierarchyNumber(int hierarchyNumber);

    /**
     * Method change property categories.
     * @param categoryDto contains variable data.
     */
    void changeCategory(CategoryDto categoryDto);

    /**
     * Hide or show category all objects inside.
     * @param idCategory id category that must be hidden or activity
     */
    boolean changeStatus(int idCategory);
}
