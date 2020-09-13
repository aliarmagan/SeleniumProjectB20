package com.cybertek.tests.day4_findElements_checkBoxes_Radio;

import com.cybertek.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P0_FindElements_Practice1 {

    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Print out the texts of all links
        List<WebElement> webElementList = driver.findElements(By.xpath("//body//a"));

        for (WebElement eachElement : webElementList){
            System.out.println(eachElement.getText());
        }

        //4. Print out how many total link
        int numberOfLinks = webElementList.size();

        System.out.println("Number of links = " + numberOfLinks);

    }

}
