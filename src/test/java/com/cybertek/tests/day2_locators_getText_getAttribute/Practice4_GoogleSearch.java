package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice4_GoogleSearch {

    public static void main(String[] args) {

        //TC#4:	Google	search
        // 1- Open a chrome	browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Write	“apple”	in search box
        // By.name: finds an elements name
        // .sendKeys: types inside the element if there is a inout box.
        // Keys.ENTER: presses the enter key.
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        // 4- Click	google search button
        //driver.findElement(By.name("btnK")).click();

        // 5- Verify title:
        //              Expected: Title should start with “apple"

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Apple title verification passed!");
        } else {
            System.out.println("Apple title verification failed");
        }


    }

}
