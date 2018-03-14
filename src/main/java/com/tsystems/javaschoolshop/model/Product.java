package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products", schema = "webshopdb")
public class Product extends Generic {

    @NotNull
    @Size(min=3,max=20)
    @Column(name = "name_product")
    private String nameProduct;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;

    @NotNull
    @OrderBy
    @Column(name = "price")
    private int price;

    @Size(min=3, max=50)
    @Column(name = "brand")
    private String brand;

    @NotNull
    @Size(max=10)
    @Column(name = "property")
    private String property;

    @NotNull
    @Size(max=100)
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Min(0)
    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @NotNull
    @Column(name = "quantity_sold")
    private int quantitySold;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Product() {
    }

    public Product(String nameProduct, Category category, int price, String brand, String property, String image, String description) {
        this.nameProduct = nameProduct;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.property = property;
        this.image = image;
        this.description = description;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{id = "+getId()+"; name ="+nameProduct+"; category = "+category.toString()+
                "; status = "+status+"}";
    }
}