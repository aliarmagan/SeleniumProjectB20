package com.cybertek.tests.Cybertek_Bitrix;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import com.cybertek.pages.NextBaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

    NextBaseLogin nextBaseLogin;

    @Test
    public void smokeTest(){
        String url = ConfigurationReader.getProperty("bitrixUrl");
        Driver.getDriver().get(url);

        //creating object of class I want to use:
        nextBaseLogin = new NextBaseLogin();

        //logging in using method in nextBaseLogin class:
        nextBaseLogin.login(ConfigurationReader.getProperty("bitrixUsername"), ConfigurationReader.getProperty("bitrixPassword"));

        //clicking on Activity stream to navigate to dashboard:
        Driver.getDriver().findElement(By.className("menu-item-link-text")).click();

        //navigating to Filter and search:
        WebElement filterAndSearch = Driver.getDriver().findElement(By.id("LIVEFEED_search"));

        //Creating wait object:
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //Using wait object to setup expected conditions:
        wait.until(ExpectedConditions.elementToBeClickable(filterAndSearch));

        //Clicking on filter and search:
        filterAndSearch.click();

        //Locating pop-up text:
        WebElement filtersText = Driver.getDriver().findElement(By.xpath("//div/h5[.='Filters']"));

        //using explicit wait to synchronise page with driver:
        wait.until(ExpectedConditions.visibilityOf(filtersText));

        //Asserting pop-up visible:
        Assert.assertTrue(filtersText.isDisplayed(), "Filters window is not displayed!!!");

        //locating Bell:
        WebElement bell = Driver.getDriver().findElement(By.id("bx-im-bar-notify"));

        //clicking on bell:
        bell.click();

        //Locating notifications text:
        WebElement notificationsTextHeader = Driver.getDriver().findElement(By.xpath("//div/span[.='Notifications']"));

        //Wait until notifications text is displayed:
        wait.until(ExpectedConditions.visibilityOf(notificationsTextHeader));

        //Assert that notifications are displayed:
        Assert.assertTrue(notificationsTextHeader.isDisplayed(), "Notifications text is not displayed!!!");

        //closing driver:
        Driver.closeDriver();

        //TODO: Fix notifications Text locator!

    }

}
