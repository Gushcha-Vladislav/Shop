package com.tsystems.javaschoolshop.dao.impl;

import com.tsystems.javaschoolshop.dao.GenericDao;
import com.tsystems.javaschoolshop.dao.api.CategoryDao;
import com.tsystems.javaschoolshop.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Class which implements all necessary methods which allow us
 * to work with database and categories.
 */
@Repository
public class CategoryDaoImpl extends GenericDao implements CategoryDao {

    /**
     * See {@link CategoryDao}
     * @return list of found categories.
     */
    @Override
    public List<Category> findRootCategories(boolean adminMode) {
        String startQuery ="SELECT c FROM Category c WHERE parent = null";
        Query query;
        if(!adminMode) {
            query = em.createQuery(startQuery + " and status = :status");
            query.setParameter("status", true);
        }else query = em.createQuery(startQuery);
        return (List<Category>) query.getResultList();
    }

    /**
     * See {@link CategoryDao}
     * @param id of the category.
     * @return reference to a category object.
     */
    @Override
    public Category findCategoryById(int id){
        Query query = em.createQuery("SELECT p FROM Category p WHERE id = :id");
        query.setParameter("id", id);
        return (Category) query.getSingleResult();
    }

    /**
     * See {@link CategoryDao}
     * @param hierarchyNumber - directly, the number.
     * @return list of found categories.
     */
    @Override
    public List<Category> findCategoryByHierarchyNumber(int hierarchyNumber) {
        Query query = em.createQuery("SELECT p FROM Category p WHERE hierarchyNumber = :hierarchyNumber");
        query.setParameter("hierarchyNumber", hierarchyNumber);
        return (List<Category>) query.getResultList();
    }

    /**
     * Method saves category object.
     * @param category reference to a Category object which we need to save.
     * @return reference to a saved object.
     */
    @Override
    @Transactional
    public void saveCategory(Category category) {
        em.merge(category);
        em.flush();
    }
}
