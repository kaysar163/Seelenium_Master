package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.ui.backend.marketingmodule.TestHelperMarketing;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPageSales {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    Actions actions;
    static final String config = "testdatafolder/testdata.properties";
    String creditMemoNumber = ApplicationConfig.readFromConfigProperties(config,"creditMemoNo");
    String orderNumber = ApplicationConfig.readFromConfigProperties(config, "orderNo");
    String refundQuantity = ApplicationConfig.readFromConfigProperties(config, "quantityToRefund");

    public OrdersPageSales(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
        actions=new Actions(driver);
    }

    @FindBy(xpath = "(//span[text()='Create New Order'])[1]")
    WebElement CreateNewOrderLink;
    @FindBy(xpath = "//span[contains(text(),'Create New Customer')]")
    WebElement CreateNewCustomerLink;
    @FindBy(id = "store_317")
    WebElement storeName;
    @FindBy(xpath = "//span[contains(text(),'Add Products')]")
    WebElement AddProductsLink;
    @FindBy(xpath = "//input[@value='2284']")
    WebElement selectBox;
    @FindBy(xpath = "//span[contains(text(),'Add Selected Product(s) to Order')]")
    WebElement addSelectedPrdcLink;
    @FindBy(id = "order-billing_address_firstname")
    WebElement firstNameField;
    @FindBy(id = "order-billing_address_lastname")
    WebElement lastNameField;
    @FindBy(id = "order-billing_address_street0")
    WebElement streetAddressField;
    @FindBy(id = "order-billing_address_city")
    WebElement cityField;
    @FindBy(id = "order-billing_address_country_id")
    WebElement countryField;
//    @FindBy(css = "select[id='order-billing_address_region_id']")
//    WebElement stateField;
    @FindBy(id = "order-billing_address_postcode")
    WebElement zipCodeField;
    @FindBy(id = "order-billing_address_telephone")
    WebElement telephoneField;
    @FindBy(xpath = "//input[@id='p_method_cashondelivery']")
    WebElement paymentMethodBut;
    @FindBy(xpath = "//a[normalize-space()='Get shipping methods and rates']")
    WebElement shippingMethodBut;
    @FindBy(xpath = "//input[@id='s_method_freeshipping_freeshipping']")
    WebElement freeShippingBut;
    @FindBy(xpath = "(//span[text()='Submit Order'])[2]")
    WebElement submitOrderBut;
    @FindBy(xpath = "//span[text()='The order has been created.']")
    WebElement successMessage;

    @FindBy(xpath = "//a[normalize-space()='View']")

    WebElement viewButton;
    @FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
    WebElement EditButton;
    @FindBy(id = "prefix")
    WebElement PrefixField;
    @FindBy(xpath = "(//button[@class='scalable save'])[1]")
    WebElement SaveOrderAdressButton;
    @FindBy(xpath = "//span[contains(text(),'The order address has been updated.')]")
    WebElement SuccessfulMessage;

    @FindBy(xpath = "(//h3[contains(text(),'Order #')])[1]")
    WebElement orderNumberElement;
    @FindBy(css = "input#sales_order_grid_filter_real_order_id")
    WebElement orderIdField;
    @FindBy(xpath = "//*[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[text()='View']")
    WebElement viewButtonDelete;
    @FindBy(xpath = "(//button[@title='Cancel' and @class='scalable '])[1]")
    WebElement cancelButton;
    @FindBy(xpath = "//*[text()='The order has been cancelled.']")
    WebElement orderDeleteSuccessMessage;
    @FindBy(xpath ="(//button[@title='Invoice'])[1]")
    WebElement invoiceButton;
    @FindBy(xpath = "//input[@id='invoice_do_shipment']")
    WebElement createShipmentCheckBox;
    @FindBy(xpath = "//input[@id='send_email']")
    WebElement emailInvoiceCheckBox;
    @FindBy(xpath = "//button[@title='Submit Invoice']")
    WebElement submitInvoiceButton;
    @FindBy(xpath = "(//button[@title='Send Email'])[1]")
    WebElement sendEmailButton;
    
    
    public String createNewOrder() {
        salesDashboardPage.clickOnOrdersLink();
        functionClass.waitUntilElementPresent(CreateNewOrderLink);
        CreateNewOrderLink.click();
        functionClass.waitUntilElementPresent(CreateNewCustomerLink);
        CreateNewCustomerLink.click();
        functionClass.waitUntilElementPresent(storeName);
        storeName.click();
        driver.navigate().refresh();
        functionClass.waitUntilElementPresent(AddProductsLink);
        functionClass.sleep(3);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()", AddProductsLink);
        //AddProductsLink.click();
        actions.click(AddProductsLink).build().perform();
        functionClass.waitUntilElementPresent(selectBox);
        selectBox.click();
        functionClass.waitUntilElementPresent(addSelectedPrdcLink);
        addSelectedPrdcLink.click();
        TestHelperSales.setFirstName(functionClass.generateFakeName());
        firstNameField.sendKeys(TestHelperSales.getFirstName());
        functionClass.waitUntilElementPresent(lastNameField);
        //lastNameField.sendKeys(functionClass.generateFakeLastName());
        TestHelperSales.setLastName(functionClass.generateFakeName());
        lastNameField.sendKeys(TestHelperSales.getLastName());
        functionClass.waitUntilElementPresent(streetAddressField);
        streetAddressField.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(cityField);
        cityField.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(countryField);
        //countryField.sendKeys(functionClass.generateCountryName());
        Select select=new Select(countryField);
        select.selectByValue("TR");
        functionClass.waitUntilElementPresent(zipCodeField);
        zipCodeField.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(telephoneField);
        telephoneField.sendKeys(functionClass.generateTelephoneNumber());
        functionClass.waitUntilElementPresent(paymentMethodBut);
        paymentMethodBut.click();
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(shippingMethodBut);
        shippingMethodBut.click();
        functionClass.waitUntilElementPresent(freeShippingBut);
        freeShippingBut.click();
        functionClass.sleep(5);
        functionClass.waitUntilElementPresent(submitOrderBut);
        submitOrderBut.click();
        functionClass.sleep(2);
        String orderNumberText = orderNumberElement.getText();
        String orderNumber = orderNumberText.substring(orderNumberText.indexOf("#") + 1, orderNumberText.indexOf("|")).trim();
        TestHelperSales.setIncrementId(orderNumber);
        System.out.println("Order number: " + orderNumber);
        functionClass.waitUntilElementPresent(invoiceButton);
        invoiceButton.click();
        functionClass.waitUntilElementPresent(createShipmentCheckBox);
        createShipmentCheckBox.click();
        functionClass.waitUntilElementPresent(emailInvoiceCheckBox);
        emailInvoiceCheckBox.click();
        functionClass.waitUntilElementPresent(submitInvoiceButton);
        submitInvoiceButton.click();
        functionClass.waitUntilElementPresent(sendEmailButton);
        sendEmailButton.click();
        functionClass.sleep(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return orderNumber;
        
    }
    public boolean verifyCreateOrder() {
        functionClass.waitUntilElementPresent(successMessage);
        if (successMessage.isDisplayed())
            return true;
        else return false;
    }
    public void UpdateOrderStorePicup() {
        salesDashboardPage.clickOnOrdersLink();

        //WebElement viewButton=driver.findElement
                //(By.xpath(String.format("(//td[contains(@class,'')][contains(text(),'%s')])//following-sibling::td//a",
                        //TestHelperSales.getFirstNameField())));
      //  functionClass.waitUntilElementPresent(viewButton);
        //viewButton.click();
        //functionClass.waitUntilElementPresent(EditButton);
        EditButton.click();
        functionClass.waitUntilElementPresent(PrefixField);
        PrefixField.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(SaveOrderAdressButton);
        SaveOrderAdressButton.click();

    }

    public boolean verifySuccessfulMessage() {
        functionClass.waitUntilElementPresent(SuccessfulMessage);
        if (SuccessfulMessage.isDisplayed()) {
            return true;
        } else return false;
    }
    public void deleteOrder(String orderNumber) {
        salesDashboardPage.clickOnOrdersLink();
        functionClass.waitUntilElementPresent(orderIdField);
        orderIdField.sendKeys(orderNumber);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        functionClass.waitUntilElementPresent(viewButtonDelete);
        functionClass.sleep(3);
        viewButtonDelete.click();
        functionClass.waitUntilElementPresent(cancelButton);
        cancelButton.click();
        functionClass.alertAccept();
    }

    public boolean deleteOrderSuccessful() {
        functionClass.waitUntilElementPresent(orderDeleteSuccessMessage);
        if (orderDeleteSuccessMessage.isDisplayed())
            return true;
        else return false;

    }
    
    //Toghraq
    @FindBy(xpath = "(//span[contains(text(),'Sales')])[1]")
    WebElement salesTab;
    @FindBy(xpath = "//input[@name='increment_id']")
    WebElement creditMemoNoInputField;
    @FindBy(xpath = "//li[@class='  level1']//a//span[contains(text(),'Orders')]")
    WebElement ordersLink;
    @FindBy(xpath = "//select[@name='status']")
    WebElement statusDropdownMenu;
//    @FindBy(xpath = "//button[@title='Search']")
//    WebElement searchButton;
    @FindBy(xpath = "//input[@name='real_order_id']")
    WebElement orderNumberInputField;
    @FindBy(xpath = "//tr//td//a[contains(text(),'View')]")
    WebElement viewLink;
    @FindBy(xpath = "(//button[@title='Credit Memo'])[1]")
    WebElement creditMemoButton;
    @FindBy(xpath = "//table[@class='data order-tables']//tbody//tr//td//input[@type='checkbox']")
    WebElement returnToStockCheckBox;
    @FindBy(css = ".input-text.qty-input")
    WebElement qtyToRefund;
    @FindBy(xpath = "//button[@title=\"Update Qty's\"]")
    WebElement updateQuantityButton;
    @FindBy(xpath = "//*//input[@id='send_email']")
    WebElement emailCopyOfCreditMemo;
    @FindBy(xpath = "//button[@title='Refund Offline']")
    WebElement refundOffLineButton;
    @FindBy(xpath = "//li//span[contains(text(),'Credit Memos')]")
    WebElement creditMemosLink;
    @FindBy(xpath = "//span[contains(text(),'The credit memo has been created.')]")
    WebElement creditMemoSuccessMessage;
    @FindBy(xpath = "(//td[contains(text(),'Refunded')])[3]")
    WebElement creditMemoRefunded;
    
    //views and adds credit memo
    public void viewAndCreateCreditMemo() {
        functionClass.waitUntilElementPresent(salesTab);
        Actions action = new Actions(driver);
        action.moveToElement(salesTab).perform();
        functionClass.waitUntilElementPresent(creditMemosLink);
        creditMemosLink.click();
        functionClass.waitUntilElementPresent(creditMemoNoInputField);
        creditMemoNoInputField.sendKeys(creditMemoNumber);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
//        functionClass.sleep(2);
        action.moveToElement(salesTab).perform();
        functionClass.waitUntilElementPresent(ordersLink);
        ordersLink.click();
        functionClass.waitUntilElementPresent(statusDropdownMenu);
        functionClass.sleep(2);
        Select object = new Select(statusDropdownMenu);
        object.selectByValue("complete");
        functionClass.sleep(1);
        searchButton.click();
        functionClass.waitUntilElementPresent(orderNumberInputField);
        functionClass.sleep(1);
        orderNumberInputField.sendKeys(orderNumber);
        functionClass.waitUntilElementPresent(searchButton);
        functionClass.sleep(2);
        searchButton.click();
        functionClass.waitUntilElementPresent(viewLink);
        functionClass.sleep(1);
        viewLink.click();
        functionClass.waitUntilElementPresent(creditMemoButton);
        creditMemoButton.click();
        functionClass.waitUntilElementPresent(returnToStockCheckBox);
        functionClass.sleep(2);
        returnToStockCheckBox.click();
        functionClass.waitUntilElementPresent(qtyToRefund);
        functionClass.sleep(2);
        qtyToRefund.clear();
        qtyToRefund.sendKeys(refundQuantity);
        functionClass.waitUntilElementPresent(updateQuantityButton);
        //functionClass.sleep(2);
        updateQuantityButton.click();
        functionClass.waitUntilElementPresent(emailCopyOfCreditMemo);
        //functionClass.sleep(2);
        emailCopyOfCreditMemo.click();
        functionClass.waitUntilElementPresent(refundOffLineButton);
        //functionClass.sleep(1);
        refundOffLineButton.click();
    }
    
    //only adds credit memo to a completed order
    public void addCreditMemo(){
        functionClass.waitUntilElementPresent(salesTab);
        Actions action = new Actions(driver);
        action.moveToElement(salesTab).perform();
        functionClass.waitUntilElementPresent(ordersLink);
        ordersLink.click();
        functionClass.waitUntilElementPresent(statusDropdownMenu);
        functionClass.sleep(2);
        Select object = new Select(statusDropdownMenu);
        object.selectByValue("complete");
//        functionClass.sleep(1);
//        searchButton.click();
        functionClass.waitUntilElementPresent(orderNumberInputField);
        functionClass.sleep(3);
        orderNumberInputField.sendKeys(TestHelperSales.getIncrementId());
        functionClass.waitUntilElementPresent(searchButton);
        functionClass.sleep(2);
        searchButton.click();
        functionClass.waitUntilElementPresent(viewLink);
        functionClass.sleep(3);
        viewLink.click();
        functionClass.waitUntilElementPresent(creditMemoButton);
        creditMemoButton.click();
        functionClass.waitUntilElementPresent(returnToStockCheckBox);
        functionClass.sleep(3);
        returnToStockCheckBox.click();
        functionClass.waitUntilElementPresent(qtyToRefund);
        functionClass.sleep(2);
        qtyToRefund.clear();
        qtyToRefund.sendKeys(refundQuantity);
        functionClass.waitUntilElementPresent(updateQuantityButton);
        functionClass.sleep(2);
        updateQuantityButton.click();
        functionClass.waitUntilElementPresent(emailCopyOfCreditMemo);
        functionClass.sleep(2);
        emailCopyOfCreditMemo.click();
        functionClass.waitUntilElementPresent(refundOffLineButton);
        functionClass.sleep(1);
        refundOffLineButton.click();
    }
    
    public boolean isCreditMemoCreated() {
        if (creditMemoSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }

}
