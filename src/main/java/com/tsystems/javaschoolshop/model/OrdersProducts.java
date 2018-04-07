package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This class maps on orders-products Table in our Database.
 * Some description put here {@link Order}
 * Customer should have a possibility to add different sizes of the same product in bag
 * and, obviously, in order. To solve this problem was used following approach:
 * orders table store records about order(including payment) and reference to a customer.
 * orders_products table store records about order(his id), product(his id), necessary size of it
 * and quantity. Therefore we can connect one order and one product with several sizes of the last.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "orders_products", schema = "webshopdb")
public class OrdersProducts extends Generic {

    /**
     * Some order. As can see above in class declaration, this table connects order and product with different sizes.
     * Hibernate allow us to get Order object from OrdersProducts object.
     * This filed connected with id_order column in orders_products table.
     */
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    /**
     * Some product. As can see above in class declaration, this table connects order and product with different sizes.
     * Hibernate allow us to get Product object from OrdersProducts object.
     * This filed connected with id_product column in orders_products table.
     */
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private Product product;

    /**
     * Product quantity of certain size.
     * This filed connects with amount column in orders_products table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "amount")
    private Integer amount;

    /**
     * Empty constructor for Hibernate
     */
    public OrdersProducts() {
        //Empty constructor for hibernate.
    }

    /**
     * Custom constructor to initialize all necessary fields.
     * @param order object.
     * @param product object.
     * @param amount value.
     */
    public OrdersProducts(Order order, Product product, int amount) {
        this.order = order;
        this.product = product;
        this.amount = amount;
    }

    /**
     * Simple getter
     * @return Order object
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Simple setter
     * @param order is object to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Simple getter
     * @return Product object
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Simple setter
     * @param product is object to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Simple getter
     * @return amount value
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Simple setter
     * @param amount is value to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
        final StringBuilder sb = new StringBuilder("OrdersProducts{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(order!=null) sb.append(", order=").append(order.toString());
        if(product!=null) sb.append(", product=").append(product.toString());
        if(amount!=null) sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
