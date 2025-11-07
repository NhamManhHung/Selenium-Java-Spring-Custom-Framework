package com.auto.framework.interfaces;

public interface IDynamicFakeDataGenerator {
    public <T> T generateFromTemplate(String jsonTemplatePath, Class<T> clazz);
}
