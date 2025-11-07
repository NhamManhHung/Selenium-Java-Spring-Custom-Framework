package com.auto.framework.pageobjects.demogeniusocean.components.product;

import com.auto.framework.pageobjects.common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class NewDigitalProductPF extends BasePage {
    //private static By physicalProductLink = By.xpath("//*[@id=\"page-top\"]//a[@href =\"https://cleandemo.geniusocean.net/geniuscart2/admin/products/physical/create\"]");
    private static final By digitalProductLink = By.xpath("//*[@id=\"page-top\"]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/a");

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
    private static final By productDescriptionTextArea = By.xpath("//*[@id='geniusform']/div[3]/div[1]/div/div/div/div/div/div[27]/div[2]/div/textarea");
    private static final By productPolicyTextArea = By.xpath("//*[@id='geniusform']/div[3]/div[1]/div/div/div/div/div/div[28]/div[2]/div/textarea");

    private static final By productSEOCheckBox = By.id("allowProductSEO");
    private static final By featureImageUpload = By.id("crop-image");

    private static final By productCurrentPriceInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[3]/div[2]/input");
    private static final By productDiscountPriceInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[4]/div[2]/input");
    private static final By youtubeVideoURLInput = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[5]/div[2]/input");

    private static final By tagInput = By.xpath("//*[@id='tags']/li/input");
    private static final By createProductButton = By.xpath("//*[@id='geniusform']/div[3]/div[2]/div/div/div/div/div/div[8]/div/button");

    @Step("Click on 'Digital Product link")
    public void clickDigitalProductLink() {
        iUIElements.click(digitalProductLink);
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
    public void checkProductCondition() {
        iUIElements.click(productConditionCheckBox);
    }

    @Step("Check 'Allow Product Preorder'")
    public void checkProductPreorder() {
        iUIElements.click(productPreorderCheckBox);
    }

    @Step("Check 'Allow Minimum Order Quantity'")
    public void checkMinimumOrderQty() {
        iUIElements.click(minimumOrderQtyCheckBox);
    }

    @Step("Check 'Allow Estimated Shipping Time'")
    public void checkEstimatedShippingTime() {
        iUIElements.click(estimatedShippingTimeCheckBox);
    }

    @Step("Check 'Allow Product Whole Sell'")
    public void checkProductWholeSell() {
        iUIElements.click(productWholeSellCheckBox);
    }

    @Step("Check 'Allow Product Measurement'")
    public void checkProductMeasurement() {
        iUIElements.click(productMeasurementCheckBox);
    }

    @Step("Check 'Allow Product Colors'")
    public void checkProductColors() {
        iUIElements.click(productColorsCheckBox);
    }

    @Step("Check 'Manage Stock'")
    public void checkManageStock() {
        iUIElements.click(stockCheckBox);
    }

    @Step("Enter Product Stock: {stock}")
    public void enterProductStock(String stock) {
        iUIElements.sendKeys(productStockInput, stock);
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
    public void enableProductSEO() {
        iUIElements.click(productSEOCheckBox);
    }

    @Step("Upload Feature Image: {filePath}")
    public void uploadFeatureImage(String filePath) {
        //iUIElements.uploadFile(featureImageUpload, filePath);
    }

    @Step("Enter Product Current Price: {price}")
    public void enterProductCurrentPrice(String price) {
        iUIElements.sendKeys(productCurrentPriceInput, price);
    }

    @Step("Enter Product Discount Price: {discount}")
    public void enterProductDiscountPrice(String discount) {
        iUIElements.sendKeys(productDiscountPriceInput, discount);
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
