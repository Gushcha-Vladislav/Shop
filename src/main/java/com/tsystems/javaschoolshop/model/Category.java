package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "webshopdb")
public class Category extends Generic {

    @Column(name = "hierarchy_number", nullable = false)
    private String hierarchyNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_parent")
    private Category parent;

    @Column(name = "name_category", nullable = false, length = 20)
    private String nameCategory;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    List<Category> children = new ArrayList<>();

    public Category() {
    }

    public Category(String hierarchyNumber, Category parent, String nameCategory, boolean status) {
        this.hierarchyNumber = hierarchyNumber;
        this.parent = parent;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    public String getHierarchyNumber() {
        return hierarchyNumber;
    }

    public void setHierarchyNumber(String hierarchyNumber) {
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
}
