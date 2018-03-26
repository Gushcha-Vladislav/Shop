package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products", schema = "webshopdb")
public class Product extends Generic {

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "name_product")
    private String nameProduct;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @NotNull
    @OrderBy()
    @Column(name = "price")
    private Integer price;

    @Size(min = 3, max = 40)
    @Column(name = "brand")
    private String brand;

    @NotNull
    @Size(max = 10)
    @Column(name = "property")
    private String property;

    @NotNull
    @Size(max = 100)
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Min(0)
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "status", nullable = false)
    private boolean status = true;

    @OneToOne(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private StatisticTopProduct statisticTopProduct = new StatisticTopProduct(this,0);

    public Product() {
    }

    public Product(String nameProduct, Category category, Integer price, String brand,
                   String property, String image, String description, Integer quantityInStock) {
        this.nameProduct = nameProduct;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.property = property;
        this.image = image;
        this.description = description;
        this.quantityInStock = quantityInStock;
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

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public StatisticTopProduct getStatisticTopProduct() {
        return statisticTopProduct;
    }

    public void setStatisticTopProduct(StatisticTopProduct statisticTopProduct) {
        this.statisticTopProduct = statisticTopProduct;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        if (getId() != null) sb.append("id=").append(getId()).append('\'');
        if (nameProduct != null) sb.append(", nameProduct='").append(nameProduct).append('\'');
        if (category != null) sb.append(", category=").append(category.toString());
        if (price != null) sb.append(", price=").append(price);
        if (brand != null) sb.append(", brand='").append(brand).append('\'');
        if (property != null) sb.append(", property='").append(property).append('\'');
        if (quantityInStock != null) sb.append(", quantityInStock=").append(quantityInStock);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return this.getId() / 100;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Product)) return false;

        Product tmp = (Product) obj;
        return tmp.getId() == this.getId();
    }
}