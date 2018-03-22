package com.tsystems.javaschoolshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsystems.javaschoolshop.model.enums.UserRoleEnum;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", schema = "webshopdb")
public class User extends Generic {

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @NotNull
    @Size(min=3, max=20)
    @Column(name = "name_user")
    private String nameUser;

    @Size(min=3, max=20)
    @Column(name = "last_name_user")
    private String lastNameUser;

    @Column(name = "role")
    private String role;

    @Past
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = 11, max = 20)
    @Column(name = "phone", unique = true)
    private String phone;

    @NotNull
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String nameUser, String lastNameUser, Date birthday, String email, String phone, String password) {
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.role = UserRoleEnum.ROLE_USER.name();
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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(nameUser!=null) sb.append(", nameUser='").append(nameUser).append('\'');
        if(lastNameUser!=null) sb.append(", lastNameUser='").append(lastNameUser).append('\'');
        if(birthday!=null) sb.append(", birthday=").append(birthday.toString());
        if(email!=null) sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
