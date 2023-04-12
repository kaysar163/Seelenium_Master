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
    @FindBy(name = "search_query")
    WebElement searchQuery1;

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
    @FindBy(xpath = "(//span[normalize-space()='You saved the search term.'])[1]")

    WebElement SuccessfulSavesMessage;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;



    @FindBy(xpath = "//button[@title=\"Delete Search\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//span[contains(text(),\"The search was deleted.\")]")
    WebElement successfulDeletedSearchMessage;

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
        functionClass.waitUntilElementPresent(SynonymFor);
        TestHelperClassCatalog.setSynonymFor(functionClass.generateFakeName());
        functionClass.sleep(2);
        SynonymFor.sendKeys(TestHelperClassCatalog.getSynonymFor());
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
    public  void deleteExistingSearchTerm(){
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

        WebElement editButton1= driver.findElement(By.xpath(String.format("//tr//td[contains(text(),'%s')]//following-sibling::td//a",TestHelperClassCatalog.getSearchQuery())));

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



}











