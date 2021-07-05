package com.cybertek.tests.day10_testBase_DriverUtil;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){

        Driver.getDriver().get("https://google.com");

        //locating the google search box using its name attribute:
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        String search = ConfigurationReader.getProperty("search");

        //searching for wooden spoon:
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //expected
        String expectedInTitle = search ;
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        Driver.closeDriver();
    }

}
