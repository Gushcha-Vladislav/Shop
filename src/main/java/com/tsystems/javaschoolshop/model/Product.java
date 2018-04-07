package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Product entity model. This class maps on products Table in our Database.
 * There we store all information about the product in fields. Hibernate forces us to make class
 * with fields and getters and setters for all of them,
 * abstract class Generic, see more about available types here {@link Generic}
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "products", schema = "webshopdb")
public class Product extends Generic {

    /**
     * Product name.
     * This filed connected with name_product column in products table.
     * Cannot be nullable and must be unique.
     */
    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    /**
     * Category object. We had Category class {@link Category} and every product in store
     * should be a part of any category. By this reason we should store reference to a category object.
     * Hibernate allow us to get Size object from OrdersProducts object.
     * This filed connected with id_category column in products table.
     */
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    /**
     * Product price.
     * This filed connected with price column in products table.
     * Cannot be nullable.
     */
    @Column(name = "price", nullable = false)
    private Integer price;

    /**
     * Product brand.
     * This filed connected with brand column in products table.
     */
    @Column(name = "brand")
    private String brand;

    /**
     * Product image path.
     * This filed connected with image column in products table.
     * Cannot be nullable.
     */
    @Column(name = "image", nullable = false)
    private String image;

    /**
     * Product description.
     * This filed connected with description column in products table.
     * Cannot be nullable.
     */
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Product number of products.
     * This filed connected with quantity_in_stock column in products table.
     * Cannot be nullable.
     */
    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    /**
     * Product status. If true, guests and users cannot see this product(admins can) and vice versa.
     * This filed connected with status column in products table.
     * Cannot be nullable.
     */
    @Column(name = "status", nullable = false)
    private boolean status = true;

    @OneToOne(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private StatisticTopProduct statisticTopProduct = new StatisticTopProduct(this,0);

    /**
     * Empty constructor for Hibernate.
     */
    public Product() {
    }

    /**
     * Our custom constructor to initialize all necessary fields.
     * @param nameProduct - see fields declaration.
     * @param category  - see fields declaration.
     * @param price - see fields declaration.
     * @param brand - see fields declaration.
     * @param image - see fields declaration.
     * @param description - see fields declaration.
     * @param quantityInStock - see fields declaration.
     */
    public Product(String nameProduct, Category category, Integer price, String brand,
                   String image, String description, Integer quantityInStock) {
        this.nameProduct = nameProduct;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.image = image;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Simple getter
     * @return Product name value
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * Simple setter
     * @param nameProduct is value to set
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * Simple getter
     * @return Product category object
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Simple setter
     * @param category is object to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Simple getter
     * @return Product price value
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Simple setter
     * @param price is value to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Simple getter
     * @return Product brand value
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Simple setter
     * @param brand is value to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Simple getter
     * @return Product image path value
     */
    public String getImage() {
        return image;
    }

    /**
     * Simple setter
     * @param image is value to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Simple getter
     * @return Product description value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Simple setter
     * @param description is value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Simple getter
     * @return Number of products value
     */
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Simple setter
     * @param quantityInStock is value to set
     */
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Simple getter
     * @return Product status value
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Simple setter
     * @param status is value to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }


    /**
     * Simple getter
     * @return StatisticTopProduct list. To understand what it is, see description of this field and
     * StatisticTopProduct class - {@link StatisticTopProduct}
     */
    public StatisticTopProduct getStatisticTopProduct() {
        return statisticTopProduct;
    }

    /**
     * Simple setter
     * @param statisticTopProduct is object to set
     */
    public void setStatisticTopProduct(StatisticTopProduct statisticTopProduct) {
        this.statisticTopProduct = statisticTopProduct;
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
        final StringBuilder sb = new StringBuilder("Product{");
        if (getId() != null) sb.append("id=").append(getId()).append('\'');
        if (nameProduct != null) sb.append(", nameProduct='").append(nameProduct).append('\'');
        if (category != null) sb.append(", category=").append(category.toString());
        if (price != null) sb.append(", price=").append(price);
        if (brand != null) sb.append(", brand='").append(brand).append('\'');
        if (quantityInStock != null) sb.append(", quantityInStock=").append(quantityInStock);
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
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!nameProduct.equals(product.nameProduct)) return false;
        if (!price.equals(product.price)) return false;
        if (!image.equals(product.image)) return false;
        return quantityInStock.equals(product.quantityInStock);
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
        int result = nameProduct.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + image.hashCode();
        result = 31 * result + quantityInStock.hashCode();
        return result;
    }
}