package com.cybertek.tests.day6_Dropdown_Review_javaFaker;

import com.cybertek.Utilities.BrowserUtility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_verify_state_dropdown(){
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateDropDown.selectByVisibleText("Illinois");

        stateDropDown.selectByValue("VA");

        stateDropDown.selectByIndex(5);

        String expectedResult = "California";
        String actualResult = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult, expectedResult, "Actual VS Expected");
    }

    @Test
    public void test3_date_dropdown_verification(){
        //TC #3: Selecting date on dropdown and verifying

        //locate all the web elements/dropdowns
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //creating expected values in one place
        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";

        //3. Select “December 1 , 1921” and verify it is selected.
        //   Select year using Select month using Select day using
        yearDropdown.selectByVisibleText("1921");

        //selecting month by "value" attribute value
        monthDropdown.selectByValue("11");

        //select day by index
        dayDropdown.selectByIndex(0);

        //getting actual values from the web page
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //Creating assert to compare actual vs expected
        Assert.assertEquals(actualYear, expectedYear, "Actual year vs Expected year");
        Assert.assertEquals(actualMonth, expectedMonth, "Actual month vs Expected month");
        Assert.assertEquals(actualDay.equals(expectedDay), "Actual day vs Expected day");


    }

    //TC #4: Selecting value from multiple select dropdown
    @Test
    public void test4_multiple_value_select_dropdown(){

        //3. Select all the options from multiple select dropdown.
        // Locate the dropdown

        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //Creating a list of web elements to store all of the options inside of this dropdown

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        //Loop through the options to select all of them

        for(WebElement eachOption : allOptions){
            eachOption.click(); // this will click each option with every iteration

            //4. Print out all selected values.
            System.out.println("Selected: " + eachOption.getText());

            //Asserting the option is actually selected or not
            Assert.assertTrue(eachOption.isSelected(), "The option: "+eachOption.getText()+" is not selected!");

        }

        //5. Deselect all values.
        multipleSelectDropdown.deselectAll();

        for (WebElement eachOption : allOptions){
            Assert.assertTrue(!eachOption.isSelected());
            Assert.assertFalse(eachOption.isSelected()); // This is already looking for false value
        }

    }

}
