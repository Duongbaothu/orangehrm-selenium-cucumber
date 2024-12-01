package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    Faker faker = new Faker(new Locale("en-US"));

    public static FakerConfig getFaker(){
        return new FakerConfig();
    }

    public String getFirstName() {
        return faker.address().firstName();
    }
    public String getLastName() {
        return faker.address().lastName();
    }
    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getCompanyProfession() {
        return faker.company().profession();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }


}
