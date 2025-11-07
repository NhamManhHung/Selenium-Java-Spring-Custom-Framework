package com.auto.framework.testdata;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

@Component
public class AccountDataProvider {
    private final Faker faker = new Faker();

    private AccountInformation generateAccount() {
        return AccountInformation.builder()
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(6, 12))
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .day(String.valueOf(faker.number().numberBetween(1, 28)))
                .month(faker.date().birthday().toInstant().toString().substring(5, 7))
                .year(String.valueOf(faker.number().numberBetween(1980, 2005)))
                .address(faker.address().streetAddress())
                .country(faker.address().country())
                .state(faker.address().state())
                .city(faker.address().cityName())
                .zipcode(faker.address().zipCode())
                .mobileNumber(faker.phoneNumber().cellPhone())
                .build();
    }

    @DataProvider(name = "Account Data", parallel = true)
    public Object[][] provideAccountData() {
        return new Object[][]{
                { generateAccount() },
                { generateAccount() }
        };
    }
}
