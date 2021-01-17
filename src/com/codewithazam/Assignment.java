package com.codewithazam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Assignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
        String option3 = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
        Select dropdown = new Select(driver.findElement(By.cssSelector("[id='dropdown-class-example']")));
        dropdown.selectByVisibleText(option3);

        driver.findElement(By.id("name")).sendKeys(option3);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if(text.contains(option3)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
    }
}
