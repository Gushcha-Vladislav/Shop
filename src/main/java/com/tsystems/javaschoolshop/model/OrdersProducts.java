package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders_products", schema = "webshopdb")
public class OrdersProducts extends Generic {

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private Product product;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    @NotNull

    public OrdersProducts() {
    }

    public OrdersProducts(Order order, Product product, int amount, int priceOne) {
        this.order = order;
        this.product = product;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrdersProducts{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(order!=null) sb.append(", order=").append(order.toString());
        if(product!=null) sb.append(", product=").append(product.toString());
        if(amount!=null) sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
