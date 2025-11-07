package com.auto.framework.pageobjects.demogeniusocean.testdata;

import com.auto.framework.interfaces.IDynamicFakeDataGenerator;
import com.auto.framework.pageobjects.common.BasePage;
import com.auto.framework.pageobjects.demogeniusocean.testdata.helper.ApplicationContextProvider;
import com.auto.framework.pageobjects.demogeniusocean.testdata.models.PhysicalProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

@Slf4j
@Component
public class PhysicalProductDataProvider extends BasePage {
    @DataProvider(name = "Physical Product Data", parallel = true)
    public static Object[][] providePhysicalProductData() {
        IDynamicFakeDataGenerator iDynamicFakeDataGenerator = ApplicationContextProvider.getBean(IDynamicFakeDataGenerator.class);

        PhysicalProduct physicalProduct = iDynamicFakeDataGenerator.generateFromTemplate(Config.PHYSICAL_PRODUCT_FILE_PATH, PhysicalProduct.class);
        return new Object[][] { { physicalProduct } };
    }
}
