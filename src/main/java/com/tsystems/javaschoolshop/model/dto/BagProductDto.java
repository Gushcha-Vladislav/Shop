package com.tsystems.javaschoolshop.model.dto;

import java.io.Serializable;

public class BagProductDto implements Serializable {

    private String nameProduct;
    private int idProduct;
    private int amount;
    private int price;
    private String image;

    public BagProductDto() {
    }

    public BagProductDto(String nameProduct, int idProduct, int amount, int price, String image) {
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
