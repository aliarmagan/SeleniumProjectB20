package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.BrowserUtility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void p3_handling_windows(){
        driver.get("http://practice.cybertekschool.com/windows");

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Practice"));

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //Set allows only unique values:
        Set<String> windowHandles = driver.getWindowHandles();
        // we loop through the set of window handles so that we can get the window handle of the other windows
        // then using switchTo().window() method we switch to the other windows

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Title = " + driver.getTitle());
            System.out.println("Current window handle: " + driver.getWindowHandle());
        }

        //getting the current title(actual), and comparing with expected title:
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        BrowserUtils.wait(1);
        driver.close(); //driver.close will only close the current focused window/tab
        //driver.quit(); this will close all instances adn will cause other tests to not be able to run:

        //if i want to switch back to main menu to do some other things:
        driver.switchTo().window(mainHandle);

    }

    @Test
    public void p6_handling_more_than_two_windows(){
        driver.get("https://amazon.com");

        //This line is basically: We are downCasting our driver type to javascriptExecutor:
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles= driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current page title: " + driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

    }

}
