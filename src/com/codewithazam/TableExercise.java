package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableExercise {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //row count
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        System.out.println(rows.size());

        //column count
        List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[2]/td"));
        System.out.println(columns.size());

        //print texts of 2nd row
        List<WebElement> row2 = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
        for(WebElement r: row2){
            System.out.println(r.getText());
        }

    }
}
