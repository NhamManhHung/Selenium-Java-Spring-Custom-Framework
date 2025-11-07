package com.auto.framework.pageobjects.demogeniusocean;

import com.auto.framework.pageobjects.common.BasePage;
import com.auto.framework.pageobjects.demogeniusocean.components.other.ConfirmationPF;
import com.auto.framework.pageobjects.demogeniusocean.components.login.LoginPF;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {
    @Autowired
    public LoginPF loginPF;
    @Autowired
    public ConfirmationPF confirmationPF;

    @Step("Open webpage")
    public void openElementsPage() {
        iUIElements.openURL(myProperties.getDemoUrl());
    }

    @Step("Verify Page Title")
    public String getPageTitle() {
        return iElementVerification.getTitle();
    }
}
