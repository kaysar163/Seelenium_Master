package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import com.magentoapplication.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    Log4j log4j = new Log4j();


    public ManageCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
    }

    @FindBy(id = "customerGrid_filter_email")
    WebElement customerEmailField;

    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//a[text()='Edit']")
    WebElement editButton;

    @FindBy(xpath = "(//span[text()='Shopping Cart'])[2]")
    WebElement shoppingCartLink;

    @FindAll(
            @FindBy(xpath = "//table[@id='customer_cart_grid1_table']//tbody")
    )
    WebElement verifyShoppingCartViewed;

    @FindBy(id = "//table[@id='customer_cart_grid1_table']//tbody//tr//td")
    WebElement customerExist;

    @FindBy(xpath = "//strong[text()='Chelsea Tee']//following::td[5]//a[text()='Configure']")
    WebElement updateshoppingcart;

    @FindBy(id="product_composite_configure_input_qty")
    WebElement quantity;

    @FindBy(xpath = "//span[text()='OK']")
    WebElement OK;

    @FindBy(xpath = "//strong[text()='Chelsea Tee']//following::td[2][contains(text(),'2')]\n")
    WebElement verifyUpdateExitingShoppingCart;

    public void viewShoppingCartForCustomers() {
        salesDashboardPage.clickOnManageCustomersLink();
        functionClass.waitUntilElementPresent(customerEmailField);
        customerEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties", "loginEmail"));
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        functionClass.waitUntilElementPresent(editButton);
        functionClass.sleep(2);
        editButton.click();
        functionClass.waitUntilElementPresent(shoppingCartLink);
        shoppingCartLink.click();

    }

    public boolean verifyViewShoppingCartViewed() {
        functionClass.waitUntilElementPresent(verifyShoppingCartViewed);
        if (verifyShoppingCartViewed.isDisplayed()) {
            if (driver.getPageSource().contains("No records found.")) {
                System.out.println("shopping cart is empty");
            } else if (customerExist.isDisplayed()) {
                System.out.println("shopping cart is not empty");
            }
            log4j.info("---Test Passed---");
            return true;
        } else {
            log4j.info("---Test Failed---");
            return false;
        }
    }


        public void updateExistingShoppingCartForCustomers () {
            salesDashboardPage.clickOnManageCustomersLink();
            functionClass.waitUntilElementPresent(customerEmailField);
            customerEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties", "mEmail"));
            functionClass.waitUntilElementPresent(searchButton);
            searchButton.click();
            functionClass.waitUntilElementPresent(editButton);
            functionClass.sleep(2);
            editButton.click();
            functionClass.waitUntilElementPresent(shoppingCartLink);
            shoppingCartLink.click();
            functionClass.waitUntilElementPresent(updateshoppingcart);
            updateshoppingcart.click();
            functionClass.waitUntilElementPresent(quantity);
            quantity.sendKeys("5");
            functionClass.waitUntilElementPresent(OK);
            OK.click();

        }

    public boolean verifyUpdateShoppingCart(){
        functionClass.waitUntilElementPresent(verifyUpdateExitingShoppingCart);
        if (verifyUpdateExitingShoppingCart.isDisplayed())
            return true;
        else return false;

    }




}










