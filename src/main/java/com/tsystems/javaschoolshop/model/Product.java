package com.tsystems.javaschoolshop.model;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "webshopdb")
public class Product extends Generic {

    @Column(name = "name_product", nullable = false, length = 20)
    private String nameProduct;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "property", nullable = false, length = 10)
    private String property;

    @Column(name = "image", nullable = false, length = 100)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock;

    @Column(name = "quantity_sold", nullable = false)
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
}