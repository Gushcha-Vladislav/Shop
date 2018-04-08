package com.tsystems.javaschoolshop.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginSeleniumTest {

    private WebDriver browser;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        browser = new ChromeDriver();
    }

    @Test
    public void loginPositiveSeleniumTest1() {
        browser.get(Url.Login);

        browser.findElement(By.id("email")).sendKeys("vk@vk.com");
        browser.findElement(By.id("password")).sendKeys("user");

        browser.findElement(By.className("login-button")).click();
        String email = browser.findElement(By.className("email")).getText();

        assertEquals(Url.Account, browser.getCurrentUrl());
        assertEquals("test@gmail.com", email);
    }

    @Test
    public void loginNegativeSeleniumTest2() {
        browser.get(Url.Login);

        browser.findElement(By.id("email")).sendKeys("vk@vk.com");
        browser.findElement(By.id("password")).sendKeys("user1");

        browser.findElement(By.className("login-button")).click();

        assertEquals(Url.ErrorLogin, browser.getCurrentUrl());
    }

    @After
    public void destroy() {
        browser.close();
    }
}
