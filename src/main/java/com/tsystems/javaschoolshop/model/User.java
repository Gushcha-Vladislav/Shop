package com.tsystems.javaschoolshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "webshopdb")
public class User extends Generic {

    @Column(name = "name_user", nullable = false, length = 20)
    private String nameUser;

    @Column(name = "last_name_user", length = 20)
    private String lastNameUser;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "phone", unique = true, length = 20)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(String nameUser, String lastNameUser, String role, String birthday, String email, String phone, String password) {
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.role = role;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
