package com.tsystems.javaschoolshop.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductDto implements Serializable {

    private int id;

    @NotNull
    @Size(min = 3, max = 25)
    private String nameProduct;

    @NotNull
    private Integer idCategory;

    @NotNull
    @Min(1)
    private Integer price;

    @Size(max = 40)
    private String brand;

    @NotNull
    private String description;

    @NotNull
    @Min(0)
    private Integer quantityInStock;

    public ProductDto() {
        this.quantityInStock=0;
        this.description = "";
        this.brand = "";
        this.price = 1;
        this.idCategory =0;
        this.nameProduct = "";
    }

    public ProductDto(int id, String nameProduct, Integer idCategory,
                      Integer price, String brand, String description, Integer quantityInStock) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.idCategory = idCategory;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDto{");
        if(nameProduct!=null) sb.append("nameProduct='").append(nameProduct).append('\'');
        if(idCategory!=null) sb.append(", idCategory=").append(idCategory);
        if(price!=null) sb.append(", price=").append(price);
        if(brand!=null) sb.append(", brand='").append(brand).append('\'');
        if(description!=null) sb.append(", description='").append(description).append('\'');
        if(quantityInStock!=null) sb.append(", quantityInStock=").append(quantityInStock);
        sb.append('}');
        return sb.toString();
    }
}
