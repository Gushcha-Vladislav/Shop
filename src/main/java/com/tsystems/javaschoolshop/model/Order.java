package com.tsystems.javaschoolshop.model;

import com.tsystems.javaschoolshop.model.enums.OrderStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentStatusEnum;
import com.tsystems.javaschoolshop.model.enums.PaymentTypeEnum;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order entity model. This class maps on orders Table in our Database.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "orders", schema = "webshopdb")
public class Order extends Generic {

    /**
     * Owner of the order. For correct working of our application we should have
     * an opportunity to get owner of every category(User). So, adding user field will help us with it.
     * JPA API allow us to get user object data and Hibernate do it.
     * This filed connected with user_id column in orders table.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * Order status value. See more about available types here {@link OrderStatusEnum}
     * This filed connects with status column in orders table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "status")
    private String orderStatus;

    /**
     * Delivery address value.
     * This filed connects with address column in orders table.
     * Cannot be nullable.
     */
    @NotNull
    @Size(max=100)
    @Column(name = "address")
    private String address;

    /**
     * Order date value.
     * This filed connects with date_order column in orders table.
     * Cannot be nullable.
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date_order")
    private Date dateOrder;

    /**
     * Payment type. See more about available types here {@link PaymentTypeEnum}
     * This filed connects with amount payment_type in payments table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "payment")
    private String payment;

    /**
     * Payment status. See more about payment status types here {@link PaymentStatusEnum}.
     * This filed connects with amount column in delivery table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "delivery")
    private String delivery;

    /**
     * Total cost of the order. Depends on all products in bag, their cost and quantity.
     * This filed connects with order_price column in payments table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "order_price")
    private Integer orderPrice;

    /**
     * List of products in order. It is obvious that customer would like to buy several
     * product for one order. Even more, customer want to to have an opportunity
     * to buy different sizes of the same products. And we had to make orders_products table where we store
     * records about order, product and size(and amount of quantity of products).
     * Hibernate allow us to get list of records described above.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersProducts> products = new ArrayList<>();

    /**
     * Empty constructor for Hibernate
     */
    public Order() {
        //Empty constructor for hibernate.
    }

    /**
     * Custom constructor to initialize all necessary fields.
     * @param user - see in field declaration.
     * @param address - see in field declaration.
     * @param dateOrder - see in field declaration.
     * @param payment - see in field declaration.
     * @param delivery- see in field declaration.
     * @param orderPrice - see in field declaration.
     */
    public Order(User user, String orderStatus, String address, Date dateOrder, String payment, String delivery, int orderPrice) {
        this.user = user;
        this.orderStatus = orderStatus;
        this.address = address;
        this.dateOrder = dateOrder;
        this.payment = payment;
        this.delivery = delivery;
        this.orderPrice = orderPrice;
    }

    /**
     * Simple getter
     * @return Order customer object
     */
    public User getUser() {
        return user;
    }

    /**
     * Simple setter
     * @param user is value to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Simple getter
     * @return Order status value
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Simple setter
     * @param orderStatus is value to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Simple getter
     * @return Delivery address value
     */
    public String getAddress() {
        return address;
    }

    /**
     * Simple setter
     * @param address is value to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Simple getter
     * @return Order date value
     */
    public Date getDateOrder() {
        return dateOrder;
    }

    /**
     * Simple setter
     * @param dateOrder is value to set
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * Simple getter
     * @return Payment type value
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Simple setter
     * @param payment is value to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * Simple getter
     * @return Payment status value
     */
    public String getDelivery() {
        return delivery;
    }

    /**
     * Simple setter
     * @param delivery is value to set
     */
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
     * Simple getter
     * @return Order cost value
     */
    public Integer getOrderPrice() {
        return orderPrice;
    }

    /**
     * Simple setter
     * @param orderPrice is value to set
     */
    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Simple getter
     * @return OrdersProducts list. To understand what it is, see description of this field and
     * OrderProducts class - {@link OrdersProducts}
     */
    public List<OrdersProducts> getProducts() {
        return products;
    }

    /**
     * Simple setter
     * @param products is value to set
     */
    public void setProducts(List<OrdersProducts> products) {
        this.products = products;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     * Some parameters may be null.
     */
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
