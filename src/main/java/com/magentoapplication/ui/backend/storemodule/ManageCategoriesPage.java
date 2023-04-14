package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageCategoriesPage {
    WebDriver driver;

    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;
    ManageProductsPage manageProductsPage;

    @FindBy(css = "ul#nav>li:nth-child(2)")
    WebElement catalogLink;
    @FindBy(xpath="//span[text()=\"Manage Categories\"]")
    WebElement manageCategoriesLink;
    //Elements
    @FindBy(id = "group_4name")
    WebElement categoryNameField;

    @FindBy( id="group_4is_active")
    WebElement isActive;

    @FindBy(id = "group_4description")

    WebElement description;
    @FindBy(id = "group_4meta_title")

    WebElement pagaTitle;
    @FindBy(id = "group_4meta_keywords")
    WebElement metaKeywords;
    @FindBy(id = "group_4meta_description")
    WebElement metaDescription;

    @FindBy(id="group_4include_in_menu")
    WebElement navigationMenu;

    @FindBy(xpath= "//a[@title='Category Products']")
    WebElement categoryProductLink;

    @FindBy(id="catalog_category_products_filter_name")
    WebElement categoryProductsFilterNameField;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//span[text()=\"Save Category\"]")
    WebElement saveCategoryButton;

    @FindBy(xpath = "//span[text()=\"The category has been saved.\"]")
    WebElement successMessage;

    public ManageCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        manageProductsPage=new ManageProductsPage(driver);
    }
    public void addProductCategoriesFunction(){
        // functionClass.waitUntilElementPresent(storeModuleDashboardPage.catalogLink);
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(categoryNameField);
        //TestHelperClassStore.setCategoryProductName(functionClass.generateProductName());
        categoryNameField.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(isActive);
        Select select=new Select(isActive);
        select.selectByValue("1");
        functionClass.waitUntilElementPresent(description);
        description.sendKeys(functionClass.generateCatalogDescription());
        functionClass.waitUntilElementPresent(pagaTitle);
        pagaTitle.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(metaKeywords);
        metaKeywords.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(metaDescription);
        metaDescription.sendKeys(functionClass.generateProductDescription());
        functionClass.waitUntilElementPresent(navigationMenu);
        Select select1=new Select(navigationMenu);
        select1.selectByValue("1");
        functionClass.sleep(3);
        Actions actions=new Actions(driver);
        actions.moveToElement(categoryProductLink).build().perform();
        functionClass.waitUntilElementPresent(categoryProductLink);
        categoryProductLink.click();
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(categoryProductsFilterNameField);
        //functionClass.sleep(3);
        //TestHelperClassStore.setCategoryProductName(functionClass.generateFakeName());
        categoryProductsFilterNameField.sendKeys(TestHelperClassStore.getCategoryProductName());
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        WebElement checkBoxButton=driver.findElement(By.xpath(String.format("//tr//td[contains(text(),'%s')]//preceding-sibling::td/input[@type='checkbox']",
                TestHelperClassStore.getCategoryProductName())));
        checkBoxButton.isSelected();
        functionClass.waitUntilElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }
    public boolean verifyAddProductCategory(){
        functionClass.waitUntilElementPresent(successMessage);
        if(successMessage.isDisplayed()){
            return true;
        }
        else return false;

    }
}




    //Methods

