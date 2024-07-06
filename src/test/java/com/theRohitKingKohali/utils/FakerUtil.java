package com.theRohitKingKohali.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    Faker faker = new Faker();

    public String getFirstName() {
        ;
        return faker.name().firstName();
    }

    public String getlastName() {
        faker = new Faker();
        return faker.name().lastName();

    }
}



