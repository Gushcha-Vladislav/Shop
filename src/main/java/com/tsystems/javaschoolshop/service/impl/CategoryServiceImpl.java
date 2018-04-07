package com.tsystems.javaschoolshop.service.impl;

import com.tsystems.javaschoolshop.dao.api.CategoryDao;
import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.CategoryDto;
import com.tsystems.javaschoolshop.service.api.CategoryService;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Category service. It is used to category manipulations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * Injected by spring categoryDao bean
     */
    private final CategoryDao categoryDao;

    /**
     * Injecting constructor
     * @param categoryDao - that must be injected.
     */
    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * Find root categories.
     *
     * @return list with root categories
     */
    @Override
    public List<Category> findRootCategories() {
        return categoryDao.findRootCategories();
    }

    /**
     * Find category by ID.
     * @param id of category that must be found.
     * @return found category object or null.
     */
    @Override
    public  Category findCategoryById(int id){
        return categoryDao.findCategoryById(id);
    }

    /**
     * Method finds categories by certain hierarchy number.
     *
     * @param hierarchyNumber - products with this hierarchy number must be found.
     * @return list of found categories.
     */
    @Override
    public List<Category> findCategoryByHierarchyNumber(int hierarchyNumber) {
        return categoryDao.findCategoryByHierarchyNumber(hierarchyNumber);
    }

    /**
     * Method change property categories.
     *
     * @param categoryDto contains variable data.
     */
    @Override
    public void changeCategory(CategoryDto categoryDto) {
        Category category;
        if(categoryDto.getId() ==0) {
            category=new Category();
            categoryDto.setNameCategory(categoryDto.getNameCategory());
            if(categoryDto.getIdParent() == 0){
                category.setParent(null);
                category.setHierarchyNumber(1);
            }
            else{
                category.setParent(findCategoryById(categoryDto.getIdParent()));
                category.setHierarchyNumber(2);
            }
        }
        else {
            category = findCategoryById(categoryDto.getId());
            if(!category.getNameCategory().equals(categoryDto.getNameCategory()))
                category.setNameCategory(categoryDto.getNameCategory());
            if(category.getChildren().isEmpty() && categoryDto.getIdParent()!=0){
                Category parent = findCategoryById(categoryDto.getIdParent());
                if(!category.getParent().equals(parent)) {
                    category.setParent(parent);
                    category.setHierarchyNumber(2);
                }
            }else{
                if(category.getChildren().isEmpty()){
                    category.setParent(null);
                    category.setHierarchyNumber(1);
                }
            }

        }
        category.setNameCategory(categoryDto.getNameCategory());
        categoryDao.saveCategory(category);
    }

    /**
     * Hide or show category all objects inside.
     *
     * @param idCategory id category that must be hidden or activity
     */
    @Override
    @Transactional
    public boolean changeStatus(int idCategory) {
        Category category = findCategoryById(idCategory);
        boolean status =!category.isStatus();
        category.setStatus(status);
        for(Product product : category.getProducts()){
            product.setStatus(status);
        }
        for(Category children:category.getChildren()){
            children.setStatus(status);
            for(Product product : children.getProducts()){
                product.setStatus(status);
            }
        }
        categoryDao.saveCategory(category);
        return category.isStatus();
    }
}
