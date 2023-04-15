package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {
    WebDriver driver;

    FunctionClass functionClass;

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }


    //Elements Muyesser add product




    //Elements Muyesser edit product




   //Elements Fazilet delete product
    @FindBy(xpath ="//span[text()='Catalog']" )
    WebElement catalogLink;

    @FindBy(xpath ="//span[text()='Manage Products']")
    WebElement manageProductsLink;

    @FindBy(id ="productGrid_product_filter_name" )
    WebElement nameField;

    @FindBy(xpath ="//span[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath ="//a[text()=\"Edit\"][1]")
    WebElement editIcon;

    @FindBy(xpath ="//span[text()='Delete']" )
    WebElement deleteButton;

    @FindBy(xpath ="//span[text()='The product has been deleted.']")
    WebElement deleteSuccessfulMessage;




    //Elements Muyesser add method


    //Elements Muyesser edit method


    public void deleteProductTest(){
      functionClass.waitUntilElementPresent(catalogLink);
        Actions actions=new Actions(driver);
        actions.moveToElement(catalogLink).click(manageProductsLink).build().perform();
        nameField.sendKeys(TestHelperClassStore.getChangedProductName());
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(editIcon);
        editIcon.click();
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(deleteButton);
        deleteButton.click();
        functionClass.waitForAlertPresent();
        functionClass.sleep(2);
        Alert alert=driver.switchTo().alert();
        alert.accept();


    }


     public boolean verifyDeletedProductTest(){
        if (deleteSuccessfulMessage.getText().equals("The product has been deleted."))
            return true;
        else
            return false;
     }
}
