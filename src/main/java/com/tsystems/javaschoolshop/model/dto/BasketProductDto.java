package com.tsystems.javaschoolshop.model.dto;

import java.io.Serializable;

public class BasketProductDto implements Serializable {

    private Integer id;
    private String nameProduct;
    private Integer amount;
    private Integer price;
    private String image;

    public BasketProductDto() {
    }

    public BasketProductDto(int id, String nameProduct, int amount, int price, String image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.price = price;
        this.image = image;
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

    @Override
    public String toString() {
        String result = "{";
        if (id != null) {
            result += "id = " + id + "; ";
        }
        result += "name = " + nameProduct + "; price = " + price + ";amount = " + amount + "}";
        return result;
    }
}
