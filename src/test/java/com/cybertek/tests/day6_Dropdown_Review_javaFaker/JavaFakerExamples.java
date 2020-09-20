package com.cybertek.tests.day6_Dropdown_Review_javaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void faker_test(){

        //Create new faker obj from the faker class to be able to use methods
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("First name: " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("Last name: " + lastName);

        String address = faker.address().fullAddress();
        System.out.println("Address: " + address);

        String house = faker.gameOfThrones().house();
        System.out.println("House: " + house);

        String quote = faker.gameOfThrones().quote();
        System.out.println("Quote: " + quote);

        String fact = faker.chuckNorris().fact();
        System.out.println("Fact: " + fact);

    }

}
