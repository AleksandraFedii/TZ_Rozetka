package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final By searchField = By.xpath("/html/head/meta[1]");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkWord() {
        return driver.findElement(searchField).getText();
    }

}

