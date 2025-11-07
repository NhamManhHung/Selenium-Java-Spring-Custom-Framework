package com.auto.framework.pageobjects.demogeniusocean.components.other;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationPF extends BasePage {
    private static By successMessage = By.xpath("//*[@id=\"page-top\"]/div[1]/div/div[1]/div/div/a/img");
    private static By addProductTitle = By.xpath("//*[@id=\"page-top\"]/div[1]/div/div[2]/div/div[1]/div/div/h4");
    private static By addPhysicalMessage = By.xpath("//*[@id=\"geniusform\"]/div[1]/p");

    @Step("Check success message")
    public String getSuccessMessage() {
        WebElement element = iExplicitWait.waitForElementVisible(successMessage);
        if(element.isDisplayed()){
            return "Success !";
        }
        return "Fail !";
    }
    @Step("Check success message")
    public String getAddPhysicalMessage() {
        WebElement element = iExplicitWait.waitForElementVisible(addPhysicalMessage);
        if(element.isDisplayed()){
            return iElementVerification.getText(addPhysicalMessage);
        }
        return "Fail !";
    }
    @Step("Check Add Product Title message")
    public String getAddProductTitle() {
        return iElementVerification.getText(addProductTitle);
    }
}
