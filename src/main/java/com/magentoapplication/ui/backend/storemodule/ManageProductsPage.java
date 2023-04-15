package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    WebElement description1;
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
    @FindBy(css = "a[title='Prices']")
    WebElement PriceLink;
    @FindBy(xpath="//input[@id='price']")
    WebElement Price;
    @FindBy(id="tax_class_id")
    WebElement TaxClass;
    @FindBy(xpath="//span[contains(text(),'The product has been saved.')]")
    WebElement addProductsuccesMessage;
    @FindBy(id="product_info_tabs_categories")
    WebElement categories;
    @FindBy(id="ext-gen353")
    WebElement husby;

    @FindBy(id="ext-gen439")
    WebElement changedCategory;


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


    public void addProductsFunction(){
         storeModuleDashboardPage.catalogLink.click();
         storeModuleDashboardPage.clickOnManageProductsLink();
         AddProductButton.click();

    }

    public void addproduct () {
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
        functionClass.waitUntilElementPresent(description1);
        description1.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(short_description);
        short_description.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(sku);
        sku.sendKeys(functionClass.generateFakeName()+System.currentTimeMillis());
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
        Actions actions=new Actions(driver);
        actions.moveToElement(PriceLink).build().perform();
        PriceLink.click();
        //javascriptClick(PriceLink.click();
        //driver.switchTo().PriceLink.click();
        functionClass.sleep(2);
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

    public void editProduct(){
        storeModuleDashboardPage.clickOnCategoriesLink();
        storeModuleDashboardPage.clickOnManageProductsLink();
        WebElement editButton=driver.findElement (By.xpath(String.format("//tr//td[contains(text(),'%s')]//following-sibling::td//a",
                TestHelperClassStore.getCategoryProductName())));
        functionClass.waitUntilElementPresent(editButton);
        editButton.click();
        functionClass.waitUntilElementPresent(name);
        name.clear();
        TestHelperClassStore.setChangedProductName(functionClass.generateProductName());
        name.sendKeys(TestHelperClassStore.getChangedProductName());
        functionClass.waitUntilElementPresent(description1);
        description1.clear();
        description1.sendKeys(functionClass.generateProductDescription());
        functionClass.waitUntilElementPresent(short_description);
        short_description.clear();
        short_description.sendKeys(functionClass.generateProductDescription());
        functionClass.waitUntilElementPresent(sku);
        sku.clear();
        sku.sendKeys(functionClass.generateProductSku());
        functionClass.waitUntilElementPresent(Weight);
        Weight.clear();
        Weight.sendKeys(functionClass.generateProductWeight());
        functionClass.waitUntilElementPresent(url_key);
        url_key.sendKeys(functionClass.generateFakeRedirectURL());

        functionClass.waitUntilElementPresent(PriceLink);
        Actions actions=new Actions(driver);
        actions.moveToElement(PriceLink).build().perform();
        PriceLink.click();
        functionClass.waitUntilElementPresent(Price);
        Price.clear();
        Price.sendKeys(functionClass.generateProductPrice());

        functionClass.waitUntilElementPresent(SaveButton);
        SaveButton.click();
    }
    public boolean verifyEditProduct(){
        functionClass.waitUntilElementPresent(addProductsuccesMessage);
        if(addProductsuccesMessage.isDisplayed()){
            return true;
        }
        else return false;
    }


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







