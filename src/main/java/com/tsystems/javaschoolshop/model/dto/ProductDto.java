package com.tsystems.javaschoolshop.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductDto implements Serializable {

    @NotNull
    @Size(min = 3, max = 45)
    private String nameProduct;

    @NotNull
    private Integer idCategory;

    @NotNull
    @Min(1)
    private Integer price;

    @Size(max = 40)
    private String brand;

    @NotNull
    @Size(min=3,max = 10)
    private String property;

    @NotNull
    private String description;

    @NotNull
    @Min(0)
    private Integer quantityInStock;

    public ProductDto() {
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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
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
        if(property!=null) sb.append(", property='").append(property).append('\'');
        if(description!=null) sb.append(", description='").append(description).append('\'');
        if(quantityInStock!=null) sb.append(", quantityInStock=").append(quantityInStock);
        sb.append('}');
        return sb.toString();
    }
}
