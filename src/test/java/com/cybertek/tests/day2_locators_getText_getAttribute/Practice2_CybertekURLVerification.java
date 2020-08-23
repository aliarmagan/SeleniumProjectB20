package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2_CybertekURLVerification {

    public static void main(String[] args) {

        //TC #2: cybertek Verifications
        //1. Open Chrome Browser
        //Setup Chrome Driver
        WebDriverManager.chromedriver().setup();

        //Create instance of chrome browser from webdriver
        WebDriver driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //2. Go to URL https://www.practice.cybertek.com
        driver.get("http://practice.cybertek.com");

        //3. Verify URL Contains
        // Expected Result: cybertekschool
        String expectedUrl= "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        System.out.println(actualUrl.contains(expectedUrl));

        //4. Verify Title
        // Expected result: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        System.out.println(expectedTitle.equals(actualTitle));

    }

}
