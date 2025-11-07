package com.auto.framework.pageobjects.demoautomationexercise.components;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SignUpForm extends BasePage {
    private static By title = By.id("id_gender1");
    private static By password = By.id("password");
    private static By day = By.id("days");
    private static By month = By.id("months");
    private static By year = By.id("years");
    private static By firstName = By.id("first_name");
    private static By lastName = By.id("last_name");
    private static By address1 = By.id("address1");
    private static By country = By.id("country");
    private static By state = By.id("state");
    private static By city = By.id("city");
    private static By zipcode = By.id("zipcode");
    private static By mobileNumber = By.id("mobile_number");
    private static By createButton = By.cssSelector("[data-qa='create-account']");
    private static By accountCreatedMessage = By.cssSelector("[data-qa='account-created'] b");
    @Step("Select title")
    public void selectTitle() {
        iUIElements.click(title);
    }

    @Step("Enter password: {pwd}")
    public void enterPassword(String pwd) {
        iUIElements.sendKeys(password, pwd);
    }

    @Step("Select day: {dayValue}")
    public void selectDay(String dayValue) {
        iUIElements.selectByVisibleText(day, dayValue);
    }

    @Step("Select month: {monthValue}")
    public void selectMonth(String monthValue) {
        iUIElements.selectByVisibleText(month, monthValue);
    }

    @Step("Select year: {yearValue}")
    public void selectYear(String yearValue) {
        iUIElements.selectByVisibleText(year, yearValue);
    }

    @Step("Enter first name: {value}")
    public void enterFirstName(String value) {
        iUIElements.sendKeys(firstName, value);
    }

    @Step("Enter last name: {value}")
    public void enterLastName(String value) {
        iUIElements.sendKeys(lastName, value);
    }

    @Step("Enter address: {value}")
    public void enterAddress(String value) {
        iUIElements.sendKeys(address1, value);
    }

    @Step("Select country: {countryName}")
    public void selectCountry(String countryName) {
        iUIElements.selectByVisibleText(country, countryName);
    }

    @Step("Enter state: {value}")
    public void enterState(String value) {
        iUIElements.sendKeys(state, value);
    }

    @Step("Enter city: {value}")
    public void enterCity(String value) {
        iUIElements.sendKeys(city, value);
    }

    @Step("Enter zip code: {value}")
    public void enterZipCode(String value) {
        iUIElements.sendKeys(zipcode, value);
    }

    @Step("Enter mobile number: {value}")
    public void enterMobileNumber(String value) {
        iUIElements.sendKeys(mobileNumber, value);
    }

    @Step("Click 'Create Account' button")
    public void clickCreateAccount() {
        iUIElements.click(createButton);
    }

    @Step("Get account created message text")
    public String getAccountCreatedMessage() {
        return iElementVerification.getText(accountCreatedMessage);
    }

}
