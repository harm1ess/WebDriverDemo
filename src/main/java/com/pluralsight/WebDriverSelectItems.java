package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverSelectItems {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/me/IdeaProjects/WebDriverDemo/src/main/webapp/SelectItemTest.html");

        WebElement selectElement = driver.findElement(By.id("select1"));
        // Ensure the the below 'Select' package is the seleniumhq package
        Select select = new Select(selectElement);

        select.selectByVisibleText("Maybe");
    }
}
