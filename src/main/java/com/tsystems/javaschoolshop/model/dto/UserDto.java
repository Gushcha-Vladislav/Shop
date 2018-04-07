package com.tsystems.javaschoolshop.model.dto;

import org.hibernate.validator.constraints.Email;
import javax.persistence.Column;
import javax.validation.constraints.Size;

public class UserDto {

    @Size(min=3, max=20)
    @Column(name = "name_user")
    private String nameUser;

    @Size(min=3,max = 20)
    @Column(name = "last_name_user")
    private String lastNameUser;

    @Email
    @Size(min=3,max=45)
    @Column(name = "email", unique = true)
    private String email;

    @Size(min=11, max = 20)
    @Column(name = "phone", unique = true)
    private String phone;

    public UserDto() {
        //Empty constructor
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        if(nameUser!=null) sb.append("nameUser='").append(nameUser).append('\'');
        if(lastNameUser!=null) sb.append(", lastNameUser='").append(lastNameUser).append('\'');
        if(email!=null) sb.append(", email='").append(email).append('\'');
        if(phone!=null) sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
