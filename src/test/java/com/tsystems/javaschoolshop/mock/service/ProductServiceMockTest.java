package com.tsystems.javaschoolshop.mock.service;

import com.tsystems.javaschoolshop.dao.impl.ProductDaoImpl;
import com.tsystems.javaschoolshop.model.Product;
import com.tsystems.javaschoolshop.model.StatisticTopProduct;
import com.tsystems.javaschoolshop.model.dto.ProductDto;
import com.tsystems.javaschoolshop.service.impl.CategoryServiceImpl;
import com.tsystems.javaschoolshop.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceMockTest {

    private Product product = new Product();
    private List<Product> products = new ArrayList<>();

    @Mock
    ProductDaoImpl productDao;

    @Mock
    CategoryServiceImpl categoryService;

    @InjectMocks
    ProductServiceImpl productService;

    @Before
    public void init() {
        product.setId(1);
        product.setNameProduct("Tee");
        product.setImage("/image/1");
        product.setPrice(12);
        product.setStatus(true);
        product.setBrand("Gold");
        product.setCategory(null);
        product.setQuantityInStock(250);
        product.setDescription("description");
        product.setStatisticTopProduct(new StatisticTopProduct(product,17));

        Product product1 = new Product();
        product1.setId(2);
        product1.setNameProduct("bread");
        product1.setImage("/image/2");
        product1.setPrice(3);
        product1.setStatus(false);
        product1.setBrand("Gold");
        product1.setCategory(null);
        product1.setQuantityInStock(250);
        product1.setDescription("description");
        product1.setStatisticTopProduct(new StatisticTopProduct(product1,15));

        Product product2 = new Product();
        product2.setId(3);
        product2.setNameProduct("meet");
        product2.setImage("/image/3");
        product2.setPrice(14);
        product2.setStatus(true);
        product2.setBrand("Gold");
        product2.setCategory(null);
        product2.setQuantityInStock(250);
        product2.setDescription("description");
        product2.setStatisticTopProduct(new StatisticTopProduct(product2,22));

        products.add(product);
        products.add(product1);
        products.add(product2);
    }

    @Test
    public void findAllProductMockTest1(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result = productService.findAllProducts(true);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(new Long(result.get(0).getId()), new Long(products.get(1).getId()));
    }

    @Test
    public void findAllProductMockTest2(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result = productService.findAllProducts(false);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(new Long(result.get(0).getId()), new Long(product.getId()));
    }

    @Test
    public void findProductByIdMockTest1(){
        Mockito.when(productDao.findProductById(1)).thenReturn(product);
        //do
        Product result = productService.findProductById(1,true);
        //check
        Mockito.verify(productDao).findProductById(1);
        Assert.assertEquals(result,product);
    }

    @Test
    public void findProductByIdMockTest2(){
        Mockito.when(productDao.findProductById(2)).thenReturn(products.get(1));
        //do
        Product result = productService.findProductById(2,false);
        //check
        Mockito.verify(productDao).findProductById(2);
        assertNull(result);
    }

    @Test
    public void saveProductMockTest1(){
        Mockito.when(productDao.saveProduct(product)).thenReturn(product);
        //do
        Product result = productService.saveProduct(product);
        //check
        Mockito.verify(productDao).saveProduct(product);
    }

    @Test
    public void getQuantityProductInStickByIdMockTest1(){
        Mockito.when(productDao.findProductById(1)).thenReturn(product);
        //do
        int result = productService.getQuantityProductInStickById(1);
        //check
        Mockito.verify(productDao).findProductById(1);
        Assert.assertEquals(new Long(result),new Long(product.getQuantityInStock()));
    }

    @Test
    public void findTop10ProductsMockTest1(){
        Mockito.when(productDao.findTop10Products(true)).thenReturn(products);
        //do
        productService.findTop10Products(true);
        //check
        Mockito.verify(productDao).findTop10Products(true);
    }

    @Test
    public void findNumberOfSalesByIdMockTest1(){
        Mockito.when(productDao.findNumberOfSalesById(1)).thenReturn(product.getStatisticTopProduct().getSales());
        //do
        int result =  productService.findNumberOfSalesById(1);
        //check
        Mockito.verify(productDao).findNumberOfSalesById(1);
        Assert.assertEquals(new Long(result),new Long(product.getStatisticTopProduct().getSales()));
    }

    @Test
    public void filterMockTest1(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result =  productService.filter(0,0,true);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(result.get(0).toString(),products.get(1).toString());
    }

    @Test
    public void filterMockTest2(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result =  productService.filter(0,1,true);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(result.get(0).toString(),products.get(2).toString());
    }

    @Test
    public void filterMockTest3(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result =  productService.filter(0,2,true);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(result.get(0).toString(),products.get(2).toString());
    }

    @Test
    public void filterMockTest4(){
        Mockito.when(productDao.findAllProducts()).thenReturn(products);
        //do
        List<Product> result =  productService.filter(0,3,true);
        //check
        Mockito.verify(productDao).findAllProducts();
        Assert.assertEquals(result.get(0).toString(),products.get(0).toString());
    }

    @Test(expected = NullPointerException.class)
    public void changeProductMockTest1(){
        Mockito.when(productDao.findProductById(1)).thenReturn(product);
        Mockito.when(categoryService.findCategoryById(1)).thenReturn(null);
        ProductDto productDto = new ProductDto(1,"bbbb",1,12,"bbb","bbb",250);
        //do
        productService.changeProduct(productDto);
        //check
        Mockito.verify(productDao).findProductById(1);
        Mockito.verify(categoryService).findCategoryById(1);
    }
}
