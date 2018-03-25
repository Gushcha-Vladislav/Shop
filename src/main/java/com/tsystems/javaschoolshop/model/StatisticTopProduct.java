package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SP")
public class StatisticTopProduct extends Statistics {

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    public StatisticTopProduct() {
    }

    public StatisticTopProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
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
        final StringBuffer sb = new StringBuffer("StatisticTopProduct{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(product!=null) sb.append("product=").append(product.toString()).append('\'');
        if(amount!=null) sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
