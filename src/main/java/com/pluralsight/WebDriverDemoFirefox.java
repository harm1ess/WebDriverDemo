package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverDemoFirefox {

    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("webdriver.gecko.driver", "/home/me/IdeaProjects/geckodriver");
        //WebDriver driver4Firefox = new FirefoxDriver();
        WebDriver driver4Firefox = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                new FirefoxOptions()
                        //.addArguments("--disable-gpu")
                        //.addArguments("enable-automation")
                        ////.addArguments("--headless")
                        //.addArguments("--window-size=1000,1000")
                        .addArguments("--no-sandbox"));
                        //.addArguments("--disable-extensions")
                        //.addArguments("--dns-prefetch-disable")
                        //.addArguments("--disable-gpu"));
                        //.setPageLoadStrategy(PageLoadStrategy.NORMAL));

        driver4Firefox.get("http://www.google.com.au");

        WebElement searchField = driver4Firefox.findElement(By.name("q"));

        searchField.sendKeys("blah");
        searchField.submit();

        // Adding Implicit wait (A global wait) for 10 secs for every element related to driver4Chrome
        //driver4Chrome.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Setting up explicit waits, where the wait for each element is individually applied.
        // This explicit wait is for the LinkText for "Images"
        //WebDriverWait wait = new WebDriverWait(driver4Chrome, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));

        WebElement imagesLink = driver4Firefox.findElements(By.linkText("Images")).get(0);
        imagesLink.click();
        WebElement imageElement = driver4Firefox.findElements(By.cssSelector("div[class^=bRMDJf]")).get(0);
        WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
        imageLink.click();
    }
}
