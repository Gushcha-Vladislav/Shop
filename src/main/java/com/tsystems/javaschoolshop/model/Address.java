package com.tsystems.javaschoolshop.model;

import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addresses", schema = "webshopdb")
public class Address extends Generic {


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @NotNull
    @Size(min=3, max=45)
    @Column(name = "city")
    private String city ;

    @NotNull
    @Size(min=3, max=45)
    @Column(name = "country")
    private String country;

    @Size(min=6, max=10)
    @Column(name = "postcode")
    private String postcode;

    @NotNull
    @Size(min=3, max=45)
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "house")
    private String house;


    @Column(name = "apartment")
    private String apartment;

    @NotNull
    @Column(name = "is_default")
    private boolean isDefault=true;

    public Address() {
    }

    public Address(User user, String city, String country, String street, String house) {
        this.user = user;
        this.city = city;
        this.country = country;
        this.street = street;
        this.house = house;
        this.isDefault=true;
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
        StringBuilder sb = new StringBuilder();
        boolean countryExpr = country.length() != 0;
        boolean cityExpr = city.length() != 0;
        boolean postcodeExpr = postcode.length() != 0;
        boolean streetExpr = street.length() != 0;
        boolean houseExpr = house.length() != 0;
        boolean apartmentExpr = apartment.length() != 0;

        if (countryExpr) sb.append(country);
        if (sb.length() > 0 && cityExpr) sb.append(", ");
        if (cityExpr) sb.append(city);
        if (sb.length() > 0 && postcodeExpr) sb.append(" ");
        if (postcodeExpr) sb.append("(").append(postcode).append(")");
        if (sb.length() > 0 && streetExpr) sb.append(", ");
        if (streetExpr) sb.append(street);
        if (streetExpr && houseExpr) sb.append(" ").append(house);
        if (streetExpr && houseExpr && apartmentExpr) sb.append(", ").append(apartment);

        return sb.toString();
    }
}
