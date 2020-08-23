package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3_Navigations_TitleVerification {

    public static void main(String[] args) {

        // TC #3: Back and forth navigation
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();

        // Open browser
        WebDriver driver = new ChromeDriver();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Click to Gmail from top right.
        // locater By.linkText("String"), This is used to find a text which is a hyperlink
        driver.findElement(By.linkText("Gmail")).click(); //find element returns web element and click is the method that clicks on it

        // 4- Verify title contains:
        // Expected: Gmail
        String expectedT = "Gmail";
        String actualT = driver.getTitle();

        if (actualT.contains(expectedT)){
            System.out.println("Gmail title Verification passed!");
        } else {
            System.out.println("Gmail title verification failed!");
        }

        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        // Expected: Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification passed!");
        } else {
            System.out.println("Google title verification failed!");
        }

    }

}
