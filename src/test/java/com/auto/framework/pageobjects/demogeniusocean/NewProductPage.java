package com.auto.framework.pageobjects.demogeniusocean;

import com.auto.framework.pageobjects.common.BasePage;
import com.auto.framework.pageobjects.demogeniusocean.components.product.AddProductMenuPF;
import com.auto.framework.pageobjects.demogeniusocean.components.other.ConfirmationPF;
import com.auto.framework.pageobjects.demogeniusocean.components.product.NewDigitalProductPF;
import com.auto.framework.pageobjects.demogeniusocean.components.product.NewPhysicalProductPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewProductPage extends BasePage {
    @Autowired
    public ConfirmationPF confirmationPF;
    @Autowired
    public AddProductMenuPF addProductMenuPF;
    @Autowired
    public NewPhysicalProductPF newPhysicalProductPF;
    @Autowired
    public NewDigitalProductPF newDigitalProductPF;
}
