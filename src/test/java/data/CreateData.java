package data;

import com.github.javafaker.Faker;


import java.util.Locale;

public class CreateData {
    public static Faker fakerEN = new Faker(new Locale("en"));
    public static Faker fakerRU = new Faker(new Locale("ru"));

    public static String getValidName() {
        return fakerEN.name().firstName() + " " + fakerEN.name().lastName();
    }

    public static String getEmail() {
        return fakerEN.internet().emailAddress();
    }

    public static String getCurrentAddress() {
        return fakerEN.address().fullAddress();
    }

    public static String getPermanentAddress() {
        return fakerRU.address().fullAddress();
    }
}
