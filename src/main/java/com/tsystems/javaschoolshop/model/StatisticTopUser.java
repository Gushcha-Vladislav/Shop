package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SU")
public class StatisticTopUser extends Statistics {

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "price")
    private Integer price;

    public StatisticTopUser() {
    }

    public StatisticTopUser(User user, Integer price) {
        this.user = user;
        this.price = price;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

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
