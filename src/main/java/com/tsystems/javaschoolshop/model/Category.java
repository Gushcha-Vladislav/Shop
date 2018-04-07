package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Category entity model. This class maps on categories Table in our Database.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "categories", schema = "webshopdb")
public class Category extends Generic {

    /**
     * Category hierarchy number value.
     * This filed connects with hierarchy_number column in categories table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "hierarchy_number")
    private Integer hierarchyNumber;

    /**
     * Category parent object. For correct working of our application we should have
     * and opportunity to get all categories hierarchy. So, adding parent field will help us with it.
     * JPA API allow us to get all parent data and Hibernate do it.
     * This filed connected with id_parent column in categories table.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_parent")
    private Category parent;

    /**
     * Category name.
     * This filed connects with name column in categories table.
     * Cannot be nullable.
     */
    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "name_category")
    private String nameCategory;

    /**
     * Category status value.
     * This filed connects with status column in categories table.
     * Cannot be nullable.
     */
    @Column(name = "status", nullable = false)
    private boolean status = false;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    /**
     * Empty constructor for hibernate.
     */
    public Category() {
    }

    /**
     * Our custom constructor.
     * @param hierarchyNumber value to set
     * @param parent object to set
     * @param nameCategory value to set
     */
    public Category(int hierarchyNumber, Category parent, String nameCategory) {
        this.hierarchyNumber = hierarchyNumber;
        this.parent = parent;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    /**
     * Simple getter
     * @return Category hierarchy number value
     */
    public Integer getHierarchyNumber() {
        return hierarchyNumber;
    }

    /**
     * Simple setter
     * @param hierarchyNumber value to set
     */
    public void setHierarchyNumber(Integer hierarchyNumber) {
        this.hierarchyNumber = hierarchyNumber;
    }

    /**
     * Simple getter
     * @return Category parent object
     */
    public Category getParent() {
        return parent;
    }

    /**
     * Simple setter
     * @param parent object to set
     */
    public void setParent(Category parent) {
        this.parent = parent;
    }

    /**
     * Simple getter
     * @return Category name value
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * Simple setter
     * @param nameCategory value to set
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    /**
     * Simple getter
     * @return Category status value
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Simple setter
     * @param status value to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Simple getter
     * @return Category list. To understand what it is, see description of this field and
     * Category class - {@link Category}
     */
    public List<Category> getChildren() {
        return children;
    }

    /**
     * Simple setter
     * @param children is value to set
     */
    public void setChildren(List<Category> children) {
        this.children = children;
    }

    /**
     * Simple getter
     * @return Product list. To understand what it is, see description of this field and
     * Product class - {@link Product}
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Simple setter
     * @param products is value to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     * Some parameters may be null.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(hierarchyNumber!=null) sb.append(", hierarchyNumber='").append(hierarchyNumber).append('\'');
        if(parent!=null) sb.append(", parent=").append(parent.toString());
        if(nameCategory!=null) sb.append(", nameCategory='").append(nameCategory).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
