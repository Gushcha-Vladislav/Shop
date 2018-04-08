package com.tsystems.javaschoolshop.selenium;


        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

        import static org.junit.Assert.assertEquals;

public class SignUpSeleniumTest {

    private WebDriver browser;

    @Before
    public void init() {
        browser = new ChromeDriver();
    }

    @Test
    public void SignUpPositiveSeleniumTest1() {
        browser.get(Url.SingUp);

        browser.findElement(By.id("nameUser")).sendKeys("Test");
        browser.findElement(By.id("lastNameUser")).sendKeys("Test");
        browser.findElement(By.id("email")).sendKeys("someEmail@gmail.com");
        browser.findElement(By.id("birthday")).sendKeys("1997-09-25");
        browser.findElement(By.id("password")).sendKeys("123456");
        browser.findElement(By.className("login-button")).click();

        assertEquals(Url.Address, browser.getCurrentUrl());
        assertEquals("someEmail@gmail.com", browser.findElement(By.className("email")).getText());
    }


    @After
    public void destroy() {
        browser.close();
    }
}
