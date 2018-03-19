package com.tsystems.javaschoolshop.mock.service;

import com.tsystems.javaschoolshop.dao.impl.ProductDaoImpl;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import com.tsystems.javaschoolshop.service.impl.BasketProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class BasketProductServiceMockTest {

    private Product productP1 = new Product();
    private Product productP2 = new Product();
    private BasketProductDto product1 = new BasketProductDto();
    private BasketProductDto product2 = new BasketProductDto();
    private BasketProductDto product3 = new BasketProductDto();

    @Mock
    ProductDaoImpl productDao;

    @InjectMocks
    BasketProductServiceImpl basketProductService;

    @Before
    public void init() {

        productP1.setId(1);
        productP1.setNameProduct("Tee");
        productP1.setImage("/image/1");
        productP1.setPrice(12);
        productP1.setStatus(true);
        productP1.setBrand("Gold");
        productP1.setCategory(null);
        productP1.setQuantityInStock(250);
        productP1.setQuantitySold(2);
        productP1.setDescription("description");
        productP1.setProperty("property");

        productP2.setId(2);
        productP2.setNameProduct("bread");
        productP2.setImage("/image/2");
        productP2.setPrice(3);
        productP2.setStatus(true);
        productP2.setBrand("Gold");
        productP2.setCategory(null);
        productP2.setQuantityInStock(250);
        productP2.setQuantitySold(2);
        productP2.setDescription("description");
        productP2.setProperty("property");

        product1.setId(1);
        product1.setAmount(2);
        product1.setNameProduct("Tee");
        product1.setPrice(12);
        product1.setImage("/image/1");


        product2.setId(2);
        product2.setAmount(2);
        product2.setNameProduct("bread");
        product2.setPrice(3);

        product3.setId(3);
        product3.setAmount(2);
        product3.setNameProduct("Milk");
        product3.setPrice(45);
    }

    @Test
    public void calculateTotalPriceMockTest1() {
        //do
        int result = basketProductService.totalPrice(new ArrayList<>(Arrays.asList(product1, product2, product3)));
        //check
        Assert.assertNotNull(result);
        Assert.assertEquals(120, result);
    }

    @Test
    public void calculateTotalPriceMockTest2() {
        //do
        int result = basketProductService.totalPrice(new ArrayList<>(Collections.singletonList(product1)));
        //check
        Assert.assertNotNull(result);
        Assert.assertEquals(24, result);
    }

    @Test(expected = NullPointerException.class)
    public void calculateTotalPriceMockTest3() {
        //do
        int result =  basketProductService.totalPrice(null);
        //check
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result);
    }

    @Test
    public void calculateTotalPriceMockTest4() {
        //do
        int result = basketProductService.totalPrice(new ArrayList<>());
        //check
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result);
    }

    @Test
    public void createBagProductFromProductMockTest1() {
        //do
        BasketProductDto result = basketProductService.createBagProductFromProduct(productP1);
        //check
        Assert.assertNotNull(result);
        Assert.assertEquals(productP1.getId(), result.getId());
        Assert.assertEquals(productP1.getNameProduct(), result.getNameProduct());
        Assert.assertEquals(productP1.getPrice(), result.getPrice());
        Assert.assertEquals(productP1.getImage(), result.getImage());
    }

    @Test(expected = NullPointerException.class)
    public void createBagProductFromProductMockTest2() {
        //do
        basketProductService.createBagProductFromProduct(null);
    }

    @Test
    public void convertBagProductDtoToProductMockTest1() {
        //prepare
        Mockito.when(productDao.findProductById(1)).thenReturn(productP1);
        //do
        Product result = basketProductService.convertBasketProductDtoToProduct(product1);
        //verify
        Mockito.verify(productDao).findProductById(1);
        Assert.assertNotNull(result);
        Assert.assertEquals(productP1.getId(), result.getId());
        Assert.assertEquals(productP1.getNameProduct(), result.getNameProduct());
        Assert.assertEquals(productP1.getPrice(), result.getPrice());
        Assert.assertEquals(productP1.getImage(), result.getImage());

    }

    @Test
    public void convertBagProductDtoToProductMockTest2() {
        //do
        Product result = basketProductService.convertBasketProductDtoToProduct(null);
        //check
        Mockito.verifyZeroInteractions(productDao);
        Assert.assertNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void deleteFromBasketByIdMockTest1() {
        //do
        basketProductService.deleteFromBasketById(1, null);
    }

    @Test
    public void deleteFromBasketByIdMockTest2() {
        //prepare
        List<BasketProductDto> basket  = new ArrayList<>(Arrays.asList(product1, product2, product3));
        int bagSizeBefore = basket .size();
        Mockito.when(productDao.findProductById(productP1.getId())).thenReturn(productP1);
        //do
        basketProductService.deleteFromBasketById(productP1.getId(), basket );
        int bagSizeAfter = basket .size();
        //check
        Mockito.verify(productDao).findProductById(productP1.getId());
        Mockito.verify(productDao).saveProduct(productP1);
        Assert.assertTrue(bagSizeBefore == bagSizeAfter + 1);
    }

    @Test
    public void deleteFromBasketByIdMockTest3() {
        //prepare
        List<BasketProductDto> basket  = new ArrayList<>(Arrays.asList(product1, product2, product3));
        int bagSizeBefore = basket .size();
        Mockito.when(productDao.findProductById(productP1.getId())).thenReturn(productP1);
        //do
        basketProductService.deleteFromBasketById(10, basket );
        int bagSizeAfter = basket.size();
        //check
        Mockito.verifyZeroInteractions(productDao);
        Assert.assertTrue(bagSizeBefore == bagSizeAfter);
    }

    @Test(expected = NullPointerException.class)
    public void deleteFromBasketMockTest1() {
        //do
        basketProductService.deleteFromBasket(null);
    }

    @Test()
    public void deleteFromBasketMockTest2() {
        List<BasketProductDto> basket = new ArrayList<>(Arrays.asList(product1, product2));
        Mockito.when(productDao.findProductById(productP1.getId())).thenReturn(productP1);
        Mockito.when(productDao.findProductById(productP2.getId())).thenReturn(productP2);
        //do
        basket = basketProductService.deleteFromBasket(basket);
        int bagSizeAfter = basket.size();
        //check
        Mockito.verify(productDao).findProductById(productP1.getId());
        Mockito.verify(productDao).saveProduct(productP1);
        Mockito.verify(productDao).findProductById(productP2.getId());
        Mockito.verify(productDao).saveProduct(productP2);
        Assert.assertTrue( bagSizeAfter == 0);
    }

}
