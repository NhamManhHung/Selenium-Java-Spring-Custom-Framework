package com.auto.framework.pageobjects.demoautomationexercise.components;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginForm extends BasePage {
    private static By loginMenuButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

//    private static By nameField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
//    private static By emailAddressField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
//    private static By registerButton = By.xpath("//*[@id="form"]/div/div/div[3]/div/form/button");

    private static By emailAddressFieldLogin = By.cssSelector("[data-qa='login-email']");
    private static By passwordFieldLogin = By.cssSelector("[data-qa='login-password']");
    private static By loginButton = By.cssSelector("[data-qa='login-button']");

    private static By nameFieldSignUp = By.cssSelector("[data-qa='signup-name']");
    private static By emailAddressFieldSignUp = By.cssSelector("[data-qa='signup-email']");
    private static By signUpButton = By.cssSelector("[data-qa='signup-button']");
    private static By logoutButtonDisplayed = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    @Step("Enter password login")
    public void enterPasswordLogin(String password) {
        iUIElements.sendKeys(passwordFieldLogin, password);
    }

    @Step("Enter email login")
    public void enterEmailAddressLogin(String emailAddress) {
        iUIElements.sendKeys(passwordFieldLogin, emailAddress);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        iUIElements.click(loginButton);
    }

    @Step("Click login menu button")
    public void clickLoginMenuButton() {
        iUIElements.click(loginMenuButton);
    }

    @Step("Enter name signup")
    public void enterNameSignUp(String name) {
        iUIElements.sendKeys(nameFieldSignUp, name);
    }

    @Step("Enter email")
    public void enterEmailAddressSignUp(String emailAddress) {
        iUIElements.sendKeys(emailAddressFieldSignUp, emailAddress);
    }

    @Step("Click signup button")
    public void clickSignUpButton() {
        iUIElements.click(signUpButton);
    }
    @Step("Check logout button displayed")
    public boolean isLogoutButtonDisplayed() {
        return iElementVerification.isDisplayed(logoutButtonDisplayed);
    }
}
