package com.cybertek.tests.Practice;

import com.cybertek.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrack_TestNG_CreateOdometer_Driver extends WebDriverFactory_VyTrack {

    @BeforeMethod
    public void setDriver(){
        super.setDriver();
    }

    @Test
    public void driverCreateOdometer() throws Exception {
        //Calling login and nav to fleet odometer page:
        //Finding and creating odometer:
        //login to QA environment
        //Username:
        driver.findElement(By.name("_username")).sendKeys(getDriverLogin());

        //Password:
        driver.findElement(By.name("_password")).sendKeys(getDriverPassword() + Keys.ENTER);

        //Login:
        //driver.findElement(By.name("_submit")).click();

        Thread.sleep(3000);

        //verify driver has landed on vytrack Dashboard and take screenshot:
        //confirm login successful,
        String expectedHomePageTitle = "Dashboard";
        String actualHomePageTitle = driver.getTitle();

        //ScreenShot method in Utility/WebDriverFactory
        getScreenShotMac("Driver Login landing page");

        //verify driver has landed on vytrack Dashboard:
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Login failed");

        //Drop-down menu by clicking on it
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();

        //Find and click on vehicle odometer:
        driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        Thread.sleep(3000);

        //Verify driver has navigated to the vehicle odometer page overview and take screenshot:
        String expectedVehicleOdometerTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();

        //ScreenShot method in Utility/WebDriverFactory
        getScreenShotMac("Fleet Vehicles Odometer Overview");

        //verifying driver navigation successful:
        Assert.assertEquals(actualVehicleOdometerTitle, expectedVehicleOdometerTitle, "Navigation to vehicle odometer Failed!");

        Thread.sleep(1000);

        //Find and create vehicle Odometer:
        driver.findElement(By.xpath("//div/a[@title='Create Vehicle Odometer']")).click();

        //Enter odometer value:
        driver.findElement(By.name("custom_entity_type[OdometerValue]")).sendKeys("12000");

        //Enter Date: (COULD NOT find locater suitable for this)
        //driver.findElement(By.name("date_selector_custom_entity_type_Date-uid-5f61ab1406ec9")).sendKeys("Sep 25, 2020");

        //Enter Driver:
        driver.findElement(By.name("custom_entity_type[Driver]")).sendKeys("Zain");

        //Enter Model: (MODEL NOT SELECTABLE):


        //Save and close:
        driver.findElement(By.xpath("//div/button[@class='btn btn-success action-button']")).click();

        //Wait for page to fully load:
        Thread.sleep(2000);

        //Take ScreenShot:
        getScreenShotMac("Created Odometer Screenshot");



    }

    @AfterMethod
    public void driverTearDown(){
        super.driverTearDown();
    }

}
