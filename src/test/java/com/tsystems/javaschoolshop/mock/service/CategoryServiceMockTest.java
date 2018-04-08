package com.tsystems.javaschoolshop.mock.service;

import com.tsystems.javaschoolshop.dao.impl.CategoryDaoImpl;
import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.model.dto.CategoryDto;
import com.tsystems.javaschoolshop.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceMockTest {

    private Category category = new Category();
    private List<Category> categories = new ArrayList<>();

    @Mock
    CategoryDaoImpl categoryDao;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Before
    public void init() {
        category.setStatus(true);
        category.setId(0);
        category.setNameCategory("Name");
        category.setHierarchyNumber(1);

        Category category1 = new Category();
        category1.setStatus(true);
        category1.setId(1);
        category1.setParent(null);
        category1.setNameCategory("Category1");
        category1.setHierarchyNumber(2);
        category1.setProducts(new ArrayList<>());
        List<Category> child = new ArrayList<>();
        child.add(category);
        category1.setChildren(child);
        category.setParent(category1);


        Category category2 = new Category();
        category2.setStatus(false);
        category2.setId(2);
        category2.setParent(null);
        category2.setNameCategory("Category2");
        category2.setHierarchyNumber(2);
        category2.setChildren(new ArrayList<>());

        Category category3 = new Category();
        category3.setStatus(true);
        category3.setId(3);
        category3.setParent(null);
        category3.setNameCategory("Category3");
        category3.setHierarchyNumber(2);

        categories.addAll(Arrays.asList(category1, category2, category3));
    }

    @Test
    public void saveNewCategoryMockTest1() {
        CategoryDto categoryDto =new CategoryDto(0,"Name");
        Category category = new Category(1, null,"Name",false);
        //do
        categoryService.saveCategory(categoryDto);
        //check
        Mockito.verify(categoryDao).saveCategory(category);
    }


    @Test
    public void findCategoryByIdMockTest1() {
        //prepare
        Mockito.when(categoryDao.findCategoryById(categories.get(0).getId())).thenReturn(categories.get(0));
        //do
        categoryService.findCategoryById(categories.get(0).getId());
        //check
        Mockito.verify(categoryDao).findCategoryById(categories.get(0).getId());
    }

    @Test
    public void findCategoryByIdMockTest2() {
        //prepare
        Mockito.when(categoryDao.findCategoryById(categories.get(0).getId())).thenReturn(categories.get(0));
        //do
        Category result = categoryService.findCategoryById(categories.get(0).getId());
        //check
        Mockito.verify(categoryDao).findCategoryById(categories.get(0).getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(categories.get(0).getId(), result.getId());
    }


    @Test
    public void findRootCategoriesMockTest1() {
        //prepare
        Mockito.when(categoryDao.findRootCategories(true)).thenReturn(categories);
        //do
        categoryService.findRootCategories(true);
        //check
        Mockito.verify(categoryDao).findRootCategories(true);
    }

    @Test
    public void findCategoriesByHierarchyNumberMockTest1() {
        //prepare
        Mockito.when(categoryDao.findCategoryByHierarchyNumber(1)).thenReturn(categories);
        //do
        List<Category> result = categoryService.findCategoryByHierarchyNumber(1);
        //check
        Mockito.verify(categoryDao).findCategoryByHierarchyNumber(1);
    }

    @Test
    public void findCategoriesByHierarchyNumberMockTest2() {
        //prepare
        Mockito.when(categoryDao.findCategoryByHierarchyNumber(1)).thenReturn(categories);
        //do
        List<Category> result = categoryService.findCategoryByHierarchyNumber(1);
        //check
        Mockito.verify(categoryDao).findCategoryByHierarchyNumber(1);
        Assert.assertTrue(result.size() == categories.size());
    }

    @Test
    public void changeCategoryMockTest1() {
        Mockito.when(categoryDao.findCategoryById(categories.get(1).getId())).thenReturn(categories.get(1));

        CategoryDto categoryDto =new CategoryDto(1,"Name");
        categoryDto.setId(2);
        //do
        categoryService.changeCategory(categoryDto);

        //check
        Category category = categories.get(1);
        category.setNameCategory("Name");
        Mockito.verify(categoryDao).saveCategory(category);
    }

    @Test
    public void changeCategoryMockTest2() {
        Mockito.when(categoryDao.findCategoryById(categories.get(0).getId())).thenReturn(categories.get(0));

        CategoryDto categoryDto =new CategoryDto(3,"Hello");
        categoryDto.setId(1);
        Category category = categories.get(0);
        category.setNameCategory("Hello");
        category.setParent(categories.get(2));
        //do
        categoryService.changeCategory(categoryDto);
        //check
        Mockito.verify(categoryDao).saveCategory(category);
    }
    @Test
    public void changeStatusCategoryMockTest1() {
        Mockito.when(categoryDao.findCategoryById(categories.get(0).getId())).thenReturn(categories.get(0));

        Category category = categories.get(0);
        category.setStatus(!category.isStatus());
        //do
        categoryService.changeStatus(1);
        //check
        Mockito.verify(categoryDao).saveCategory(category);
    }
}
