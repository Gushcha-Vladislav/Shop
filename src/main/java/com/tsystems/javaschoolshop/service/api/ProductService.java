package com.tsystems.javaschoolshop.service.api;

import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.model.dto.ProductSendDto;

import java.util.List;

/**
 * Interface provide us API we can use to manipulate products.
 */
public interface ProductService {

    /**
     * Method finds all products in shop. If activeMode is true,
     * method will return all found products, otherwise only not hidden
     * products.
     * @param adminMode see above.
     * @return list of found products.
     */
    List<Product> findAllProducts(final boolean adminMode);

    /**
     * Method finds all products in shop by id. If activeMode is true,
     * method will return all found products, otherwise only not hidden
     * products.
     * @param id products.
     * @param adminMode see above.
     * @return product.
     */
    Product findProductById(int id, boolean adminMode);

    /**
     * Method saves products.
     * @param product that must be saved in database.
     * @return reference to a saved product.
     */
    Product saveProduct(Product product);

    /**
     * Method returns available amount by id product.
     * @return available amount of size;
     */
    Integer getQuantityProductInStickById(int id);

    /**
     * Method finds top 10 products. If activeMode is true,
     * method will return all found top products, otherwise only not hidden
     * top products.
     * @param adminMode see above.
     * @return list of found products.
     */
    List<Product> findTop10Products(boolean adminMode);

    /**
     * Method return number of sales by id product.
     * @return available amount of size;
     */
    int findNumberOfSalesById(int id);

    /**
     * Method should try to send message to the ActiveMQ server.
     * If advertising stand application is available it will receive this message
     * and will make an attempt to update top products list.
     */
    void sendMessage();

    /**
     * Method converts list Product object {@link Product} to list ProductDto object {@link ProductSendDto}.
     * @param products that must be converted.
     * @return ProductDto object as a result of converting.
     */
    List<ProductSendDto> convertProductsToProductsDto (List<Product> products);

    /**
     * Method finds products in certain category.
     * @param id  category.
     * @return list of found products.
     */
    List<Product> findProductByCategory(int id);

    /**
     * Method creates a product by productDto
     * @param productDto valid version of the product without dependencies.
     * @return reference to a saved product.
     */
    Product createProduct(ProductDto productDto);

    /**
     * Method change a product by productDto
     * @param productDto valid version of the product without dependencies.
     */
    void changeProduct(ProductDto productDto);

    /**
     * Method filter products by their cost(lower cost bound and upper cost bound) and size
     * in certain category.
     * @param idCategory - id of the selected category.
     * @param typeSort - type of product sorting.
     * @param adminMode see above.
     * @return list of found products.
     */
    List<Product> filter(int idCategory,int typeSort, boolean adminMode);
}
