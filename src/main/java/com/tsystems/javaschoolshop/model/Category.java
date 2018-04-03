package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "webshopdb")
public class Category extends Generic {

    @NotNull
    @Column(name = "hierarchy_number")
    private Integer hierarchyNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_parent")
    private Category parent;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "status", nullable = false)
    private boolean status = true;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(int hierarchyNumber, Category parent, String nameCategory, boolean status) {
        this.hierarchyNumber = hierarchyNumber;
        this.parent = parent;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    public Integer getHierarchyNumber() {
        return hierarchyNumber;
    }

    public void setHierarchyNumber(Integer hierarchyNumber) {
        this.hierarchyNumber = hierarchyNumber;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

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
