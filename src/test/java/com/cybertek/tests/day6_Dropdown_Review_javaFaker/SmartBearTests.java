package com.cybertek.tests.day6_Dropdown_Review_javaFaker;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
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

    @Test
    public void task2_create_order_with_javaFaker() {
        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue("FamilyAlbum");
        WebElement quantityAmount = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityAmount.sendKeys(Keys.BACK_SPACE + "2");

        //8. Click to "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        //Generate: name
        WebElement customerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys(faker.name().fullName());

        //Generate: street address
        WebElement streetName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        streetName.sendKeys(faker.address().streetAddress());

        //Generate: city
        WebElement cityName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        cityName.sendKeys(faker.address().city());

        //Generate: state
        WebElement stateName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        stateName.sendKeys(faker.address().state());

        //Generate: zipcode
        WebElement zipcode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10. Click on "visa" radio button
        WebElement visaButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaButton.click();

        //11. Generate card number using JavaFaker
        WebElement cardField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardField.sendKeys(faker.business().creditCardNumber().replaceAll("-", ""));

        //Enter exp date:
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("09/20");

        //12. Click on "Process"
        WebElement process = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        process.click();

        //Thread sleep cause implicit wait doesnt wanna work:
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        //13.Verify success message "New order has been successfully added." is displayed
        WebElement successMessage = driver.findElement(By.xpath("//div/strong[.='New order has been successfully added.']"));
        Assert.assertEquals(successMessage, "New order has been successfully added.", "Success message not displayed");

    }

}
