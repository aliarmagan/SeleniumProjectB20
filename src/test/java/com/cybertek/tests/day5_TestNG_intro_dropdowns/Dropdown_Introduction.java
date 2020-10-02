package com.cybertek.tests.day5_TestNG_intro_dropdowns;

import com.cybertek.Utilities.VyTrack.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Introduction {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1. Open Chrome browser
        driver = WebDriverFactory_VyTrack.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropDown_test_1() throws InterruptedException {
        //TC#1: Verifying "Simple dropdown" and "State selection" dropdown default values
        //3. Verify "Simple dropdown" default selected value is correct
        //Expected: "Please select an option"
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String expectedSelectedOption = "Please select an option";
        String actualSelectedOption = simpleDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption, (expectedSelectedOption));

        Thread.sleep(2000);
        simpleDropdown.selectByVisibleText("Option 2");

        //4. Verify "State selection" default selected value is correct
        //Expected: "Select a State"



        Select simpleDropdown2 = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));

        String expectedStateOption = "Select a State";
        String actualStateOption = simpleDropdown2.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateOption, expectedStateOption);

        Thread.sleep(1000);
        simpleDropdown2.selectByVisibleText("Virginia");

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
