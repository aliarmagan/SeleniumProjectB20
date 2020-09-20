package com.cybertek.tests.day6_Dropdown_Review_javaFaker;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory_VyTrack.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void task1_login_page_links_print_test() {
        // 6.Print out count of all the allLinks on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Count of allLinks on landing page: " + allLinks.size());

        // 7.Print out each link text on this page
        for (WebElement eachLink : allLinks){
            System.out.println("Each link: " + eachLink.getText());
        }

    }

}
