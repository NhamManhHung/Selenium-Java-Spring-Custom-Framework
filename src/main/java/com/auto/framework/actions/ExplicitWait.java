package com.auto.framework.actions;

import com.auto.framework.interfaces.IExplicitWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

/************************************************************************************************************************
 * @Date : Sep. 25, 2023
 * @Author : naveenchr
 * @Description : Explicit wait implementation class
 * @Version : 1.0
 ************************************************************************************************************************/
@Slf4j
@Component
public class ExplicitWait extends ActionsBaseClass implements IExplicitWait {

	@Override
	public WebElement waitForElementToBeClickable(By by) {
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
	}

    @Override
    public WebElement waitForElementVisible(By by) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
