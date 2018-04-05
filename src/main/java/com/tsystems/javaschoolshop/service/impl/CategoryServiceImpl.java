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

    @Override
    public  Category findCategoryById(int id){
        return categoryDao.findCategoryById(id);
    }

    @Override
    public List<Category> findCategoryByHierarchyNumber(int hierarchyNumber) {
        return categoryDao.findCategoryByHierarchyNumber(hierarchyNumber);
    }

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
