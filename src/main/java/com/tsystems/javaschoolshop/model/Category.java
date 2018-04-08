package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Category entity model. This class maps on categories Table in our Database.
 * There we put all necessary options in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "categories", schema = "webshopdb")
public class Category extends Generic {

    /**
     * Category hierarchy number value.
     * This filed connects with hierarchy_number column in categories table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "hierarchy_number")
    private Integer hierarchyNumber;

    /**
     * Category parent object. For correct working of our application we should have
     * and opportunity to get all categories hierarchy. So, adding parent field will help us with it.
     * JPA API allow us to get all parent data and Hibernate do it.
     * This filed connected with id_parent column in categories table.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_parent")
    private Category parent;

    /**
     * Category name.
     * This filed connects with name column in categories table.
     * Cannot be nullable.
     */
    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "name_category")
    private String nameCategory;

    /**
     * Category status value.
     * This filed connects with status column in categories table.
     * Cannot be nullable.
     */
    @Column(name = "status", nullable = false)
    private boolean status = false;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    /**
     * Empty constructor for hibernate.
     */
    public Category() {
        //Empty constructor for hibernate.
    }

    /**
     * Our custom constructor.
     * @param hierarchyNumber value to set
     * @param parent object to set
     * @param nameCategory value to set
     */
    public Category(int hierarchyNumber, Category parent, String nameCategory, boolean status) {
        this.hierarchyNumber = hierarchyNumber;
        this.parent = parent;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    /**
     * Simple getter
     * @return Category hierarchy number value
     */
    public Integer getHierarchyNumber() {
        return hierarchyNumber;
    }

    /**
     * Simple setter
     * @param hierarchyNumber value to set
     */
    public void setHierarchyNumber(Integer hierarchyNumber) {
        this.hierarchyNumber = hierarchyNumber;
    }

    /**
     * Simple getter
     * @return Category parent object
     */
    public Category getParent() {
        return parent;
    }

    /**
     * Simple setter
     * @param parent object to set
     */
    public void setParent(Category parent) {
        this.parent = parent;
    }

    /**
     * Simple getter
     * @return Category name value
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * Simple setter
     * @param nameCategory value to set
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    /**
     * Simple getter
     * @return Category status value
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Simple setter
     * @param status value to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Simple getter
     * @return Category list. To understand what it is, see description of this field and
     * Category class - {@link Category}
     */
    public List<Category> getChildren() {
        return children;
    }

    /**
     * Simple setter
     * @param children is value to set
     */
    public void setChildren(List<Category> children) {
        this.children = children;
    }

    /**
     * Simple getter
     * @return Product list. To understand what it is, see description of this field and
     * Product class - {@link Product}
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Simple setter
     * @param products is value to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
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
        final StringBuilder sb = new StringBuilder("Category{");
        if(getId()!=null) sb.append("id=").append(getId()).append('\'');
        if(hierarchyNumber!=null) sb.append(", hierarchyNumber='").append(hierarchyNumber).append('\'');
        if(parent!=null) sb.append(", parent=").append(parent.toString());
        if(nameCategory!=null) sb.append(", nameCategory='").append(nameCategory).append('\'');
        sb.append(", status=").append(status);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (status != category.status) return false;
        return nameCategory.equals(category.nameCategory);
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
        int result = nameCategory.hashCode();
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
