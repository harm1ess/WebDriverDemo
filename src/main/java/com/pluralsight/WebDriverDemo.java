package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemo {

    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver", "/home/me/IdeaProjects/geckodriver");
        //WebDriver driverFirefox = new FirefoxDriver();
        //driverFirefox.get("http://www.pluralsight.com");

        System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver");
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("http://www.google.com.au");

        // NB: There are no ID element to findElement
        // You do not need to put the full class name, only the first part, before the space " "
        WebElement searchField = driverChrome.findElement(By.className("gLFyf"));
        // OR
        //WebElement searchField = driverChrome.findElement(By.name("q"));
        WebElement searchField = driverChrome.findElement(By.cssSelector("gLFyf"));

        searchField.sendKeys("blah");

    }
}
