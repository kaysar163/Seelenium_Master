package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.apache.poi.sl.usermodel.ObjectMetaData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {
    
    WebDriver driver;
    
    FunctionClass functionClass;
    Actions actions;
    SalesDashboardPage salesDashboardPage;
    static final String config = "testdatafolder/testdata.properties";
    String creditMemoNumber = ApplicationConfig.readFromConfigProperties(config,"creditMemoNo");
    String orderNumber = ApplicationConfig.readFromConfigProperties(config, "orderNo");
    String refundQuantity = ApplicationConfig.readFromConfigProperties(config, "quantityToRefund");
    
    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
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
    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@name='real_order_id']")
    WebElement orderNumberInputField;
    @FindBy(xpath = "//tr//td[contains(text(),'otanBazar')]//following-sibling::td//a[contains(text(),'View')]")
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
        functionClass.sleep(5);
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
        functionClass.sleep(3);
        orderNumberInputField.sendKeys(orderNumber);
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
