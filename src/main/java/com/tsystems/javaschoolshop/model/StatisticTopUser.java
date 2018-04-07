package com.tsystems.javaschoolshop.model;

import javax.persistence.*;

/**
 * Some statistics user. There we put all necessary options in fields.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them, Serializable interface(optional),
 * and empty constructor if we define custom one.
 */
@Entity
@DiscriminatorValue("SU")
public class StatisticTopUser extends Statistics {


    /**
     * Owner of the order. For correct working of our application we should have
     * an opportunity to get owner of every category(User). So, adding user field will help us with it.
     * JPA API allow us to get user object data and Hibernate do it.
     * This filed connected with id_user column in statics table.
     */
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * Total cost of the user.
     * This filed connects with price column in statistics table.
     * Cannot be nullable.
     */
    @Column(name = "price")
    private Integer price;

    /**
     * Empty constructor for Hibernate.
     */
    public StatisticTopUser() {
    }

    /**
     * Custom constructor with all necessary fields to initialize.
     * @param user - delivery address.
     * @param price - directly, order status, it's obvious.
     */
    public StatisticTopUser(User user, Integer price) {
        this.user = user;
        this.price = price;
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
     * @return Product price value
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Simple setter
     * @param price is value to set
     */
    public void setPrice(Integer price) {
        this.price = price;
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
        final StringBuilder sb = new StringBuilder("StatisticTopUser{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(user!=null) sb.append("user=").append(user.toString()).append('\'');
        if(price!=null) sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
