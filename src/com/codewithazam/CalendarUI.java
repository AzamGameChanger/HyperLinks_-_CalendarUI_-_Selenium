package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarUI {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions/");
        Thread.sleep(3000L);

        driver.findElement(By.xpath("//input[@id='travel_date']")).click();

        while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("June")) {
            driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='next']")).click();
        }

        List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
        int count = driver.findElements(By.cssSelector(".day")).size();
        for (int i = 0; i < count; i++) {
            String date = driver.findElements(By.cssSelector(".day")).get(i).getText();
            if (date.equalsIgnoreCase("20")) {
                driver.findElements(By.cssSelector(".day")).get(i).click();
                break;
            }
        }
    }
}
