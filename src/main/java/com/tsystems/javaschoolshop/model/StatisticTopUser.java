package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SU")
public class StatisticTopUser {

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @NotNull
    @Column(name = "amount")
    private Integer price;

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
}
