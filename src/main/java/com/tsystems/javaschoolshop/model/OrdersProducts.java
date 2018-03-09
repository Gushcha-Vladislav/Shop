package com.tsystems.javaschoolshop.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_products", schema = "webshopdb")
public class OrdersProducts extends Generic {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "price_one", nullable = false)
    private int priceOne;

    public OrdersProducts() {
    }

    public OrdersProducts(Order order, Product product, int amount, int priceOne) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.priceOne = priceOne;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(int priceOne) {
        this.priceOne = priceOne;
    }
}
