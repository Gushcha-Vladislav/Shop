package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.CategoryDao;
import com.tsystems.javaschoolshop.model.Category;

import javax.persistence.Query;
import java.util.List;

public class CategoryDaoImpl extends GenericDao implements CategoryDao {

    @Override
    public List<Category> findRootCategories() {
        Query query = em.createQuery("SELECT c FROM Category c WHERE parent = null");
        return (List<Category>) query.getResultList();
    }
}
