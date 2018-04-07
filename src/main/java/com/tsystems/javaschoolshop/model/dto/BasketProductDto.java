package com.tsystems.javaschoolshop.model.dto;

import java.io.Serializable;

/**
 * Class which represents simplified view of Product model.
 * This dto is used in Bag mechanism
 * See {@link com.tsystems.javaschoolshop.model.Product}
 */
public class BasketProductDto implements Serializable {

    /**
     * Product id
     */
    private Integer id;
    /**
     * Product name
     */
    private String nameProduct;

    /**
     * Path to image
     */
    private String image;

    /**
     * Current quantity of Product in Bag.
     */
    private Integer amount;

    /**
     * price to one of the Product in Bag.
     */
    private Integer price;

    /**
     * Empty constructor
     */
    public BasketProductDto() {
        //Empty constructor
    }

    /**
     * Simple constructor.
     * @param id see fields description
     * @param nameProduct see fields description
     * @param image see fields description
     * @param amount see fields description
     * @param price  see fields description
     */
    public BasketProductDto(int id, String nameProduct, int amount, int price, String image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    /**
     * @return ID of current product
     */
    public int getId() {
        return id;
    }

    /**
     * Allow us to set ID of current product
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return Name of current product
     */
    public String getNameProduct() {
        return nameProduct;
    }


    /**
     * Allow us to set name of current product
     * @param nameProduct to set
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * @return amount of current product in bag
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Allow us to set amount of current product
     * @param amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return price of current product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Allow us to set price of current product
     * @param price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return image path in String format of current product
     */
    public String getImage() {
        return image;
    }

    /**
     * Allow us to set image path of current product
     * @param image to set
     */
    public void setImage(String image) {
        this.image = image;
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
     * In our case in next format: {name=nameProduct; price=price; amount=amount}.
     * Some parameters may be null.
     */
    @Override
    public String toString() {
        String result = "{";
        result += "name = " + nameProduct + "; price = " + price + ";amount = " + amount + "}";
        return result;
    }
}
