package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class specijetCalendatUI {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();

        //boolean month =driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")).getText().contains("May");
        while (!driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")).getText().contains("October")) {
            driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        //[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']

        List<WebElement> dates = driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']"));
        int count = driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']")).size();

        for (int x = 0; x < count; x++) {
            String text = driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']")).get(x).getText();
            if (text.equalsIgnoreCase("20")) {
                driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']")).get(x).click();
                break;
            }
        }


    }
}
