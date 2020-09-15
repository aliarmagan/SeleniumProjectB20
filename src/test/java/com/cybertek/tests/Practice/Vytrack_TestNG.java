package com.cybertek.tests.Practice;

import com.cybertek.tests.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Vytrack_TestNG extends WebDriverFactory_VyTrack {

    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory_VyTrack.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Go to QA environment VyTrack:
        driver.get("https://qa2.vytrack.com");

        //Set driverlogin and password:
        setDriverLogin("user170");
        setDriverPassword("UserUser123");

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
        getScreenShot(this.driver, "Driver Login landing page");

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
        getScreenShot(driver, "Fleet Vehicles Odometer");

        //verifying driver navigation successful:
        Assert.assertEquals(actualVehicleOdometerTitle, expectedVehicleOdometerTitle, "Navigation to vehicle odometer Failed!");


    }

    @AfterMethod
    public void driverTearDown() {
        //Halting execution of code to see page results:
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Closing driver after every test:
        driver.close();

    }

}
