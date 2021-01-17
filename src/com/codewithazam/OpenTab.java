package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenTab {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("opentab")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String > it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElements(By.tagName("a")).size());
        driver.switchTo().window(parent);
        System.out.println(driver.findElements(By.tagName("a")).size());
    }
}
