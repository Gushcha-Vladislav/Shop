package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addresses", schema = "webshopdb")
public class Address extends Generic {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "city")
    private String city;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "country")
    private String country;

    @Size(min = 6, max = 10)
    @Column(name = "postcode")
    private String postcode;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "house")
    private String house;


    @Column(name = "apartment")
    private String apartment;

    @NotNull
    @Column(name = "is_default")
    private boolean isDefault = true;

    public Address() {
    }

    public Address(User user, String city, String country, String street, String house) {
        this.user = user;
        this.city = city;
        this.country = country;
        this.street = street;
        this.house = house;
        this.isDefault = true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(user!=null) sb.append(", user=").append(user.toString());
        if(city!=null) sb.append(", city='").append(city).append('\'');
        if(country!=null) sb.append(", country='").append(country).append('\'');
        if(postcode!=null) sb.append(", postcode='").append(postcode).append('\'');
        if(street!=null) sb.append(", street='").append(street).append('\'');
        if(house!=null) sb.append(", house='").append(house).append('\'');
        if(apartment!=null) sb.append(", apartment='").append(apartment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
