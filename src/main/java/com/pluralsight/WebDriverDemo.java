package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static javax.print.attribute.standard.MediaSizeName.B;

public class WebDriverDemo {

    public static void main(String[] args) {

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
    }
}
