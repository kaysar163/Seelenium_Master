package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {

    WebDriver driver;
    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        storeModuleDashboardPage = new StoreModuleDashboardPage(driver);
    }

    //Elements Meryem Create A new order
    // @FindBy(xpath ="(//span[text()='Sales'])[1]" )
    //   WebElement salesDropdown;
    //  @FindBy(xpath ="(//span[text()='Orders'])" )
    //   WebElement ordersButton;
    @FindBy(xpath = "(//span[text()='Create New Order'])[1]")
    WebElement createNewButton;
    @FindBy(xpath = "(//span[text()='Create New Customer'])[1]")
    WebElement createNewCustomerNewButton;
    @FindBy(xpath = "(//label[contains(text(),\"Demo Store View\")])[1]")
    WebElement selectedStore;
    @FindBy(xpath = "//span[text()='Add Products']")
    WebElement addProductsButton;
    @FindBy(xpath = "//td[contains(text(),' naike-Black-13 ')]//following-sibling::td[2]")
    WebElement selectedProduct;
    @FindBy(xpath = "(//span[text()='Add Selected Product(s) to Order'])[1]")
    WebElement addSelectedProductLink;
    @FindBy(id = "order-billing_address_firstname")
    WebElement firstNameField;
    @FindBy(id = "order-billing_address_lastname")
    WebElement lastNameField;
    @FindBy(id = "order-billing_address_street0")
    WebElement addressField;
    @FindBy(id = "order-billing_address_street0")
    WebElement streetAddressField;
    @FindBy(id = "order-billing_address_city")
    WebElement cityField;
    @FindBy(id = "order-billing_address_country_id")
    WebElement countryField;
    @FindBy(id = "order-billing_address_postcode")
    WebElement zipPostalCode;
    @FindBy(id = "order-billing_address_telephone")
    WebElement telephoneField;
    @FindBy(xpath = "//label[text()='Check / Money order']")
    WebElement selectedCheckMoney;
    @FindBy(xpath = "(//span[text()='Submit Order'])[2]")
    WebElement submitOrderButton;
    @FindBy(xpath = "//span[text()='The order has been created.']")
    WebElement successfulMessage;

    @FindBy(xpath = "//a[contains(text(),' Get shipping methods and rates')]")
    WebElement getShippingMethodLink;

    @FindBy(id = "s_method_flatrate_flatrate")
    WebElement fixedLink;

    //Elements Meryem edit orders

    // @FindBy(xpath ="//td[contains(text(),'meryem  Uyghur')]//following-sibling::td[5]  " )
    //  WebElement  viewButton;
    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    WebElement editButton;
    @FindBy(id = "order-billing_address_city")
    WebElement cityField1;

    //cancel order

    @FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
    WebElement cancelBut;
    @FindBy(xpath = "//span[contains(text(),'The order has been cancelled.')]")
    WebElement cancelSucMessage;



    public void addNewOrder() {
        storeModuleDashboardPage.clickOnOrderLink();
        functionClass.waitUntilElementPresent(createNewButton);
        createNewButton.click();
        functionClass.waitUntilElementPresent(createNewCustomerNewButton);
        createNewCustomerNewButton.click();
        functionClass.waitUntilElementPresent(selectedStore);
        functionClass.sleep(3);
        selectedStore.click();
        functionClass.waitUntilElementPresent(addProductsButton);
        functionClass.sleep(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(addProductsButton).build().perform();
        addProductsButton.click();
        functionClass.waitUntilElementPresent(selectedProduct);
        selectedProduct.click();
        functionClass.waitUntilElementPresent(addSelectedProductLink);
        addSelectedProductLink.click();
        functionClass.waitUntilElementPresent(firstNameField);
        TestHelperStore.setFirstname(functionClass.generateFakeName());
        firstNameField.sendKeys(TestHelperStore.getFirstname());
        functionClass.waitUntilElementPresent(lastNameField);
        lastNameField.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(addressField);
        addressField.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(streetAddressField);
        streetAddressField.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(cityField);
        cityField.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(countryField);
        Select select = new Select(countryField);
        select.selectByVisibleText("Turkey");
        functionClass.waitUntilElementPresent(zipPostalCode);
        zipPostalCode.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(telephoneField);
        telephoneField.sendKeys(functionClass.generateTelephoneNumber());
        functionClass.waitUntilElementPresent(selectedCheckMoney);
        selectedCheckMoney.click();
        functionClass.waitUntilElementPresent(getShippingMethodLink);
        getShippingMethodLink.click();
        functionClass.waitUntilElementPresent(fixedLink);
        fixedLink.click();
        functionClass.waitUntilElementPresent(submitOrderButton);
        functionClass.sleep(5);
        submitOrderButton.click();
        //   JavascriptExecutor jse = (JavascriptExecutor) driver;
        //  jse.executeScript("arguments[0].scrollIntoView()", submitOrderButton);

    }

    public boolean verifyOrderCreated() {
        functionClass.waitUntilElementPresent(successfulMessage);
        if (successfulMessage.isDisplayed())
            return true;
        else
            return false;
    }

    public void EditOrder() {
        storeModuleDashboardPage.clickOnOrderLink();
        WebElement viewButton = driver.findElement(By.xpath
                (String.format("//td[contains(text(),'%s')]//following-sibling::td[5]//a",
                        TestHelperStore.getFirstname())));
        functionClass.waitUntilElementPresent(viewButton);
        functionClass.sleep(3);
        viewButton.click();
        functionClass.waitUntilElementPresent(editButton);
        editButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        functionClass.waitUntilElementPresent(cityField1);
        cityField.clear();
        cityField.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(submitOrderButton);
        submitOrderButton.click();
    }

    public boolean verifyEditOrder() {
        functionClass.waitUntilElementPresent(successfulMessage);
        if (successfulMessage.isDisplayed())
            return true;
        else
            return false;
    }

    public void cancelOrders() {
        storeModuleDashboardPage.clickOnOrderLink();
        WebElement viewButton = driver.findElement(By.xpath
                (String.format("//td[contains(text(),'%s')]//following-sibling::td[5]//a",
                        TestHelperStore.getFirstname())));
        functionClass.waitUntilElementPresent(viewButton);
        functionClass.sleep(3);
        viewButton.click();
        functionClass.waitUntilElementPresent(cancelBut);
        cancelBut.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public boolean cancelOrdersSuccessful() {
        functionClass.waitUntilElementPresent(cancelSucMessage);
        if (cancelSucMessage.isDisplayed())
            return true;
        else return false;
    }

}










    //Meryem create Order Method












    //Meryem create Order Method



