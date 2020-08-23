package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1_GoogleTitleVerify {

    public static void main(String[] args) {

        //TC #1 Google Title Verification
        //1- set up web driver:
        WebDriverManager.chromedriver().setup();

        //open a chrome browser
        //2- create the instance of chrome driver:
        WebDriver driver = new ChromeDriver();

        //3- Verify Title
        //Expected: Google
        driver.get("https://google.com");

        String expectedResult = "Google";
        String actualTitle  = driver.getTitle();

        if (actualTitle.equals(expectedResult)){

            System.out.println("Title verification PASSED!");

        } else {

            System.out.println("Title verification failed");

        }

    }

}
