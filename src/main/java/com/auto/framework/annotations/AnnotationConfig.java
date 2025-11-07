package com.auto.framework.annotations;

import com.auto.framework.interfaces.IAnnotationConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Component
public class AnnotationConfig implements IAnnotationConfig {
    @Override
    public void initCustomLocators(Object pageObject) {
        Class<?> clazz = pageObject.getClass();
        //log.info("Initializing custom locators for: {}", clazz.getSimpleName());

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(FindByCustom.class)) {
                FindByCustom annotation = field.getAnnotation(FindByCustom.class);
                By locator = buildByFromAnnotation(annotation);

                try {
                    field.setAccessible(true);
                    field.set(pageObject, locator);
                    log.debug("Set locator for field: {}", field.getName());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot set locator for field: " + field.getName(), e);
                }
            }
        }
    }

    private By buildByFromAnnotation(FindByCustom annotation) {
        String id = annotation.id();
        String name = annotation.name();
        String className = annotation.className();
        String tagName = annotation.tagName();
        String linkText = annotation.linkText();
        String partialLinkText = annotation.partialLinkText();
        String css = annotation.css();
        String xpath = annotation.xpath();

        if (!id.isEmpty()) return By.id(id);
        if (!name.isEmpty()) return By.name(name);
        if (!className.isEmpty()) return By.className(className);
        if (!tagName.isEmpty()) return By.tagName(tagName);
        if (!linkText.isEmpty()) return By.linkText(linkText);
        if (!partialLinkText.isEmpty()) return By.partialLinkText(partialLinkText);
        if (!css.isEmpty()) return By.cssSelector(css);
        return By.xpath(xpath);
    }
}
