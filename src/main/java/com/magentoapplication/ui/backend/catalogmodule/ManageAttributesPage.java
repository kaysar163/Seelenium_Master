package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
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

    static final String config="testdatafolder/testdata.properties";

    String attribute=ApplicationConfig.readFromConfigProperties(config, "attributeCode")+ System.currentTimeMillis();
    String input=ApplicationConfig.readFromConfigProperties(config,"adminInput")+System.currentTimeMillis();
    String productName=ApplicationConfig.readFromConfigProperties(config,"productName");
    @FindBy(id = "productGrid_product_filter_name")
    WebElement productNameField;
    @FindBy(xpath = "//button//span[contains(text(),'Search')]")
    WebElement searchButton;
//    @FindBy(xpath = "//tr//td[contains(text(),'1795')]//following-sibling::td//a[contains(text(),'Edit')]")
//    WebElement editProduct;
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
    
    //adds attribute under a catalog
    public void addAttributeUnderCatalog() {
        functionClass.waitUntilElementPresent(catalogDashboardPage.catalogLink);
        catalogDashboardPage.catalogLink.click();
        functionClass.waitUntilElementPresent(catalogDashboardPage.manageProductsLink);
        catalogDashboardPage.manageProductsLink.click();
        functionClass.waitUntilElementPresent(productNameField);
        productNameField.clear();
        productNameField.sendKeys(productName);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        functionClass.sleep(2);
        WebElement editProduct=driver.findElement(By.xpath(String.format
                ("(//tr//td[contains(text(),'%s')]//following-sibling::td//a[contains(text(),'Edit')])[1]"
                        ,productName)));
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
               attributeCodeField.sendKeys(attribute);
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
        inputAdmin.sendKeys(input);
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(btnSaveAttribute);
        btnSaveAttribute.click();
    }
    
    public boolean attributeSaveMessage() {
        functionClass.sleep(2);
        if (saveAttributeMessage.isDisplayed()) {
            System.out.println("A new attribute under a catalog was successfully created.");
            driver.switchTo().defaultContent();
            return true;
        } else
            return false;
    }
    
}
