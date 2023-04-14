package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchTermsPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public SearchTermsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }

    // Elements
    @FindBy(xpath = "(//span[contains(text(),'Add New Search Term')])[1]")
    WebElement AddNewSearchTerm;
    @FindBy( id= "query_text")
    WebElement SearchQuery;
    @FindBy(xpath = "//input[@name='search_query']")
    WebElement searchQuery1;

    @FindBy(id = "store_id")
    WebElement Store;
    @FindBy(id = "synonym_for")
    WebElement synonymFor;
    @FindBy(id = "redirect")

    WebElement redirectURL;
    @FindBy(id = "display_in_terms")
    WebElement DisplayinSuggestedTerms;
    @FindBy(xpath = "(//span[contains(text(),'Save Search')])[1]")
    WebElement SaveSearch;
    @FindBy(xpath = "(//span[normalize-space()='You saved the search term.'])[1]")
    WebElement SuccessfulSavesMessage;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;



    @FindBy(xpath = "//button[@title='Delete Search']")
    WebElement deleteButton;
    @FindBy(xpath = "//span[contains(text(),'The search was deleted.')]")
    WebElement successfulDeletedSearchMessage;

    @FindBy(xpath = "//span[text()='Search']")

    WebElement SearchButton;

    @FindBy(xpath = "//input[@name='search_query']")

    WebElement SearchQuery1;



    public void NewSearchInfo(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        functionClass.waitUntilElementPresent(AddNewSearchTerm);
        AddNewSearchTerm.click();
        functionClass.waitUntilElementPresent(SearchQuery);
        TestHelperClassCatalog.setSearchQuery(functionClass.generateFakeName());
        functionClass.sleep(3);
        SearchQuery.sendKeys(TestHelperClassCatalog.getSearchQuery());

        functionClass.waitUntilElementPresent(Store);
        Select select=new Select(Store);
        select.selectByValue("28");
        functionClass.waitUntilElementPresent(synonymFor);
        TestHelperClassCatalog.setSynonymFor(functionClass.generateFakeName());
        functionClass.sleep(2);
        synonymFor.sendKeys(TestHelperClassCatalog.getSynonymFor());
        functionClass.waitUntilElementPresent(redirectURL);
        redirectURL.sendKeys(functionClass.generateFakeRedirectURL());
        functionClass.waitUntilElementPresent(DisplayinSuggestedTerms);
        Select select1=new Select(DisplayinSuggestedTerms);
        select1.selectByValue("0");
        functionClass.waitUntilElementPresent(SaveSearch);
        SaveSearch.click();
    }

    public boolean VerifyAddNewSerach(){
        functionClass.waitUntilElementPresent(SuccessfulSavesMessage);
        if(SuccessfulSavesMessage.isDisplayed()){
            return true;
        }else return false;

    }

    public void searchEditTest(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        //functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchQuery1);
        searchQuery1.click();
        // functionClass.sleep(2);
        searchQuery1.sendKeys(TestHelperClassCatalog.getSearchQuery());
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();

        WebElement editButton1= driver.findElement(By.xpath(String.format
                ("//tr//td[contains(text(),'%s')]//following-sibling::td//a",TestHelperClassCatalog.getSearchQuery())));
        System.out.println(editButton1);
        functionClass.waitUntilElementPresent(editButton1);
        editButton1.click();
        functionClass.waitUntilElementPresent(redirectURL);
        redirectURL.sendKeys(functionClass.generateFakeRedirectURL());
        functionClass.waitUntilElementPresent(DisplayinSuggestedTerms);
        Select select1=new Select(DisplayinSuggestedTerms);
        select1.selectByValue("1");
        functionClass.waitUntilElementPresent(SaveSearch);
        SaveSearch.click();
    }


    public boolean verifyEditNewSearch() {
        functionClass.waitUntilElementPresent( SuccessfulSavesMessage );
        if (SuccessfulSavesMessage.isDisplayed( )) {

            return true;
        } else
            return false;

    }


    public  void deleteExistingSearchTerm(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        //functionClass.sleep(2);
//        functionClass.waitUntilElementPresent(searchQuery1);
//        searchQuery1.click();
//       // functionClass.sleep(2);
//        searchQuery1.sendKeys(TestHelperClassCatalog.getSearchQuery());
//        functionClass.sleep(3);
//        functionClass.waitUntilElementPresent(searchButton);
//        searchButton.click();

        WebElement editButton1= driver.findElement(By.xpath(String.format("//tr//td[contains(text(),'%s')]//following-sibling::td//a",TestHelperClassCatalog.getSearchQuery())));
        System.out.println(editButton1);

        editButton1.click();
        functionClass.waitUntilElementPresent(deleteButton);
        deleteButton.click();
        functionClass.alertAccept();




    }
    public boolean verifyDeleteSearchFunction(){

        if (successfulDeletedSearchMessage.isDisplayed()){
            return true;
        }
        else return false;
    }


    public void  filterExistingSearchTermTest(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        //functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchQuery1);
        searchQuery1.click();
        // functionClass.sleep(2);
        searchQuery1.sendKeys(TestHelperClassCatalog.getSearchQuery());
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
    }

    public boolean verifyFilterTermTest(){
        if (driver.getPageSource().contains(TestHelperClassCatalog.getSearchQuery())) {
            return true;
        } else
            return false;



}}











