package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductsPage {
    WebDriver driver;

    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        storeModuleDashboardPage=new StoreModuleDashboardPage(driver);
    }

    @FindBy(xpath = "(//span[contains(text(),'Add Product')])[1]")
    WebElement AddProductButton;
    @FindBy(id ="attribute_set_id")
    WebElement AttributeSetDropDown;
    @FindBy(id ="product_type")
    WebElement ProductTypeDropDown;
    @FindBy(id="continue_button")
    WebElement ContinueButton;
    @FindBy(name="product[name]")
    WebElement name;
    @FindBy(id="description")
    WebElement description;
    @FindBy(id="short_description")
    WebElement short_description;
    @FindBy(id="sku")
    WebElement sku;
    @FindBy(id="weight")
    WebElement Weight;
    @FindBy(id="news_from_date")
    WebElement SetProductasNewfromDate;
    @FindBy(id="status")
    WebElement statusDropDown;
    @FindBy(id="url_key")
    WebElement url_key;
    @FindBy(id="visibility")
    WebElement visibilityDropDown;
    @FindBy(xpath="(//span[contains(text(),'Save')])[1]")
    WebElement SaveButton;
    @FindBy(id="product_info_tabs_group_8")
    WebElement PriceLink;
    @FindBy(id="price")
    WebElement Price;
    @FindBy(id="tax_class_id")
    WebElement TaxClass;
    @FindBy(xpath="//*[contains(text(),'The product has been saved.')]")
    WebElement addProductsuccesMessage;
    @FindBy(id="product_info_tabs_categories")
    WebElement categories;
    @FindBy(id="ext-gen353")
    WebElement husby;


    public void addproductcategories () {
       storeModuleDashboardPage.clickOnCategoriesLink();
        storeModuleDashboardPage.clickOnManageProductsLink();
        functionClass.waitUntilElementPresent(AddProductButton);
        AddProductButton.click();
        functionClass.waitUntilElementPresent(AttributeSetDropDown);
        Select select = new Select(AttributeSetDropDown);
        select.selectByValue("4");
        functionClass.waitUntilElementPresent(ProductTypeDropDown);
        Select select1 = new Select(ProductTypeDropDown);
        select1.selectByValue("simple");
        functionClass.waitUntilElementPresent(ContinueButton);
        ContinueButton.click();
        functionClass.waitUntilElementPresent(name);
        TestHelperClassStore.setCategoryProductName(functionClass.generateProductName());
        name.sendKeys(TestHelperClassStore.getCategoryProductName());
        functionClass.waitUntilElementPresent(description);
        description.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(short_description);
        short_description.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(sku);
        sku.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(Weight);
        Weight.sendKeys(functionClass.generateProductWeight());
        functionClass.waitUntilElementPresent(SetProductasNewfromDate);
        SetProductasNewfromDate.sendKeys(functionClass.currentDate());
        functionClass.waitUntilElementPresent(statusDropDown);
        Select select2 = new Select(statusDropDown);
        select2.selectByValue("1");
        functionClass.waitUntilElementPresent(url_key);
        url_key.sendKeys(functionClass.generateFakeRedirectURL());
        functionClass.waitUntilElementPresent(visibilityDropDown);
        Select select3 = new Select(visibilityDropDown);
        select3.selectByValue("4");
        functionClass.waitUntilElementPresent(PriceLink);
        PriceLink.click();
        functionClass.waitUntilElementPresent(Price);
        Price.sendKeys(functionClass.generateProductPrice());
        functionClass.waitUntilElementPresent(TaxClass);
        Select select4 = new Select(TaxClass);
        select4.selectByValue("4");
        functionClass.waitUntilElementPresent(categories);
        categories.click();
        functionClass.waitUntilElementPresent(husby);
        husby.isSelected();
        functionClass.waitUntilElementPresent(SaveButton);
        SaveButton.click();
    }
    public  boolean VerifySuccessmessage(){
        functionClass.waitUntilElementPresent(addProductsuccesMessage);
        if (addProductsuccesMessage.isDisplayed()){
            return true;
        }
        else return false;
    }


}




