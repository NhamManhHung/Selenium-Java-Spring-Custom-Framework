package com.auto.framework.pageobjects.demogeniusocean.components.product;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class NewPhysicalProductPF extends BasePage {
    //private static By physicalProductLink = By.xpath("//*[@id=\"page-top\"]//a[@href =\"https://cleandemo.geniusocean.net/geniuscart2/admin/products/physical/create\"]");
    private static final By physicalProductLink = By.xpath("//*[@id='page-top']/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/a");

    private static final By productNameInput = By.xpath("//*[@id='geniusform']/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/input");
    private static final By productSkuInput = By.xpath("//*[@id='geniusform']/div[3]/div[1]/div/div/div/div/div/div[3]/div[2]/input");
    private static final By categorySelect = By.id("cat");
    private static final By subCategorySelect = By.id("subcat");
    private static final By childCategorySelect = By.id("childcat");

    private static final By productConditionCheckBox = By.id("product_condition_check");
    private static final By productPreorderCheckBox = By.id("preorderedCheck");
    private static final By minimumOrderQtyCheckBox = By.id("check111");
    private static final By estimatedShippingTimeCheckBox = By.id("check1");
    private static final By productWholeSellCheckBox = By.id("whole_check");
    private static final By productMeasurementCheckBox = By.id("measure_check");
    private static final By productColorsCheckBox = By.id("check3");
    private static final By stockCheckBox = By.id("size-check");

    private static final By productStockInput = By.xpath("//*[@id='default_stock']/div[2]/input");
    private static final By productDescriptionTextArea = By.xpath("//*[@id=\"geniusform\"]/div[3]/div[1]/div/div/div/div/div/div[27]/div[2]/div/div[2]/div");
    private static final By productPolicyTextArea = By.xpath("//*[@id=\"geniusform\"]/div[3]/div[1]/div/div/div/div/div/div[28]/div[2]/div/div[2]/div");

    private static final By productSEOCheckBox = By.id("allowProductSEO");
    private static final By featureImageUpload = By.id("crop-image");

    private static final By productCurrentPriceInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[3]/div[2]/input");
    private static final By productDiscountPriceInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[4]/div[2]/input");
    private static final By youtubeVideoURLInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[5]/div[2]/input");

    private static final By tagInput = By.xpath("//*[@id='tags']/li/input");
    private static final By createProductButton = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[8]/div/button");

    @Step("Click on 'Physical Product link")
    public void clickPhysicalProductLink() {
        iUIElements.click(physicalProductLink);
    }

    @Step("Enter Product Name: {productName}")
    public void enterProductName(String productName) {
        iUIElements.sendKeys(productNameInput, productName);
    }

    @Step("Enter Product SKU: {sku}")
    public void enterProductSKU(String sku) {
        iUIElements.sendKeys(productSkuInput, sku);
    }

    @Step("Select Category: {category}")
    public void selectCategory(String category) {
        iUIElements.selectByVisibleText(categorySelect, category);
    }

    @Step("Select Sub Category: {subCategory}")
    public void selectSubCategory(String subCategory) {
        iUIElements.selectByVisibleText(subCategorySelect, subCategory);
    }

    @Step("Select Child Category: {childCategory}")
    public void selectChildCategory(String childCategory) {
        iUIElements.selectByVisibleText(childCategorySelect, childCategory);
    }

    @Step("Check 'Allow Product Condition'")
    public void checkProductCondition(boolean isCheck) {
        iUIElements.checkBox(productConditionCheckBox, isCheck);
    }

    @Step("Check 'Allow Product Preorder'")
    public void checkProductPreorder(boolean isCheck) {
        iUIElements.checkBox(productPreorderCheckBox, isCheck);
    }

    @Step("Check 'Allow Minimum Order Quantity'")
    public void checkMinimumOrderQty(boolean isCheck) {
        iUIElements.checkBox(minimumOrderQtyCheckBox, isCheck);
    }

    @Step("Check 'Allow Estimated Shipping Time'")
    public void checkEstimatedShippingTime(boolean isCheck) {
        iUIElements.checkBox(estimatedShippingTimeCheckBox, isCheck);
    }

    @Step("Check 'Allow Product Whole Sell'")
    public void checkProductWholeSell(boolean isCheck) {
        iUIElements.checkBox(productWholeSellCheckBox, isCheck);
    }

    @Step("Check 'Allow Product Measurement'")
    public void checkProductMeasurement(boolean isCheck) {
        iUIElements.checkBox(productMeasurementCheckBox, isCheck);
    }

    @Step("Check 'Allow Product Colors'")
    public void checkProductColors(boolean isCheck) {
        iUIElements.checkBox(productColorsCheckBox, isCheck);
    }

    @Step("Check 'Manage Stock'")
    public void checkManageStock(boolean isCheck) {
        iUIElements.checkBox(stockCheckBox, isCheck);
    }

    @Step("Enter Product Stock: {stock}")
    public void enterProductStock(int stock) {
        iUIElements.sendKeys(productStockInput, String.valueOf(stock));
    }

    @Step("Enter Product Description")
    public void enterProductDescription(String description) {
        iUIElements.sendKeys(productDescriptionTextArea, description);
    }

    @Step("Enter Product Policy")
    public void enterProductPolicy(String policy) {
        iUIElements.sendKeys(productPolicyTextArea, policy);
    }

    @Step("Enable Product SEO")
    public void checkProductSEO(boolean isCheck) {
        iUIElements.checkBox(productSEOCheckBox, isCheck);
    }

    @Step("Upload Feature Image: {filePath}")
    public void uploadFeatureImage(String filePath) {
        //iUIElements.uploadFile(featureImageUpload, filePath);
    }

    @Step("Enter Product Current Price: {price}")
    public void enterProductCurrentPrice(double price) {
        iUIElements.sendKeys(productCurrentPriceInput, String.valueOf(price));
    }

    @Step("Enter Product Discount Price: {discount}")
    public void enterProductDiscountPrice(double discount) {
        iUIElements.sendKeys(productDiscountPriceInput, String.valueOf(discount));
    }

    @Step("Enter YouTube Video URL: {url}")
    public void enterYoutubeVideoURL(String url) {
        iUIElements.sendKeys(youtubeVideoURLInput, url);
    }

    @Step("Enter Tag: {tag}")
    public void enterTag(String tag) {
        iUIElements.sendKeys(tagInput, tag);
    }

    @Step("Click 'Create Product' button")
    public void clickCreateProductButton() {
        iUIElements.click(createProductButton);
    }

}
