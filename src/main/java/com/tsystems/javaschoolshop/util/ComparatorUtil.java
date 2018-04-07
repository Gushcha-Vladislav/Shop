package com.tsystems.javaschoolshop.util;

import com.tsystems.javaschoolshop.model.Order;
import com.tsystems.javaschoolshop.model.Product;

import java.util.Comparator;

/**
 * As we see from the class name, the goal of this class
 * to give different prepared comparators.
 */
public class ComparatorUtil {

    /**
     * Empty constructor
     */
    private ComparatorUtil() {
    }

    /**
     * Comparator for sorting orders by ID from smallest to largest
     */
    private static Comparator<Order> descendingIdOrderComparator = (p1, p2) -> {
        if (p1.getId() > p2.getId()) return -1;
        if (p1.getId() < p2.getId()) return 1;
        return 0;
    };

    /**
     * Comparator for sorting products by price from smallest to largest
     */
    private static Comparator<Product> ascendingPriceProductComparator = (p1, p2) -> {
        if (p1.getPrice() < p2.getPrice()) return -1;
        if (p1.getPrice() > p2.getPrice()) return 1;
        return 0;
    };

    /**
     * Comparator for sorting products by price from largest to smallest
     */
    private static Comparator<Product> descendingPriceProductComparator = (p1, p2) -> {
        if (p1.getPrice() > p2.getPrice()) return -1;
        if (p1.getPrice() < p2.getPrice()) return 1;
        return 0;
    };

    /**
     * Comparator for sorting products by name from smallest to largest
     */
    private static Comparator<Product> ascendingNameProductComparator = (p1, p2) -> {
        int result =p1.getNameProduct().compareTo(p2.getNameProduct());
        if (result<0) return -1;
        if (result>0) return 1;
        return 0;
    };

    /**
     * Comparator for sorting products by name from largest to smallest
     */
    private static Comparator<Product> descendingNameProductComparator = (p1, p2) -> {
        int result =p1.getNameProduct().compareTo(p2.getNameProduct());
        if (result>0) return -1;
        if (result<0) return 1;
        return 0;
    };
    /**
     * Getter of the descendingIdOrderComparator static field
     * @return ascendingOrderComparator
     */
    public static Comparator<Order> getDescendingIdOrderComparator() { return descendingIdOrderComparator; }

    /**
     * Getter of the ascendingPriceProductComparator static field
     * @return ascendingPriceProductComparator
     */
    public static Comparator<Product> getAscendingPriceProductComparator() { return ascendingPriceProductComparator; }

    /**
     * Getter of the descendingPriceProductComparator static field
     * @return descendingPriceProductComparator
     */
    public static Comparator<Product> getDescendingPriceProductComparator() { return descendingPriceProductComparator; }

    /**
     * Getter of the ascendingNameProductComparator static field
     * @return ascendingNameProductComparator
     */
    public static Comparator<Product> getAscendingNameProductComparator() { return ascendingNameProductComparator; }

    /**
     * Getter of the descendingNameProductComparator static field
     * @return descendingNameProductComparator
     */
    public static Comparator<Product> getDescendingNameProductComparator() { return descendingNameProductComparator; }

}
