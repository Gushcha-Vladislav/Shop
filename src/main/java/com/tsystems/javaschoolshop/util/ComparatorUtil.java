package com.tsystems.javaschoolshop.util;


import com.tsystems.javaschoolshop.model.Category;
import com.tsystems.javaschoolshop.model.Product;

import java.util.Comparator;


public class ComparatorUtil {


    private ComparatorUtil() {
    }


    private static Comparator<Product> ascendingPriceProductComparator = (p1, p2) -> {
        if (p1.getPrice() < p2.getPrice()) return -1;
        if (p1.getPrice() > p2.getPrice()) return 1;
        return 0;
    };

    private static Comparator<Product> descendingPriceProductComparator = (p1, p2) -> {
        if (p1.getPrice() > p2.getPrice()) return -1;
        if (p1.getPrice() < p2.getPrice()) return 1;
        return 0;
    };

    private static Comparator<Product> ascendingNameProductComparator = (p1, p2) -> {
        if (p1.getPrice() < p2.getPrice()) return -1;
        if (p1.getPrice() > p2.getPrice()) return 1;
        return 0;
    };

    private static Comparator<Product> descendingNameProductComparator = (p1, p2) -> {
        if (p1.getPrice() > p2.getPrice()) return -1;
        if (p1.getPrice() < p2.getPrice()) return 1;
        return 0;
    };

    public static Comparator<Product> getAscendingPriceProductComparator() { return ascendingPriceProductComparator; }

    public static Comparator<Product> getDescendingPriceProductComparator() { return descendingPriceProductComparator; }

    public static Comparator<Product> getAscendingNameProductComparator() { return ascendingNameProductComparator; }

    public static Comparator<Product> getDescendingNameProductComparator() { return descendingNameProductComparator; }

}
