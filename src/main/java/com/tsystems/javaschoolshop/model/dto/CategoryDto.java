package com.tsystems.javaschoolshop.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDto {

    private int id;
    private int idParent;

    @NotNull
    @Size(min = 3, max = 25)
    private String nameCategory;

    public CategoryDto() {
        //Empty constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
