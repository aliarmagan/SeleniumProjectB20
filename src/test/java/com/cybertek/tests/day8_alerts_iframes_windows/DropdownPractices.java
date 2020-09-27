package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }



    @Test
    public void p7_month_dropdown_default_value_test(){
        //Locating the month dropdown
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        //Expected
        //We are dynamically getting the current month name from LocalDateTime java class.
        String expectedValue = LocalDateTime.now().getMonth().name();
        System.out.println("expectedValue = " + expectedValue);

        //Actual
        String actualValue = monthDropdown.getFirstSelectedOption().getText();
        System.out.println("actualValue = " + actualValue);

        //Assert
        //First way of doing this assertion: use .toLowerCase() method for both actual and expected values
        Assert.assertEquals(actualValue.toLowerCase(), expectedValue.toLowerCase());

        //Second way: use equalsIgnoreCase to compare actual and expected values
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));

        //This line gets all the options from the dropdown and stores value in the list:
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        //creating list of string for expected values:
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");

        // new array list to add actual months as a string:
        List<String> actualMonthTexts = new ArrayList<>();

        for (WebElement each : actualMonthOptions) {
            actualMonthTexts.add(each.getText());
        }

        Assert.assertEquals(actualMonthTexts, expectedMonthOptions);

    }

}
