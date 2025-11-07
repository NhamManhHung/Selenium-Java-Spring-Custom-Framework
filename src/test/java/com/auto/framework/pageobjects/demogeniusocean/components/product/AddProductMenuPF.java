package com.auto.framework.pageobjects.demogeniusocean.components.product;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class AddProductMenuPF extends BasePage {
    private static final By addNewProductLink = By.xpath("//*[@id='menu2']/li[1]/a");
    private static final By productLink = By.xpath("//*[@id=\"accordion\"]/li[6]/a");

    @Step("Click on Add New Product link")
    public void clickAddNewProductLink() {
        iUIElements.click(addNewProductLink);
    }

    @Step("Click on Product link")
    public void clickProductLink() {
        iUIElements.click(productLink);
    }
}
