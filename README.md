# Selenium Framework using Spring Boot

A test framework that utilizes Java Spring Boot capabilities to integrate key Selenium and TestNG features that can be used to create web-based automation scripts.

**Key Features**

* Supports Parallel test execution and thread management
* Using custom PageFactory annotation @FindByCustom
* Random test data generation by Java Faker combine with Excel template format data
* Spring dependency injection for object creation
* WebDriver manager-based browser initiation
* Platform independent
* Integration with Allure reports
* Integrated with sonarQube for vulnerability analysis
* Avoids boilerplate codes utilizing Lombok

# Table of contents
* [Folder Structure](#folder-structure)
* [Installation](#installation)
* [Built With](#built-with)
* [Contributing](#contributing)

# Folder Structure
```
src/
├── main
│   ├── java/com/auto/framework
│   │   ├── SpringAutoFrameworkApplication.java
│   │   ├── actions
│   │   │   ├── ActionsBaseClass.java
│   │   │   ├── ElementVerification.java
│   │   │   ├── ExplicitWait.java
│   │   │   ├── JavaScriptActions.java
│   │   │   ├── UIElements.java
│   │   │   └── UtilityClass.java
│   │   ├── annotations
│   │   │   ├── AnnotationConfig.java
│   │   │   └── FindByCustom.java
│   │   ├── config
│   │   │   ├── MyProperties.java
│   │   │   └── WebDriverConfig.java
│   │   ├── constants
│   │   │   └── Constants.java
│   │   ├── datafilehandler
│   │   │   └── DynamicFakeDataGenerator.java
│   │   ├── driverscope
│   │   │   ├── DriverScope.java
│   │   │   ├── DriverScopeConfig.java
│   │   │   └── DriverScopePostProcessor.java
│   │   ├── interfaces
│   │   │   ├── IAnnotationConfig.java
│   │   │   ├── IDynamicFakeDataGenerator.java
│   │   │   ├── IElementVerification.java
│   │   │   ├── IExplicitWait.java
│   │   │   ├── IJavaScriptActions.java
│   │   │   └── IUIElements.java
│   │   └── listeners
│   │       └── TestListener.java
│   └── resources
│       ├── application.properties
│       ├── application-demoAE.properties
│       ├── application-demoGO.properties
│       └── logback-spring.xml
└── test
    ├── java/com/auto/framework
    │   ├── ElementTests.java
    │   └── pageobjects
    │       ├── common/BasePage.java
    │       ├── demoautomationexercise
    │       │   ├── LoginSignUpPage.java
    │       │   └── components
    │       │       ├── LoginForm.java
    │       │       └── SignUpForm.java
    │       ├── demogeniusocean
    │       │   ├── LoginPage.java
    │       │   ├── NewProductPage.java
    │       │   └── components
    │       │       ├── coupon/NewCouponPF.java
    │       │       ├── login/LoginPF.java
    │       │       ├── other/ConfirmationPF.java
    │       │       └── product
    │       │           ├── AddProductMenuPF.java
    │       │           ├── NewDigitalProductPF.java
    │       │           └── NewPhysicalProductPF.java
    │       ├── demoqa
    │       │   ├── CheckBoxPF.java
    │       │   ├── ElementsPage.java
    │       │   ├── RadioButtonPF.java
    │       │   ├── TextBoxPF.java
    │       │   └── WebTablePF.java
    │       └── testdata
    │           ├── AccountDataProvider.java
    │           ├── AccountInformation.java
    │           ├── User.java
    │           ├── UserDataProvider.java
    │           └── UserModal.java
    └── resources
        ├── Suites.xml
        ├── Element-Tests.xml
        └── json/physical-product.json

```


# Installation

Clone the repo from GitHub using below command
```git
git clone https://github.com/NhamManhHung/Selenium-Java-Spring-Custom-Framework.git
```
Clean and compile the maven project using below commands

```maven
mvn clean
mvn compile
```

# Running the tests

**From Command Prompt**

```maven
mvn test
```
or using 
```maven
mvn clean test
```
Parameters can be overridden as follows or updated directly on application.properties file

```maven
mvn clean test "-Dspring.profiles.active=demoGO"   
```

**Report Location**

1) Navigate to the "target" folder
2) Execute the below allure command

```maven
allure serve -h localhost
```

# Built With

* Spring Boot
* Selenium WebDriver
* TestNG
* Maven
* Allure Reports
* Hamcrest
* Lombok
* Java Faker

# Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you want to change.
