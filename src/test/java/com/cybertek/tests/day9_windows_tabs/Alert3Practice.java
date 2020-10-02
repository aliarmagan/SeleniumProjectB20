package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.BrowserUtility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert3Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    /*
    TC #3: Information alert practice
    1. Open browser
    2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    3. Click to “Click for JS Prompt” button
    4. Send “hello” text to alert
    5. Click to OK button from the alert
    6. Verify “You entered: hello” text is displayed.
     */

    @Test
    public void p3_prompt_alert_practice(){

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.= 'Click for JS Prompt']"));
        promptAlertButton.click();

        //Using alert class to handle alert:
        Alert alert = driver.switchTo().alert();

        //browserUtils class we created to store commonly used utility methods
        BrowserUtils.wait(2);

        //Sending keys:
        alert.sendKeys("Something is happening");

        //accepting the alert:
        alert.accept();

        //finding result text and verifying is is displayed:
        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(), "result text is not displayed!");

        //waiting for browser to catch up:
        BrowserUtils.wait(1);

        //verify result contains text input:
        String actualText = resultText.getText();
        Assert.assertEquals(actualText, resultText, "Result text is not displayed, Verification failed!");

    }

    @AfterMethod
    public void tearDownMethod(){
        BrowserUtils.wait(1);
        driver.close();
    }

}
