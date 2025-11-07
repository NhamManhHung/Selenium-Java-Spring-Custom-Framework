package com.auto.framework;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.auto.framework.driverscope.DriverScope;
import com.auto.framework.pageobjects.demoautomationexercise.LoginSignUpPage;
import com.auto.framework.pageobjects.demogeniusocean.LoginPage;
import com.auto.framework.pageobjects.demogeniusocean.NewProductPage;
import com.auto.framework.pageobjects.demogeniusocean.testdata.Config;
import com.auto.framework.pageobjects.demogeniusocean.testdata.PhysicalProductDataProvider;
import com.auto.framework.pageobjects.demogeniusocean.testdata.models.PhysicalProduct;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.auto.framework.listeners.TestListener;
import com.auto.framework.pageobjects.common.BasePage;

/************************************************************************************************************************
 * @Date : Oct. 20, 2023
 * @Author : naveenchr
 * @Description : Element validation tests
 * @Version : 1.0
 ********************************************************** **************************************************************/
@Slf4j
@SpringBootTest
@Listeners(TestListener.class)
public class ElementTests extends AbstractTestNGSpringContextTests {
    @Autowired
    private BasePage basePage;
    @Autowired
    public LoginPage loginPage;
    @Autowired
    public NewProductPage newProductPage;
    @Autowired
    public LoginSignUpPage loginSignUpPage;


    //Testcase login and signup Automation Exercise
/*    @Test(priority = 1, groups = "Sanity Test")
    public void sanityCheck() {
        loginSignUpPage.openElementsPage();
        assertThat(loginSignUpPage.getPageTitle(), is("Automation Exercise"));
    }

    @Test(priority = 2, dependsOnGroups = "Sanity Test", dataProvider = "Account Data", dataProviderClass = AccountDataProvider.class)
    public void testSignUp_TC001(AccountInformation accountInformation) {
        String expectedName = "nhamhung123";
        String expectedEmail = "nhamhung30032003123@gmail.com";
        String expectedMessage = "ACCOUNT CREATED!";

        loginSignUpPage.openElementsPage();


        loginSignUpPage.loginForm.clickLoginMenuButton();
        loginSignUpPage.loginForm.enterNameSignUp(accountInformation.getName());
        loginSignUpPage.loginForm.enterEmailAddressSignUp(accountInformation.getEmail());
        loginSignUpPage.loginForm.clickSignUpButton();

        loginSignUpPage.signUpForm.selectTitle();
        loginSignUpPage.signUpForm.enterPassword(accountInformation.getPassword());
        loginSignUpPage.signUpForm.selectDay(accountInformation.getDay());
        loginSignUpPage.signUpForm.selectMonth("May");
        loginSignUpPage.signUpForm.selectYear(accountInformation.getYear());
        loginSignUpPage.signUpForm.enterFirstName(accountInformation.getFirstName());
        loginSignUpPage.signUpForm.enterLastName(accountInformation.getLastName());
        loginSignUpPage.signUpForm.enterAddress(accountInformation.getAddress());
        loginSignUpPage.signUpForm.selectCountry("Canada");
        loginSignUpPage.signUpForm.enterState(accountInformation.getState());
        loginSignUpPage.signUpForm.enterCity(accountInformation.getCity());
        loginSignUpPage.signUpForm.enterZipCode(accountInformation.getZipcode());
        loginSignUpPage.signUpForm.enterMobileNumber(accountInformation.getMobileNumber());
        loginSignUpPage.signUpForm.clickCreateAccount();

        assertThat("Message Account Created ! should display", loginSignUpPage.signUpForm.getAccountCreatedMessage(), is(expectedMessage));
    }

    @Test(priority = 3, dependsOnGroups = "Sanity Test")
    public void testLogin_TC002() {
        String expectedPassword = "123456";
        String expectedEmail = "nhamhung30032003123@gmail.com";

        loginSignUpPage.openElementsPage();
        loginSignUpPage.loginForm.clickLoginMenuButton();
        loginSignUpPage.loginForm.enterPasswordLogin(expectedPassword);
        loginSignUpPage.loginForm.enterEmailAddressLogin(expectedEmail);
        loginSignUpPage.loginForm.clickLoginMenuButton();

        assertThat("Logout button displayed after login", loginSignUpPage.loginForm.isLogoutButtonDisplayed(), is(true));
    }
*/

    //Testcase QA
/*
	@Test(dependsOnGroups = "Sanity Test", dataProvider = "User Data", dataProviderClass = UserDataProvider.class)
	public void textBoxVal__TC001(UserModal userData) {f
		// Opens browser page
		elementsPage.textBoxPF.openTextBoxPage();

		// Perform testing actions
		elementsPage.textBoxPF.enterFullname(userData.getFirstName());
		elementsPage.textBoxPF.enterEmail(userData.getEmail());
		elementsPage.textBoxPF.enterCurrentAddress(userData.getCurrAddress());
		elementsPage.textBoxPF.enterPermanentAddress(userData.getPermAddress());
		elementsPage.textBoxPF.submitForm();

		// Assert data points
		assertThat(elementsPage.textBoxPF.getConfirmationMessage().getFirstName(), is(userData.getFirstName()));
		assertThat(elementsPage.textBoxPF.getConfirmationMessage().getEmail(), is(userData.getEmail()));
		assertThat(elementsPage.textBoxPF.getConfirmationMessage().getCurrAddress(), is(userData.getCurrAddress()));
		assertThat(elementsPage.textBoxPF.getConfirmationMessage().getPermAddress(), is(userData.getPermAddress()));

	}


  @Test(dependsOnGroups = "Sanity Test")
	public void checkBoxVal__TC002() {
		elementsPage.checkBoxPF.openCheckBoxPage();

		elementsPage.checkBoxPF.expandLevel1Menu();
		elementsPage.checkBoxPF.expandLevel2Menu("Documents");
		elementsPage.checkBoxPF.expandLevel3Menu("Workspace");
		elementsPage.checkBoxPF.clickLevel4Option("Angular");

		assertThat(elementsPage.checkBoxPF.getConfirmationMessage(), is("angular"));

	}

	@Test(dependsOnGroups = "Sanity Test")
	public void RadioButtonVal__TC003() {
		elementsPage.radioButtonPF.openRadioButtonPage();

		elementsPage.radioButtonPF.clickRadioButton("Impressive");

		assertThat(elementsPage.radioButtonPF.getConfirmationMessage(), is("Impressive"));
	}
*/

    //Testcase GO
    @Test(groups = "Sanity Test")
    public void sanityCheck() {
        loginPage.openElementsPage();
        assertThat(loginSignUpPage.getPageTitle(), is("Genius-Shop"));
    }

    @Test(dependsOnGroups = "Sanity Test")
    public void testLogin_TC001() {
        String expectedUsername = "admin@gmail.com";
        String expectedPassword = "1234";
        String expectedSuccessMessage = "Success !";

        loginPage.openElementsPage();

        loginPage.loginPF.enterUsername(expectedUsername);
        loginPage.loginPF.enterPassword(expectedPassword);
        loginPage.loginPF.clickLoginButton();

        assertThat(loginPage.confirmationPF.getSuccessMessage(), is(expectedSuccessMessage));
    }

/*    @BeforeMethod(onlyForGroups = "newProduct")
    @Test(dependsOnGroups = "Sanity Test")
    public void testAddProductMenu_TC001() {
        String expectedTitle = "Add Product";
        String expectedUsername = "admin@gmail.com";
        String expectedPassword = "1234";

        loginPage.openElementsPage();

        loginPage.loginPF.enterUsername(expectedUsername);
        loginPage.loginPF.enterPassword(expectedPassword);
        loginPage.loginPF.clickLoginButton();

        newProductPage.addProductMenuPF.clickProductLink();
        newProductPage.addProductMenuPF.clickAddNewProductLink();

        assertThat(loginPage.confirmationPF.getAddProductTitle(), is(expectedTitle));
    }
*/

    @Test(dependsOnGroups = "Sanity Test", dataProvider = "Physical Product Data", dataProviderClass = PhysicalProductDataProvider.class)
    public void testNewPhysicalProduct_TC002(PhysicalProduct physicalProduct) {
        String expectedAddPhysicalMessage = "You can't access in demo version";

        String expectedUsername = "admin@gmail.com";
        String expectedPassword = "1234";

        loginPage.openElementsPage();

        loginPage.loginPF.enterUsername(expectedUsername);
        loginPage.loginPF.enterPassword(expectedPassword);
        loginPage.loginPF.clickLoginButton();

        newProductPage.addProductMenuPF.clickProductLink();
        newProductPage.addProductMenuPF.clickAddNewProductLink();

        newProductPage.newPhysicalProductPF.clickPhysicalProductLink();

        newProductPage.newPhysicalProductPF.enterProductName(physicalProduct.getName());
        //newProductPage.newPhysicalProductPF.enterProductSKU();
        newProductPage.newPhysicalProductPF.selectCategory(physicalProduct.getCategory());
        //newProductPage.newPhysicalProductPF.selectSubCategory();
        //newProductPage.newPhysicalProductPF.selectChildCategory();
        newProductPage.newPhysicalProductPF.checkProductCondition(physicalProduct.isProductCondition());
        newProductPage.newPhysicalProductPF.checkProductPreorder(physicalProduct.isPreorder());
        newProductPage.newPhysicalProductPF.checkMinimumOrderQty(physicalProduct.isMinimumOrderQtyEnabled());
        newProductPage.newPhysicalProductPF.checkEstimatedShippingTime(physicalProduct.isEstimatedShippingTimeEnabled());
        newProductPage.newPhysicalProductPF.checkProductWholeSell(false);
        newProductPage.newPhysicalProductPF.checkProductMeasurement(physicalProduct.isMeasurementEnabled());
        newProductPage.newPhysicalProductPF.checkProductColors(false);
        newProductPage.newPhysicalProductPF.checkManageStock(false);
        newProductPage.newPhysicalProductPF.enterProductStock(physicalProduct.getStock());
        newProductPage.newPhysicalProductPF.enterProductDescription(physicalProduct.getDescription());
        newProductPage.newPhysicalProductPF.enterProductPolicy(physicalProduct.getPolicy());
        newProductPage.newPhysicalProductPF.checkProductSEO(physicalProduct.isSeoEnabled());
        //newProductPage.newPhysicalProductPF.uploadFeatureImage();
        newProductPage.newPhysicalProductPF.enterProductCurrentPrice(Math.ceil(physicalProduct.getCurrentPrice()));
        newProductPage.newPhysicalProductPF.enterProductDiscountPrice(Math.ceil(physicalProduct.getDiscountPrice()));
        newProductPage.newPhysicalProductPF.enterYoutubeVideoURL(physicalProduct.getYoutubeUrl());
        newProductPage.newPhysicalProductPF.enterTag(physicalProduct.getTags());
        newProductPage.newPhysicalProductPF.clickCreateProductButton();

        assertThat(newProductPage.confirmationPF.getAddPhysicalMessage(), is(expectedAddPhysicalMessage));
    }

    @Test(dependsOnGroups = "Sanity Test", groups = "newProduct")
    public void testNewDigitalProduct_TC003() {
        String expectedUsername = "admin@gmail.com";
        String expectedPassword = "1234";

        loginPage.openElementsPage();

        loginPage.loginPF.enterUsername(expectedUsername);
        loginPage.loginPF.enterPassword(expectedPassword);
        loginPage.loginPF.clickLoginButton();

        newProductPage.addProductMenuPF.clickProductLink();
        newProductPage.addProductMenuPF.clickAddNewProductLink();
        newProductPage.newDigitalProductPF.clickDigitalProductLink();
    }

    @BeforeMethod(firstTimeOnly = true)
    public void initLogging() {
        //super.springTestContextPrepareTestInstance();
        String threadName = Thread.currentThread().getName();
        MDC.put("threadName", threadName);
    }

//    @AfterMethod(alwaysRun = true)
//    public void teardownDriver() {
//        MDC.remove("threadName");
//        //basePage.teardownDriver();
//    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod(ITestResult result) {
        try {
            MDC.remove("threadName");
            String threadName = Thread.currentThread().getName();
            log.info("[CLEANUP] Thread {} -> Cleaning WebDriver after test '{}'",
                    threadName, result.getMethod().getMethodName());
            DriverScope.getInstance().cleanupThread();
        } catch (Exception e) {
            log.warn("[DriverScope] Cleanup failed: {}", e.getMessage());
        }
    }


}
