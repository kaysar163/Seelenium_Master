package com.magentoapplication.ui.backend.catalogmodule;

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

    CatalogDashboardPage catalogDashboardPage;

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        catalogDashboardPage = new CatalogDashboardPage(driver);
    }

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProductsLink;
    @FindBy(xpath = "//span[text()=\"Add Product\"]")
    WebElement addProductButton;
    @FindBy(xpath = "//select[@id=\"attribute_set_id\"]")
    WebElement attributeSetDropdown;
    @FindBy(xpath = "//select[@id=\"product_type\"]")
    WebElement productTypeDropdown;
    @FindBy(xpath = "//span[text()=\"Continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement productName;
    @FindBy(xpath = "//textarea[@id=\"description\"]")
    WebElement productDescription;
    @FindBy(xpath = "//textarea[@id=\"short_description\"]")
    WebElement productShortDescription;
    @FindBy(xpath = "//input[@id=\"sku\"]")
    WebElement productSku;
    @FindBy(xpath = "//input[@id=\"weight\"]")
    WebElement productWeight;
    @FindBy(xpath = "//select[@id=\"status\"]")
    WebElement statusDropdown;
    @FindBy(xpath = "//select[@id=\"visibility\"]")
    WebElement visibilityDropdown;
    @FindBy(xpath = "//span[text()=\"Save\"]")
    WebElement saveButton;

    @FindBy(xpath = "//input[@id=\"price\"]")
    WebElement productPrice;

    @FindBy(xpath = "//select[@id=\"tax_class_id\"]")
    WebElement taxClassDropdown;
    @FindBy(xpath = "//span[text()=\"The product has been saved.\"]")
    WebElement addProductSuccessMassage;

    @FindBy(xpath = "(//a[text()=\"Edit\"])[1]")
    WebElement editIcon;
    @FindBy(xpath = "//span[text()=\"Prices\"]")
    WebElement productPricesPageLink;
    @FindBy(xpath = "//span[text()=\"The product has been saved.\"]")
    WebElement editProductSuccessMassage;

    //Fazilet

    @FindBy(id="productGrid_product_filter_name")
    WebElement nameField;

    @FindBy(xpath="//span[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//span[text()='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//span[text()='The product has been deleted.']")
    WebElement deletesuccessfulmessage;

    public void addProduct() {
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageProductsLink);
        manageProductsLink.click();
        functionClass.waitUntilElementPresent(addProductButton);
        addProductButton.click();

        functionClass.waitUntilElementPresent(attributeSetDropdown);
        attributeSetDropdown.click();
        Select selectAttributeSet = new Select(attributeSetDropdown);
        selectAttributeSet.selectByValue("10");

        functionClass.waitUntilElementPresent(productTypeDropdown);
        productTypeDropdown.click();
        Select selectProductType = new Select(productTypeDropdown);
        selectProductType.selectByValue("simple");

        functionClass.waitUntilElementPresent(continueButton);
        continueButton.click();

        functionClass.waitUntilElementPresent(productName);
        TestHelperCatalog.setProductName(functionClass.generateProductName());
        productName.sendKeys(TestHelperCatalog.getProductName());

        functionClass.waitUntilElementPresent(productDescription);
        productDescription.sendKeys(functionClass.generateProductDescription());
        functionClass.waitUntilElementPresent(productShortDescription);
        productShortDescription.sendKeys(functionClass.generateProductShortDescription());
        functionClass.waitUntilElementPresent(productSku);
        productSku.sendKeys(functionClass.generateProductSku());
        functionClass.waitUntilElementPresent(productWeight);
        productWeight.sendKeys(functionClass.generateProductWeight());

        functionClass.waitUntilElementPresent(statusDropdown);
        statusDropdown.click();
        Select selectStatus = new Select(statusDropdown);
        selectStatus.selectByValue("1");

        functionClass.waitUntilElementPresent(visibilityDropdown);
        visibilityDropdown.click();
        Select selectVisibility = new Select(visibilityDropdown);
        selectVisibility.selectByValue("4");

        functionClass.waitUntilElementPresent(saveButton);
        saveButton.click();
        functionClass.sleep(2);

        functionClass.waitUntilElementPresent(productPrice);
        productPrice.sendKeys(functionClass.generateProductPrice());
        functionClass.waitUntilElementPresent(taxClassDropdown);
        taxClassDropdown.click();
        Select selectTaxClass = new Select(taxClassDropdown);
        selectTaxClass.selectByValue("2");

        functionClass.waitUntilElementPresent(saveButton);
        saveButton.click();

    }

    public boolean verifyAddProduct() {
        functionClass.waitUntilElementPresent(addProductSuccessMassage);
        if (addProductSuccessMassage.isDisplayed())
            return true;
        else return false;

    }

    public void editProduct() {
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageProductsLink);
        manageProductsLink.click();
        WebElement editProductName=driver.findElement (By.xpath(String.format("//tr//td[contains(text(),'%s')]//following-sibling::td//a",
                TestHelperCatalog.getProductName())));
        functionClass.waitUntilElementPresent(editProductName);
        editProductName.click();
        functionClass.waitUntilElementPresent(productName);
        productName.clear();
        TestHelperCatalog.setChangedProductName(functionClass.generateProductName());
        productName.sendKeys(TestHelperCatalog.getChangedProductName());
        functionClass.waitUntilElementPresent(productPricesPageLink);
        productPricesPageLink.click();
        functionClass.waitUntilElementPresent(productPrice);
        productPrice.clear();
        productPrice.sendKeys(functionClass.generateProductPrice());
        functionClass.waitUntilElementPresent(saveButton);
        saveButton.click();

    }

    public boolean verifyEditProduct() {
        functionClass.waitUntilElementPresent(editProductSuccessMassage);
        if (editProductSuccessMassage.isDisplayed())
            return true;
        else return false;

    }


    public void deleteproduct(){

        Actions actions=new Actions(driver);
        actions.moveToElement(catalogDashboardPage.catalogLink).moveToElement(catalogDashboardPage.manageProductsLink).click().build().perform();
        nameField.sendKeys(TestHelperCatalog.getChangedProductName());
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
        Alert alert=driver.switchTo().alert();
        alert.accept();



    }


    public boolean verifydeletedproduct(){
        if (deletesuccessfulmessage.getText().equals("The product has been deleted."))
            return true;
        else
            return false;
    }

}



