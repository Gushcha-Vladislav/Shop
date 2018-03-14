package com.tsystems.javaschoolshop.model;

import org.hibernate.annotations.SQLInsert;

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
    private String hierarchyNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_parent")
    private Category parent;

    @NotNull
    @Size(min=3, max=45)
    @Column(name = "name_category")
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

    @Override
    public String toString() {
        String result="{id = "+getId()+"; name category = "+nameCategory;
        if(parent!=null) result+="; parent = "+parent.toString();
        return result+"status= "+status+"}";
    }
}
