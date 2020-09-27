package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFramePractice {

    WebDriver driver;

    //TC #4: Iframe practice
    // 1.Create a new class called: IframePractice
    // 2.Create new test and make set ups
    // 3.Go to: http://practice.cybertekschool.com/iframe

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void p4_iframe_practice(){
        //3 ways of locating and switching an Iframe :
        //1- ByIndex
        //driver.switchTo().frame(0);

        //2- By Id or Name
        //driver.switchTo().frame("mce_0_ifr");

        //3- Locate as a web element, then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        // 4.Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //Assert that text is displaying on page:
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is not displayed, verification failed!");

        // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor:
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement parentText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(parentText.isDisplayed(), "Text is not displayed, verification failed!");

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.close();
    }

}
