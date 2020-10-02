package com.cybertek.tests.day7_webTables;

import com.cybertek.Utilities.BrowserUtility.SmartBearUtilities;
import com.cybertek.Utilities.BrowserUtility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableTasks {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.loginToSmartBear(driver);

    }

    @Test
    public void p3_verify_susans_order_date(){

        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = susansDate.getText();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        Assert.assertTrue(actualDate.equals(expectedDate), "Actual date is not equal to expected date");

        //Assert.assertEquals(actualDate, expectedDate, "Actual date is not equal to expected date");

        //Assert.fail("I AM FAILING THIS TASK ON PURPOSE");
        //TODO:FIX LOCATOR ASAP

        driver.close();

    }

}
