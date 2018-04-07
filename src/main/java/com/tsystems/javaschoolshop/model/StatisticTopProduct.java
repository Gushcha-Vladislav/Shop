package com.tsystems.javaschoolshop.model;

import javax.persistence.*;

/**
 * Some statistics product. There we put all necessary options in fields.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them, Serializable interface(optional),
 * and empty constructor if we define custom one.
 */
@Entity
@DiscriminatorValue("SP")
public class StatisticTopProduct extends Statistics {

    /**
     * Some product. As can see above in class declaration, this table connects order and product with different sizes.
     * Hibernate allow us to get Product object from OrdersProducts object.
     * This filed connected with id_product column in column in statistics table.
     */
    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;

    /**
     * Product quantity of certain size.
     * This filed connects with amount column in statistics table.
     * Cannot be nullable.
     */
    @Column(name = "amount")
    private Integer amount;

    /**
     * Empty constructor for Hibernate.
     */
    public StatisticTopProduct() {
        //Empty constructor for hibernate.
    }

    /**
     * Custom constructor with all necessary fields to initialize.
     * @param product - delivery address.
     * @param amount - directly, order status, it's obvious.
     */
    public StatisticTopProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
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
     * @return amount object
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Simple setter
     * @param amount is object to set
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
        final StringBuilder sb = new StringBuilder("StatisticTopProduct{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(product!=null) sb.append("product=").append(product.toString()).append('\'');
        if(amount!=null) sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
