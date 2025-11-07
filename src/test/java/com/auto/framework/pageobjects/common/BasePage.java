package com.auto.framework.pageobjects.common;

import static java.util.Objects.nonNull;

import com.auto.framework.driverscope.DriverScope;
import com.auto.framework.interfaces.*;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.auto.framework.actions.ActionsBaseClass;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;

/************************************************************************************************************************
 * @Date : Nov. 14, 2023
 * @Author : nachrist
 * @Description : Base page for all POM page classes
 * @Version : 1.0
 ************************************************************************************************************************/
@Slf4j
@Component
public class BasePage extends ActionsBaseClass {

    @Autowired
    public IUIElements iUIElements;

    @Autowired
    public IElementVerification iElementVerification;

    @Autowired
    public IExplicitWait iExplicitWait;

    @Autowired
    public IJavaScriptActions iJavaScriptActions;

    @Autowired
    public IAnnotationConfig iAnnotationConfig;

    @PostConstruct
    public void init() {
        iAnnotationConfig.initCustomLocators(this);
    }

    public void teardownDriver() {
        System.out.printf("[AfterMethod] Thread %s -> teardownDriver() called%n",
                Thread.currentThread().getName());
        log.info("Taking Screenshots");
        attachScreenShot();
        log.info("Closing Browsers");
        if (nonNull(driver)) {
            driver.quit();
        }
        //DriverScope.cleanup();
    }

    @Attachment(value = "Screen shot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenShot() {
        try {
            return ((TakesScreenshot) applicationContext.getBean(WebDriver.class)).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            log.error("Selenium screenshot capture failed: {}", e.getMessage());
        }
        return new byte[0];
    }

}
