package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HyperLinksSelenium {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //size of the links in the webpage
        System.out.println(driver.findElements(By.tagName("a")).size());

        //size of the links in the footer
        WebElement element = driver.findElement(By.id("gf-BIG"));
        System.out.println(element.findElements(By.tagName("a")).size());

        //size of the links in the columnDriver of footer
        WebElement columnDriver = element.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //click on each link of the columnDriver footer and print their title
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickLinks = Keys.chord(Keys.COMMAND, Keys.RETURN);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinks);
            Thread.sleep(5000L);
        }
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            while (it.hasNext()) {
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
        }
    }
}
