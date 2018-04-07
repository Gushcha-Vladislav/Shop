package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Address entity model. This class maps on addresses Table in our Database.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "addresses", schema = "webshopdb")
public class Address extends Generic {

    /**
     * User object. We had User class {@link User} and every user may has user
     * Hibernate allow us to get User object from Address object, because the user can have many addresses.
     * This filed connected with id_user column in address table.
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * Address city name.
     * This field connects with city column in addresses table.
     * May be repeated. Cannot be null.
     */
    @NotNull
    @Size(min = 2, max = 45)
    @Column(name = "country")
    private String country;

    /**
     * Address country name.
     * This field connects with country column in addresses table.
     * May be null. Cannot be null.
     */
    @NotNull
    @Size(min = 2, max = 45)
    @Column(name = "city")
    private String city;

    /**
     * Address postcode number.
     * This field connects with postcode column in addresses table.
     * May be null, may be repeated.
     */
    @Size(max = 10)
    @Column(name = "postcode")
    private String postcode;

    /**
     * Address street name.
     * This field connects with street column in addresses table.
     * Cannot be null, may be repeated.
     */
    @NotNull
    @Size(min = 2, max = 45)
    @Column(name = "street")
    private String street;

    /**
     * Address house name.
     * This field connects with house column in addresses table.
     * Cannot be null, may be repeated.
     */
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "house")
    private String house;

    /**
     * Address apartment number.
     * This field connects with apartment column in addresses table.
     * May be null, may be repeated.
     */
    @Size(max = 5)
    @Column(name = "apartment")
    private String apartment;

    public Address() {
        //Empty constructor for hibernate.
    }

    /**
     * Our custom constructor
     * @param user number to set
     * @param city name to set
     * @param country name to set
     * @param street name to set
     * @param house number to set
     */
    public Address(User user, String city, String country, String street, String house) {
        this.user = user;
        this.city = city;
        this.country = country;
        this.street = street;
        this.house = house;
    }

    /**
     * Simple getter
     * @return User value
     */
    public User getUser() {
        return user;
    }

    /**
     * Simple setter
     * @param user value to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Simple getter
     * @return Address country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * Simple setter
     * @param country value to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Simple getter
     * @return Address city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Simple setter
     * @param city value to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Simple getter
     * @return Address postcode number
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Simple setter
     * @param postcode value to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Simple getter
     * @return Address street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Simple setter
     * @param street value to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Simple getter
     * @return Address house number
     */
    public String getHouse() {
        return house;
    }

    /**
     * Simple setter
     * @param house value to set
     */
    public void setHouse(String house) {
        this.house = house;
    }

    /**
     * Simple getter
     * @return Address apartment number
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * Simple setter
     * @param apartment value to set
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
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
        final StringBuilder sb = new StringBuilder("Address{");
        if(user!=null) sb.append(", user=").append(user.toString());
        if(city!=null) sb.append(", city='").append(city).append('\'');
        if(street!=null) sb.append(", street='").append(street).append('\'');
        if(house!=null) sb.append(", house='").append(house).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Address)) return false;

        Address tmp = (Address) obj;
        return tmp.getId() == this.getId();
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getCity().hashCode();
        return result;
    }


    public String toStringForEmail(){
        StringBuilder sb = new StringBuilder();
        sb.append(country).append(", ").append(city).append(" ");
        if (postcode.length() != 0) sb.append("(").append(postcode).append(")");
        sb.append(", ").append(street).append(" ").append(house);
        if (apartment.length() !=0) sb.append(", ").append(apartment);
        return sb.toString();
    }
}
