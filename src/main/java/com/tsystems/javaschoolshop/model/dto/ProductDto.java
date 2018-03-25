package com.tsystems.javaschoolshop.model.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private Integer id;

    private String nameProduct;

    private Integer price;

    private String image;

    private Integer numberOfSales;

    public ProductDto() {
    }

    public ProductDto(Integer id, String nameProduct, Integer price, String image, Integer numberOfSales) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
        this.numberOfSales = numberOfSales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(Integer numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDto{");
        if (id != null) sb.append("id=").append(id);
        if (nameProduct != null) sb.append(", nameProduct='").append(nameProduct).append('\'');
        if (price != null) sb.append(", price=").append(price);
        if (image != null) sb.append(", image='").append(image).append('\'');
        if (numberOfSales != null) sb.append(", numberOfSales=").append(numberOfSales);
        sb.append('}');
        return sb.toString();
    }
}
