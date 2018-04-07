package com.tsystems.javaschoolshop.dao.api;

import com.tsystems.javaschoolshop.model.Category;

import java.util.List;

/**
 * This interface provide us API through which we will communicate with database.
 */
public interface CategoryDao {

    /**
     * Method should find only root categories. In our case, we have 2 root categories(Men's and women's clothes).
     * @return list of found root categories.
     */
    List<Category> findRootCategories();

    /**
     * Method should find certain category by his ID.
     * @param id of the category.
     * @return reference to a mapped Category object.
     */
    Category findCategoryById(int id);

    /**
     * Method should find categories by hierarchy number.
     * @param hierarchyNumber - directly, the number.
     * @return list of found categories.
     */
    List<Category> findCategoryByHierarchyNumber(int hierarchyNumber);

    /**
     * Method should save Category in database.
     * @param category reference to a Category object which we need to save.
     */
    void saveCategory(Category category);
}
