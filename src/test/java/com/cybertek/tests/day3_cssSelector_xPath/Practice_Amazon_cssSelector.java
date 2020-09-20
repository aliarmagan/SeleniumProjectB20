package com.cybertek.tests.day3_cssSelector_xPath;

import com.cybertek.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice_Amazon_cssSelector {

    public static void main(String[] args) {

        //CSSPractice
        // DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        // TC #3: Amazon link number verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory_VyTrack.getDriver("chrome");

        // 2. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        // 3. Enter search term (use cssSelector to locate search box)
        //using fist syntax of css selector:

        //WebElement searchBox = driver.findElement(By.cssSelector("input[id = 'twotabsearchtextbox']"));
        //searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //using second syntax of css selector:
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        // 4. Verify title contains search term:
        String expectedTitle = "Amazon.com : wooden spoon";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title test Successful");
        } else {
            System.out.println("Title test failed");
        }



    }

}
