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

    @FindBy(id = "store_id")

    WebElement Store;
    @FindBy(id = "synonym_for")

    WebElement SynonymFor;
    @FindBy(id = "redirect")

    WebElement RedirectURL;
    @FindBy(id = "display_in_terms")

    WebElement DisplayinSuggestedTerms;
    @FindBy(xpath = "(//span[contains(text(),'Save Search')])[1]")

    WebElement SaveSearch;
   // @FindBy(xpath = "(//span[normalize-space()='You saved the search term.'])[1]")

    @FindBy(xpath = "//span[text()='Search']")

    WebElement searchButton;

    @FindBy(xpath = "//input[@name='search_query']")

    WebElement searchQuery1;

    WebElement SuccessfulSavesMessage;
    public void NewSearchInfo(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        functionClass.waitUntilElementPresent(AddNewSearchTerm);
        AddNewSearchTerm.click();
        functionClass.waitUntilElementPresent(SearchQuery);
        SearchQuery.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(Store);
        Select select=new Select(Store);
        select.selectByValue("28");
        functionClass.waitUntilElementPresent(SynonymFor);
        SynonymFor.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent( RedirectURL);
        RedirectURL.sendKeys(functionClass.generateFakeRedirectURL());
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

    public void SeachEditTest(){
        functionClass.sleep(1);
        functionClass.waitUntilElementPresent(SynonymFor);
        SynonymFor.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent( RedirectURL);
        RedirectURL.sendKeys(functionClass.generateFakeRedirectURL());
        functionClass.waitUntilElementPresent(DisplayinSuggestedTerms);
        Select select1=new Select(DisplayinSuggestedTerms);
        select1.selectByValue("0");
        functionClass.waitUntilElementPresent(SaveSearch);
        SaveSearch.click();
    }


    public boolean VerifyEditNewSerach() {
        functionClass.waitUntilElementPresent( SuccessfulSavesMessage );
        if (SuccessfulSavesMessage.isDisplayed( )) {

            return true;
        } else
            return false;

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


}





   }







