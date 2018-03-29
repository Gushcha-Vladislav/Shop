package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.CategoryDao;
import com.tsystems.javaschoolshop.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryDaoImpl extends GenericDao implements CategoryDao {

    @Override
    public List<Category> findRootCategories() {
        Query query = em.createQuery("SELECT c FROM Category c WHERE parent = null");
        return (List<Category>) query.getResultList();
    }

    @Override
    public Category findCategoryById(int id){
        Query query = em.createQuery("SELECT p FROM Category p WHERE id = :id");
        query.setParameter("id", id);
        return (Category) query.getSingleResult();
    }
}
