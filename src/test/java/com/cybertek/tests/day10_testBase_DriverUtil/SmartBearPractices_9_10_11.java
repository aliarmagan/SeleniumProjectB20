package com.cybertek.tests.day10_testBase_DriverUtil;

import com.cybertek.Utilities.BrowserUtility.SmartBearUtilities;
import com.cybertek.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearPractices_9_10_11 extends TestBase {

    WebDriver driver;

   /* @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.loginToSmartBear(driver);

    }*/

    @Test
    public void p9_delete_order_task(){
        SmartBearUtilities.loginToSmartBear(driver);

        //Locate the checkbox for mark smith and click on it
        WebElement markSmithCheckbox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));

        //click on the check box
        markSmithCheckbox.click();

        //find delete button and click on it
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        //click on it
        deleteButton.click();

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //Assert false works in a way that driver would check the whole list before failing the test
        //Assert true is not used here because it would only check the first element and fail the test instead of going through the whole list of elements
        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }


    }

}
