package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static javax.print.attribute.standard.MediaSizeName.B;

public class WebDriverDemo {

    public static void main(String[] args) throws MalformedURLException {
        /* Commented OUT for the explicit wait demo below:
        //System.setProperty("webdriver.gecko.driver", "/home/me/IdeaProjects/geckodriver");
        //WebDriver driver4Firefox = new FirefoxDriver();
        //driver4Firefox.get("http://www.pluralsight.com");

        // System path can also provide access to the drivers
        // Therefore the System.setProperty line will not be necessary
        System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver");
        WebDriver driver4Chrome = new ChromeDriver();
        driver4Chrome.get("http://www.google.com.au");

        // NB: There are no ID element to findElement for google.com.au
        // Following does not work, because second part of the class nem, after the space " "
        //WebElement searchField = driver4Chrome.findElement(By.className("gsfi"));
        // data-ved is a bad element to use as it changes all the time
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("[data-ved='0ahUKEwjNoffaqv3oAhVEXSsKHZJGBSYQ39UDCAY']")); // Firefox
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("[data-ved='0ahUKEwjSoPrTrf3oAhUGVH0KHdAGAi4Q39UDCAY']")); // Chrome

        // Following works
        // You only need to put in the first class used, only the first part, before the space " "
        //WebElement searchField = driver4Chrome.findElement(By.className("gLFyf"));
        // OR by name
        WebElement searchField = driver4Chrome.findElement(By.name("q"));
        // CSS element Selector
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[name='q']"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[class='gLFyf gsfi'][name='q']"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[class='gLFyf gsfi'][maxlength='2048']"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[class='gLFyf gsfi'][maxlength='2048']"));


        //driver4Chrome.get("https://www.duckduckgo.com");
        //WebElement searchField = driver4Chrome.findElement(By.id("search_form_input_homepage"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[id=search_form_input_homepage]"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input#search_form_input_homepage"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("#search_form_input_homepage"));
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[id^=search_form_]")); // Starts with
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[id$=_input_homepage]")); // Ends with
        //WebElement searchField = driver4Chrome.findElement(By.cssSelector("input[id*=_form_input_]")); // Contains sub-string

        //WebElement searchField = driver4Chrome.findElement(By.name("q"));

        searchField.sendKeys("blah");
        searchField.submit();
        //Choose the first element of the array list imagesLink with get(0)
        WebElement imagesLink = driver4Chrome.findElements(By.linkText("Images")).get(0);
        imagesLink.click();

        WebElement imageElement = driver4Chrome.findElements(By.cssSelector("div[class^=bRMDJf]")).get(0);
        // Choose the element Nested inside the previous Element 'imageElement'
        WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
        // OR by class
        //WebElement imageLink = imageElement.findElements(By.cssSelector("img[class^=rg_i]")).get(0);
        imageLink.click();

        //EXTRA NB:
        // Search for a string on a webpage, and get that page:
        //driver4Chrome.getPageSource().contains("Whatever you want to search here");

         */

        //System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver81-69");
        //System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver81-20");
        System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver79-36");

        // Remove the following line due to Selenium Sever instance and replace with:
        //WebDriver driver4Chrome = new ChromeDriver();
        WebDriver driver4Chrome = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                new ChromeOptions()     );
        //                .addArguments("enable-automation")
        //                .addArguments("--headless")
        //                .addArguments("--window-size=1000,1000")
        //                .addArguments("--no-sandbox")
        //                .addArguments("--disable-extensions")
        //                .addArguments("--dns-prefetch-disable")
        //                .addArguments("--disable-gpu")      );
        //                .addArguments("--disable-infobars");
        //                .addArguments("--disable-dev-shm-usage")    );
        //                .addArguments("--disable-browser-side-navigation");
        //                .setPageLoadStrategy(PageLoadStrategy.NORMAL));

        driver4Chrome.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);

        driver4Chrome.get("http://www.google.com.au");

        WebElement searchField = driver4Chrome.findElement(By.name("q"));

        searchField.sendKeys("blah");
        searchField.submit();

        // Adding Implicit wait (A global wait) for 10 secs for every element related to driver4Chrome
        //driver4Chrome.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Setting up explicit waits, where the wait for each element is individually applied.
        // This explicit wait is for the LinkText for "Images"
        //WebDriverWait wait = new WebDriverWait(driver4Chrome, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));

        WebElement imagesLink = driver4Chrome.findElements(By.linkText("Images")).get(0);
        imagesLink.click();
        WebElement imageElement = driver4Chrome.findElements(By.cssSelector("div[class^=bRMDJf]")).get(0);
        WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
        imageLink.click();
    }
}
