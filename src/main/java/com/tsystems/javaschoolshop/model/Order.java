package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders", schema = "webshopdb")
public class Order extends Generic {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "status", nullable = false)
    private String orderStatus;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "payment", nullable = false)
    private String payment;

    @Column(name = "delivery", nullable = false)
    private String delivery;

    @Column(name = "order_price", nullable = false)
    private int orderPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<OrdersProducts> products = new ArrayList<>();
    public Order() {
    }

    public Order(User user, String orderStatus, String address, Date dateOrder, String phone, String payment, String delivery, int orderPrice) {
        this.user = user;
        this.orderStatus = orderStatus;
        this.address = address;
        this.dateOrder = dateOrder;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
