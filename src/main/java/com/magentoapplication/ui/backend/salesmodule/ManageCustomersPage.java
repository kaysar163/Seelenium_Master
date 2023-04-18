package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    public ManageCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        salesDashboardPage=new SalesDashboardPage(driver);
    }

    @FindBy(id = "customerGrid_filter_email")
    WebElement customerEmailField;

    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//a[text()='Edit']")
    WebElement editButton;

    @FindBy(id = "(//span[text()='Shopping Cart'])[2]")
    WebElement shoppingCartField;

    @FindAll(
            @FindBy(xpath = "//table[@id='customer_cart_grid1_table']//tbody")
    )
    WebElement verifyShoppingCartViewed;

    public void viewShoppingCartForCustomers(){
        salesDashboardPage.clickOnManageCustomersLink();
        functionClass.waitUntilElementPresent(customerEmailField);
        customerEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","loginEmail"));
        functionClass.waitUntilElementPresent(searchButton);

    }




}
