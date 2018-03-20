package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders", schema = "webshopdb")
public class Order extends Generic {

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @NotNull
    @Column(name = "status")
    private String orderStatus;

    @NotNull
    @Size(max=100)
    @Column(name = "address")
    private String address;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date_order")
    private Date dateOrder;

    @NotNull
    @Column(name = "payment")
    private String payment;

    @NotNull
    @Column(name = "delivery")
    private String delivery;

    @NotNull
    @Column(name = "order_price")
    private Integer orderPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrdersProducts> products = new ArrayList<>();
    public Order() {
    }

    public Order(User user, String orderStatus, String address, Date dateOrder, String payment, String delivery, int orderPrice) {
        this.user = user;
        this.orderStatus = orderStatus;
        this.address = address;
        this.dateOrder = dateOrder;
        this.payment = payment;
        this.delivery = delivery;
        this.orderPrice = orderPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }


    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<OrdersProducts> getProducts() {
        return products;
    }

    public void setProducts(List<OrdersProducts> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(user!=null) sb.append(", user=").append(user.toString());
        if(orderStatus!=null) sb.append(", orderStatus='").append(orderStatus).append('\'');
        if(address!=null) sb.append(", address='").append(address).append('\'');
        if(dateOrder!=null) sb.append(", dateOrder=").append(dateOrder);
        if(payment!=null) sb.append(", payment='").append(payment).append('\'');
        if(delivery!=null) sb.append(", delivery='").append(delivery).append('\'');
        if(orderPrice!=null) sb.append(", orderPrice=").append(orderPrice);
        sb.append('}');
        return sb.toString();
    }
}
