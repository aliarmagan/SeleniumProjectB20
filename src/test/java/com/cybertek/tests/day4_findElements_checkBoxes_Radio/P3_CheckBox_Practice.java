package com.cybertek.tests.day4_findElements_checkBoxes_Radio;

import com.cybertek.tests.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_CheckBox_Practice {

    public static void main(String[] args) throws InterruptedException {

        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory_VyTrack.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id = 'checkboxes']/input[1]"));

        if (!checkBox1.isSelected()){
            System.out.println("CheckBox 1 is not selected. Verification passed!");
        } else {
            System.out.println("CheckBox 1 is selected. Verification failed!");
        }

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id = 'checkboxes']/input[2]"));

        if (checkBox2.isSelected()){
            System.out.println("CheckBox 2 is selected. Verification passed!");
        } else {
            System.out.println("CheckBox 2 is not selected. Verification failed!");
        }

        //4. Click checkbox #1 to select it.
        Thread.sleep(1000);
        checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(1000);
        checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        if (checkBox1.isSelected()){
            System.out.println("CheckBox 1 is selected. Verification passed!");
        } else {
            System.out.println("CheckBox 1 is not selected. Verification failed!");
        }

        //7. Confirm checkbox #2 is NOT selected.
        if (!checkBox2.isSelected()){
            System.out.println("CheckBox 2 is not selected. Verification passed!");
        } else {
            System.out.println("CheckBox 2 is selected. Verification failed!");
        }


    }

}
