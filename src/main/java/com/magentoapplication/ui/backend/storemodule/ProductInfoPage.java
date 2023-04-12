package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductInfoPage {
    WebDriver driver;

    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;


    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        storeModuleDashboardPage=new StoreModuleDashboardPage(driver);
    }
    //Elements
    @FindBy(css = "ul#product_info_tabs>li:nth-child(11)")
    WebElement categoriesLink;
    @FindBy(css = "button.scalable.save[title='Save']")
    WebElement saveButton;
    @FindBy(css = "ul#nav>li:nth-child(2)")
    WebElement catalogLink;
    @FindBy(xpath = "(//*[text()='Manage Products'])[1]")
    WebElement manageProductsLink;
    @FindBy(css = "li.success-msg")
    WebElement categoryUpdateSuccessMessage;
    public void updateProductCategories(){
        storeModuleDashboardPage.clickOnManageProductsLink();
//        WebElement productEditButton= driver.findElement(By.xpath(String.format("//tbody/tr/td[3][contains(text(),'%')]/following::td[9]",TestHelperClassStore.getProductName())));
//        productEditButton.click();
//        WebElement editButton=driver.findElement(By.xpath("//tbody/tr/td[3][contains(text(),'East of Eden')]/following::td[9]"));
//        functionClass.sleep(10);
//        editButton.click();
        WebElement editButton = driver.findElement(By.xpath("//tbody/tr/td[3][contains(text(),'East of Eden')]/following::td[9]/a"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", editButton);

        functionClass.sleep(10);
        categoriesLink.click();
//        WebElement categoryCheckBox=driver.findElement(By.xpath("//*[text()='Sweden (4)']//../../input"));
//        categoryCheckBox.click();
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for a maximum of 10 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Sweden (4)']//../../input"))).click();

        saveButton.click();
    }
    public boolean productCategoryUpdatedSuccessfully(){
        functionClass.waitUntilElementPresent(categoryUpdateSuccessMessage);
        if(categoryUpdateSuccessMessage.isDisplayed())
            return true;
        else return false;
        }


}