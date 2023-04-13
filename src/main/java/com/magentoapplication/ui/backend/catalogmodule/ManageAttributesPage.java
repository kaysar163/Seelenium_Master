package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ManageAttributesPage {
    
    WebDriver driver;
    
    FunctionClass functionClass;
    
    CatalogDashboardPage catalogDashboardPage;
    
    @FindBy(id = "productGrid_product_filter_name")
    WebElement productName;
    @FindBy(xpath = "//button//span[contains(text(),'Search')]")
    WebElement searchButton;
    @FindBy(xpath = "//tr//td[contains(text(),'1795')]//following-sibling::td//a[contains(text(),'Edit')]")
    WebElement editProduct;
    @FindBy(xpath = "(//span[contains(text(),'Create New Attribute')])[1]")
    WebElement createNewAttribute;
    @FindBy(xpath = "//tbody[1]//tr[1]//td[2]//input[@id='attribute_code']")
    WebElement attributeCodeField;
    @FindBy(id = "is_global")
    WebElement scopeDropdown;
    @FindBy(xpath = "//*[@onchange='toggleApplyVisibility(this)']")
    WebElement applyToDropdown;
    @FindBy(xpath = "//select[@id='apply_to']")
    WebElement applyToSecond;
    @FindBy(id = "product_attribute_tabs_labels")
    WebElement manageLabelOrOptions;
    @FindBy(name = "frontend_label[0]")
    WebElement inputAdmin;
    @FindBy(xpath = "(//*[contains(text(),'Save Attribute')])[1]")
    WebElement btnSaveAttribute;
    @FindBy(xpath = "//span[contains(text(),'The product attribute has been saved.')]")
    WebElement saveAttributeMessage;
    
    public ManageAttributesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        catalogDashboardPage = new CatalogDashboardPage(driver);
    }
    //adds a new attribute
//    public void addNewAttribute(){
//        functionClass.waitUntilElementPresent(addAttributeButton);
//        addAttributeButton.click();
//        functionClass.waitUntilElementPresent(attributeCodeField);
//        attributeCodeField.sendKeys("cowboyhatcattleman");
//        Select dropdown1 = new Select(scopeDropdown);
//        dropdown1.selectByValue("1");
//        Select dropdown2 = new Select(applyToDropdown);
//        dropdown2.selectByValue("1");
//        Select dropdown3 = new Select(applyToSecond);
//        dropdown3.selectByValue("simple");
//        functionClass.waitUntilElementPresent(manageLabelOrOptions);
//        manageLabelOrOptions.click();
//        functionClass.waitUntilElementPresent(inputAdmin);
//        inputAdmin.sendKeys("TexanCowboy");
//        functionClass.waitUntilElementPresent(buttonSaveAttribute);
//        buttonSaveAttribute.click();
//    }
    
    //adds attribute under a catalog
    public void addAttributeUnderCatalog() {
        functionClass.waitUntilElementPresent(productName);
        productName.sendKeys("cattleman");
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        functionClass.waitUntilElementPresent(editProduct);
        editProduct.click();
        functionClass.waitUntilElementPresent(createNewAttribute);
        createNewAttribute.click();
        String currentWindow = driver.getWindowHandle();
        System.out.println("Main window name is: " + currentWindow);
        Set<String> allWindows = driver.getWindowHandles();
        for(String eachWindow:allWindows){
            if(!eachWindow.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(eachWindow);
                driver.manage().window().maximize();
               attributeCodeField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties", "attributeCode")+ System.currentTimeMillis());
            }
        }
//        functionClass.waitUntilElementPresent(attributeCodeField);
//        attributeCodeField.sendKeys(functionClass.generateFakeName());
        Select dropdown1 = new Select(scopeDropdown);
        dropdown1.selectByValue("1");
        Select dropdown2 = new Select(applyToDropdown);
        dropdown2.selectByValue("1");
        Select dropdown3 = new Select(applyToSecond);
        dropdown3.selectByValue("simple");
        functionClass.waitUntilElementPresent(manageLabelOrOptions);
        manageLabelOrOptions.click();
        functionClass.waitUntilElementPresent(inputAdmin);
        inputAdmin.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","adminInput")+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        functionClass.waitUntilElementPresent(btnSaveAttribute);
        btnSaveAttribute.click();
    }
    
    public boolean attributeSaveMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (saveAttributeMessage.isDisplayed()) {
            System.out.println("A new attribute under a catalog was successfully created.");
            return true;
        } else
            return false;
    }
    
}
