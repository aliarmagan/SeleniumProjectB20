package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void p1_information_alert_practice(){

        //Locating the warning information/alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //Click button
        warningAlertButton.click();

        //1- Create alert instance:
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        //2- Use alert instance to accept javascript alert:
        alert.accept();

        //locating the result web element:
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Assert "result text"
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification failed!");

    }

    @Test
    public void p2_confirmation_alert_practice(){

        //Locating the warning information/alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        //Click button
        warningAlertButton.click();

        //Create alert instance
        Alert alert = driver.switchTo().alert();

        //Accepting the alert
        alert.accept();

        //Locating result web element:
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Assert
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification failed!");

    }

}
