package com.auto.framework.pageobjects.demogeniusocean.components.login;

import com.auto.framework.annotations.FindByCustom;
import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginPF extends BasePage {
    //    private static By usernameField = By.name("email");
//    private static By passwordField = By.name("password");
//    private static By loginButton = By.className("submit-btn");
    @FindByCustom(name = "email")
    private static By usernameField;

    @FindByCustom(name = "password")
    private static By passwordField;

    @FindByCustom(className = "submit-btn")
    private static By loginButton;

    @Step("Enter username")
    public void enterUsername(String username) {
        iUIElements.sendKeys(usernameField, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        iUIElements.sendKeys(passwordField, password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        iUIElements.click(loginButton);
    }

}
