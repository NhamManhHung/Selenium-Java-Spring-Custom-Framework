package com.auto.framework.pageobjects.demoautomationexercise;

import com.auto.framework.pageobjects.common.BasePage;
import com.auto.framework.pageobjects.demoautomationexercise.components.LoginForm;
import com.auto.framework.pageobjects.demoautomationexercise.components.SignUpForm;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginSignUpPage extends BasePage {
    @Autowired
    public LoginForm loginForm;
    @Autowired
    public SignUpForm signUpForm;

    @Step("Open webpage")
    public void openElementsPage() {
        iUIElements.openURL(myProperties.getDemoUrl());
    }
    @Step("Verify Page Title")
    public String getPageTitle() {
        return iElementVerification.getTitle();
    }
}
