package org.example;

import org.example.pages.HomePage;
import org.example.pages.PreConditions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import static org.example.pages.PreConditions.initDriver;


public class AppTest {

    WebDriver browser;
    private String baseUrl = System.getenv("baseUrl");

    @BeforeTest
    public void start() {
        if (baseUrl == null) {
            baseUrl = "https://rozetka.com.ua/";
        }
        browser = initDriver();
        browser.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        PreConditions preConditions = new PreConditions(browser);
        preConditions.openPage(baseUrl)
                .scrollPage();
    }

    @AfterTest
    public void postCondition() {
        browser.quit();
    }

    @Test(timeOut = 3000)
    public void findWord() {
        HomePage homePage = new HomePage(browser);
        Assert.assertTrue(homePage.checkWord().contains("Доставка по всей Украине"));
    }
}
