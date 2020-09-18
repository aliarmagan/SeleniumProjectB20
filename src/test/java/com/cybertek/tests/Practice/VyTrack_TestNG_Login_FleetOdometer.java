package com.cybertek.tests.Practice;

import com.cybertek.tests.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VyTrack_TestNG_Login_FleetOdometer extends WebDriverFactory_VyTrack {

    @BeforeMethod
    public void setDriver(){
        super.setDriver();
    }

    @Test
    public void a_VyTrackLogin() throws InterruptedException, IOException {
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
        getScreenShot("Driver Login landing page");

        //verify driver has landed on vytrack Dashboard:
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Login failed");

    }

    @Test
    public void b_VyTrackFleetOdometer() throws InterruptedException, IOException {
        //Calling login method:
        a_VyTrackLogin();

        //Drop-down menu by clicking on it
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();

        //Find and click on vehicle odometer:
        driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        Thread.sleep(3000);

        //Verify driver has navigated to the vehicle odometer page overview and take screenshot:
        String expectedVehicleOdometerTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();

        //ScreenShot method in Utility/WebDriverFactory
        getScreenShot( "Fleet Vehicles Odometer Overview");

        //verifying driver navigation successful:
        Assert.assertEquals(actualVehicleOdometerTitle, expectedVehicleOdometerTitle, "Navigation to vehicle odometer Failed!");


    }

    @AfterMethod
    public void driverTearDown() {
        super.driverTearDown();
    }

}
