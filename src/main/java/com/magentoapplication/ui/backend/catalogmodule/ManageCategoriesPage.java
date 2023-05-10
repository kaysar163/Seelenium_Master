package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManageCategoriesPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;


    public ManageCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }


    // Elements
//    @FindBy(xpath ="//span[text()='close (0)']//parent::a")
//    WebElement rootCategory;
    @FindBy(xpath = "//span[contains(text(),'Delete Category')]")
    WebElement deleteCategoryButton;
    @FindBy(xpath = "//span[contains(text(),'The category has been deleted.')]")
    WebElement deleteCatSucMessage;
    String config = "testdatafolder/testdata.properties";
    @FindBy(xpath = "(//span[contains(text(),'Add Root Category')])[1]")

    WebElement addRootCategory;

    @FindBy(id = "group_4name")

    WebElement subCatName;

    @FindBy(id="group_4name")
    WebElement rootName;
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
    @FindBy(id = "group_4include_in_menu")
    WebElement IncludeInNavigationMenu;
    @FindBy(xpath = ("//span[contains(text(),'Save Category')]"))
    WebElement savaCategoriesButton;
    @FindBy(xpath= "//span[normalize-space()='The category has been saved.']")
    WebElement successfulSavesMessage;

    // meryem edit
  //  @FindBy(xpath = "//span[text()='Books (6)']//parent::a")
  //  WebElement rootCategoryLink;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategoryButton;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement categorySavedMessage;


//    @FindBy (xpath = "//span[contains(text(),'Dewitt Kirlin (1)')]")
//    WebElement subcat1;

//    @FindBy(xpath = "//*[text()='pc portable (0)']")
//    WebElement subCat;
    @FindBy(xpath = "//*[@class='scalable delete']")
    WebElement deleteCatButton;
    @FindBy(xpath = "//*[text()='The category has been deleted.']")
    WebElement sucCatDeletedMessage;

    //sattar add sub category

    @FindBy(id = "add_subcategory_button")
    WebElement addSubCategoryButton;

    @FindBy(xpath = "//*[text()='Category Products']")
    WebElement categoryProductsLink;

    @FindAll({@FindBy(css="div.tree-holder>div>ul>div>li")})
    List<WebElement> allCategories;

    //Muradil filter products

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProductsLink;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;

    @FindBy(xpath = "//span[text()='Attributes']")
    WebElement attributesLink;

    @FindBy(xpath = "//span[text()='Manage Attributes']")
    WebElement manageAttributesLink;

    @FindBy(xpath = "//span[text()='Search Terms']")
    WebElement searchTerms;

    @FindBy(xpath = "//span[text()='Category Products']")
    WebElement categoryProductsTab;

    @FindBy(xpath = "//input[@id='catalog_category_products_filter_name']")
    WebElement categoryProductsFilterNameField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement categoryProductsSearchButton;



    public void addSubCategory(){
        driver.navigate().refresh();
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionClass.sleep(2);
        WebElement findRootName=driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]//parent::a",TestHelperCatalog.getRootName())));
        functionClass.sleep(2);
        findRootName.click();
        functionClass.waitUntilElementPresent(addSubCategoryButton);
        functionClass.sleep(3);
        Actions actions=new Actions(driver);
        actions.moveToElement(addSubCategoryButton).build().perform();
        addSubCategoryButton.click();
        //functionClass.clickOnJavaScript(addSubCategoryButton);
        functionClass.waitUntilElementPresent(subCatName);
        TestHelperCatalog.setSubName(functionClass.generateFakeName());
        functionClass.sleep(3);
        //subCatName.clear();
        subCatName.sendKeys(TestHelperCatalog.getSubName());
        functionClass.sleep(3);
        Select select=new Select(isActive);
        select.selectByValue("1");
        functionClass.waitUntilElementPresent(description);
        description.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(pagaTitle);
        pagaTitle.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(savaCategoriesButton);
        functionClass.sleep(2);
        savaCategoriesButton.click();
    }

    public boolean verifyAddSubCategory(){
        functionClass.sleep(1);
        functionClass.waitUntilElementPresent(successfulSavesMessage);
        if (successfulSavesMessage.isDisplayed())
            return true;
        return false;
    }

    public  void fillCategoryInformationAndSave() {
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionClass.waitUntilElementPresent(addRootCategory);
        functionClass.clickOnJavaScript(addRootCategory);
        //addRootCategory.click();
        functionClass.waitUntilElementPresent(rootName);
        TestHelperCatalog.setRootName(functionClass.generateFakeName());
        functionClass.sleep(2);
        rootName.sendKeys(TestHelperCatalog.getRootName());
        System.out.println(TestHelperCatalog.getRootName());
        functionClass.waitUntilElementPresent(isActive);
        Select select=new Select(isActive);
        select.selectByValue("1");
        functionClass.waitUntilElementPresent(description);
        description.sendKeys(functionClass.generateCountryName());
        functionClass.waitUntilElementPresent(pagaTitle);
        pagaTitle.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(metaKeywords);
        metaKeywords.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(metaDescription);
        metaDescription.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(IncludeInNavigationMenu);
        Select select1=new Select(IncludeInNavigationMenu);
        select1.selectByValue("0");
        functionClass.waitUntilElementPresent(savaCategoriesButton);
        savaCategoriesButton.click();
    }
    public boolean VerifyAddCatogories(){
        functionClass.waitUntilElementPresent(successfulSavesMessage);
        if (successfulSavesMessage.isDisplayed()) {
            return true;
        } else return false;
    }

    // meryem
    public void editCatogoriesInfo(){
        //catalogDashboardPage. clickOnCatalogLink();
        //catalogDashboardPage.clickOnManageCategoriesLink();
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        WebElement rootCategoryLink=driver.findElement(By.xpath(String.format("//span[text()='%s (0)']//parent::a", TestHelperCatalog.getRootName())));
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(rootCategoryLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", rootCategoryLink);
        rootCategoryLink.click();
        functionClass.waitUntilElementPresent(rootName);
        rootName.clear();
        TestHelperCatalog.setChangeRootName(functionClass.generateFakeName());
        functionClass.sleep(2);
        rootName.sendKeys(TestHelperCatalog.getChangeRootName());
        functionClass.waitUntilElementPresent(saveCategoryButton);
        functionClass.sleep(2);
        saveCategoryButton.click();


    }

    public boolean verifyEditCatogories(){
        functionClass.waitUntilElementPresent(categorySavedMessage);
        if (categorySavedMessage.isDisplayed()) {
            return true;
        } else return false;
    }
    public void deleteRootCat(){
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        //catalogDashboardPage.clickOnCatalogLink();
        //catalogDashboardPage.clickOnManageCategoriesLink();
        WebElement rootCategoryLink=driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]//parent::a", TestHelperCatalog.getChangeRootName())));
        functionClass.waitUntilElementPresent(rootCategoryLink);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", rootCategoryLink);
        functionClass.sleep(1);
        rootCategoryLink.click();
        functionClass.waitUntilElementPresent(deleteCategoryButton);
        deleteCategoryButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public boolean deleteCategorySuccessful(){
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(deleteCatSucMessage);
        if (deleteCatSucMessage.isDisplayed())
            return true;
        else return false;

    }


    public void  editSubCategory()throws Exception{
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionClass.sleep(3);
       // Actions actions=new Actions(driver);
        //actions.moveToElement(subcat1).click().perform();
        WebElement subCat=driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", TestHelperCatalog.getSubName())));
        functionClass.waitUntilElementPresent(subCat);
        Actions actions=new Actions(driver);
        actions.moveToElement(subCat).click().perform();
        subCat.click();
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(description);
        description.clear();
        description.isSelected();
        description.sendKeys("good");
        functionClass.waitUntilElementPresent(savaCategoriesButton);
        savaCategoriesButton.click();

    }

    public  boolean verifyEditSubCategory(){
        functionClass.waitUntilElementPresent(successfulSavesMessage);
        if(successfulSavesMessage.isDisplayed()){
            return true;
        }
        else return false;
    }
    public void subCatDelete(){
//        functionClass.waitUntilElementPresent(catalogDashboardPage.catalogLink);
//        catalogDashboardPage.clickOnCatalogLink();
//        catalogDashboardPage.clickOnManageCategoriesLink();
        functionClass.sleep(10);
        String subCatName= TestHelperCatalog.getSubName();
        WebElement subCat=driver.findElement(By.xpath(String.format("//*[text()='%s (0)']",subCatName)));
        subCat.click();
//        subCat.click();
        functionClass.waitUntilElementPresent(deleteCatButton);
        functionClass.sleep(2);
        deleteCatButton.click();
        functionClass.waitForAlertPresent();
        functionClass.alertAccept();
    }
    public boolean subCatDeleteSuccessful(){
        functionClass.waitUntilElementPresent(sucCatDeletedMessage);
        if(sucCatDeletedMessage.isDisplayed())
            return true;
        else return false;
    }

    public boolean viewCategoryProducts(){
        catalogDashboardPage.clickOnCatalogLink();
        catalogDashboardPage.clickOnManageCategoriesLink();
        if (allCategories.size()>=1)
            return true;
        else return false;
    }

    public void filterProductsInTheCategoryProductsTab(){
        functionClass.waitUntilElementPresent(catalogLink);
        functionClass.sleep(2);
        catalogLink.click();
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        functionClass.waitUntilElementPresent(categoryProductsTab);
        functionClass.sleep(3);
        categoryProductsTab.click();
        functionClass.waitUntilElementPresent(categoryProductsFilterNameField);
        categoryProductsFilterNameField.sendKeys("kaysar");
        functionClass.waitUntilElementPresent(categoryProductsSearchButton);
        categoryProductsSearchButton.click();
    }

    public boolean verifyFilterProductsInTheCategoryProductsTab(){
        if (driver.getPageSource().contains("kaysar")) {
            return true;
        } else {
            return false;
        }
    }

}
