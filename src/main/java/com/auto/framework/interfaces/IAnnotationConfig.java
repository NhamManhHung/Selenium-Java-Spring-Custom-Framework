package com.auto.framework.interfaces;

import com.auto.framework.annotations.FindByCustom;
import org.openqa.selenium.By;

public interface IAnnotationConfig {
    public void initCustomLocators(Object pageObject);
}
