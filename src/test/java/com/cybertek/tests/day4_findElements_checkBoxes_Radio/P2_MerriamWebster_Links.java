package com.cybertek.tests.day4_findElements_checkBoxes_Radio;

import com.cybertek.Utilities.VyTrack.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_MerriamWebster_Links {

    public static void main(String[] args) {

        //TC #2: FINDELEMENTS
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory_VyTrack.getDriver("chrome");
        //2. Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");
        //3. Print out the texts of all links
        //Locating all of the web elements on the page and storing in a list of WebElement
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        for (WebElement eachLink : listOfLinks){
            System.out.println(eachLink.getText());
        }

        //4. Print out how many link is missing text
        int linksWithoutText = 0;

        for (WebElement eachLink : listOfLinks){
            if (eachLink.getText().equals("")){
                linksWithoutText++;
            }
        }
        System.out.println("Number of links missing text is = " + linksWithoutText);

        //5. Print out how many link has text
        int linksWithText = 0;

        for (WebElement eachLink : listOfLinks){
            if (!eachLink.getText().isEmpty()){
                linksWithText++;
            }
        }
        System.out.println("Number of links with text = " + linksWithText);

        //6. Print out how many total link

        System.out.println("Total number of links = " + (linksWithoutText + linksWithText));

    }

}
