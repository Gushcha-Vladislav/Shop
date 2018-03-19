package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders_products", schema = "webshopdb")
public class OrdersProducts extends Generic {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "amount")
    private int amount;

    @NotNull
    @Column(name = "price_one")
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrdersProducts{");
        sb.append("id=").append(getId()).append('\'');
        sb.append(", order=").append(order.toString());
        sb.append(", product=").append(product.toString());
        sb.append(", amount=").append(amount);
        sb.append(", priceOne=").append(priceOne);
        sb.append('}');
        return sb.toString();
    }
}
