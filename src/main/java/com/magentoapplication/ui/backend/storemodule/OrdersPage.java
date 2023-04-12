package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

    WebDriver driver;

    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        storeModuleDashboardPage=new StoreModuleDashboardPage(driver);
    }

    //Elements Meryem Create A new order
//     @FindBy(xpath = "//span[contains(text(),'Sales')]")
//    WebElement salesLink;
//    @FindBy(xpath = "//span[contains(text(),'Orders')]")
//    WebElement ordersButton;
    @FindBy(xpath = "(//h3[contains(text(),'Orders')])[1]")
    WebElement ordersPage;
    @FindBy(id = "sales_order_grid_filter_real_order_id")
    WebElement orderNumField;
    @FindBy(xpath = "(//span[contains(text(),'Search')])[2]")
    WebElement searchBut;
    @FindBy(xpath = "//td[contains(text(),'100000338 ')]")
    WebElement selectedNum;
    @FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
    WebElement cancelBut;
    @FindBy(xpath = "//span[contains(text(),'The order has been cancelled.')]")
    WebElement cancelSucMessage;




    //Elements Meryem edit orders



    //Meryem create Order Method



   public void cancelOrders(){
       functionClass.waitUntilElementPresent(storeModuleDashboardPage.salesLink);
       functionClass.waitUntilElementPresent(storeModuleDashboardPage.orderLink);
       storeModuleDashboardPage.clickOnOrderLink();
       functionClass.waitUntilElementPresent(ordersPage);
       ordersPage.isDisplayed();
       functionClass.waitUntilElementPresent(orderNumField);
       orderNumField.sendKeys();
       functionClass.waitUntilElementPresent(searchBut);
       searchBut.click();
       functionClass.waitUntilElementPresent(selectedNum);
       selectedNum.click();
       functionClass.waitUntilElementPresent(cancelBut);
       cancelBut.click();
       Alert alert=driver.switchTo().alert();
       alert.accept();

   }
   public boolean cancelOrdersSuccessful(){
       functionClass.waitUntilElementPresent(cancelSucMessage);
       if (cancelSucMessage.isDisplayed())
           return true;
       else return false;
   }




}
