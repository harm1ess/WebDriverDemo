package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriverRadioButtons {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/me/IdeaProjects/chromedriver");

        WebDriver driver4chrome = new ChromeDriver();

        driver4chrome.get("file:///home/me/IdeaProjects/WebDriverDemo/src/main/webapp/RadioButonTest.html");

        List<WebElement> radioButtons = driver4chrome.findElements(By.name("colour"));
        radioButtons.get(1).click();

        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                System.out.println(radioButton.getAttribute("value"));
            }

        }

    }
}
