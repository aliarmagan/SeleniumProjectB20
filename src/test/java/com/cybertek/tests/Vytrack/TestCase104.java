package com.cybertek.tests.Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase104{

    public static void main(String[] args) {

        //TC B220-104:

        //Driver setup:
        WebDriverManager.chromedriver().setup();

        //Driver instance:
        WebDriver driver = new ChromeDriver();

        //Find and get website:
        driver.get("https://app.vytrack.com/user/login");

        //Login Username:
        driver.findElement(By.name("_username")).sendKeys("user170");

        //login Password:
        driver.findElement(By.name("_password")).sendKeys("UserUser123");

        //login click:
        driver.findElement(By.name("_submit")).click();

        //verify driver is on vytrack home page:
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test Successful!");
        } else {
            System.out.println("Test failed!");
        }


    }

}
