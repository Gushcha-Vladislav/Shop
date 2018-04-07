package com.tsystems.javaschoolshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsystems.javaschoolshop.model.dto.UserDto;
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

/**
 * User entity model. This class maps on users Table in our Database.
 * There we store all information about the users. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "users", schema = "webshopdb")
public class User extends Generic {

    /**
     * User name.
     * This filed connected with name column in users table.
     * Cannot be nullable.
     */
    @NotNull
    @Size(min=3, max=20)
    @Column(name = "name_user")
    private String nameUser;

    /**
     * User surname.
     * This filed connected with last name column in users table.
     */
    @Size(max = 20)
    @Column(name = "last_name_user")
    private String lastNameUser;

    /**
     * User role. See UserRoleEnum for more details. {@link UserRoleEnum}
     * This filed connected with role column in users table.
     * Cannot be nullable.
     */
    @Column(name = "role")
    private String role;

    /**
     * User birthday.
     * This filed connected with birthday column in users table.
     * Cannot be nullable.
     */
    @Past
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * User email.
     * This filed connected with email column in users table.
     * Cannot be nullable and must be unique.
     */
    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    /**
     * User phone number.
     * This filed connected with phone column in users table.
     * Must be unique
     */
    @Size(max = 20)
    @Column(name = "phone", unique = true)
    private String phone;

    /**
     * User password.
     * This filed connected with password column in users table.
     * Cannot be nullable.
     */
    @NotNull
    @Size(min=1)
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private StatisticTopUser statisticTopUser = new StatisticTopUser(this,0);

    /**
     * Empty constructor for Hibernate.
     */
    public User() {
        //Empty constructor for hibernate.
    }

    public User change(UserDto user) {
        if(user.getNameUser()!=null) this.nameUser = user.getNameUser();
        if(user.getLastNameUser()!=null) this.lastNameUser=user.getLastNameUser();
        if(user.getEmail()!=null) this.email = user.getEmail();
        if(user.getPhone() !=null) this.phone = user.getPhone();
        return this;
    }

    /**
     * Simple getter
     * @return User name value
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Simple setter
     * @param nameUser is value to set
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * Simple getter
     * @return User last name value
     */
    public String getLastNameUser() {
        return lastNameUser;
    }

    /**
     * Simple setter
     * @param lastNameUser is value to set
     */
    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    /**
     * Simple getter
     * @return User role value. See more here {@link UserRoleEnum}
     */
    public String getRole() {
        return role;
    }

    /**
     * Simple setter
     * @param role is value to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Simple getter
     * @return User birthday value in format yyyy-MM-dd
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Simple setter
     * @param birthday is value to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Simple getter
     * @return User email value
     */
    public String getEmail() {
        return email;
    }

    /**
     * Simple setter
     * @param email is value
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Simple getter
     * @return User phone number value
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Simple setter
     * @param phone number is value to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Simple getter
     * @return User password value
     */
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

    public StatisticTopUser getStatisticTopUser() {
        return statisticTopUser;
    }

    public void setStatisticTopUser(StatisticTopUser statisticTopUser) {
        this.statisticTopUser = statisticTopUser;
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
     * In our case in next format: User{id=id; name=nameUser; email=email}.
     * Some parameters may be null.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(nameUser!=null) sb.append(", nameUser='").append(nameUser).append('\'');
        if(email!=null) sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
