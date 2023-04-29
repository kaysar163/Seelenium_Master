package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsletterTemplatePage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;

    public NewsletterTemplatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }

    @FindBy(xpath = "(//span[text()='Add New Template'])[1]")
    WebElement addNewTemplateButton;

    @FindBy(id = "code")
    WebElement templateNameField;

    @FindBy(id = "subject")
    WebElement templateSubjectField;

    @FindBy(id = "template_styles")
    WebElement templateStyles;

    @FindBy(xpath = "//button[@title='Save Template']")
    WebElement saveTemplateButton;

    @FindBy(xpath = "//input[@name='code']")
    WebElement templateSearchField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath ="//tr[@class='even pointer'] ")
    WebElement newsLetterTemplateRow;

    @FindBy(xpath ="//td[@class='empty-text a-center']" )
    WebElement searchResult;

    @FindBy(xpath = "//span[text()='Delete Template']" )
    WebElement deleteTemplateButton;

    @FindAll(@FindBy(xpath =  "//div[@class=\"grid\"]"))
    List<WebElement> newsLetterTemplatesTable;



    public void addNewNewsletterTemplate(){
        marketingDashboardPage.clickOnNewsletterTemplateLink();
        functionClass.waitUntilElementPresent(addNewTemplateButton);
        addNewTemplateButton.click();
        functionClass.waitUntilElementPresent(templateNameField);
        TestHelperMarketing.setTemplateName(functionClass.generateTemplate());
        templateNameField.sendKeys(TestHelperMarketing.getTemplateName());
        functionClass.waitUntilElementPresent(templateSubjectField);
        templateSubjectField.sendKeys(functionClass.generateWebsiteName());
        functionClass.waitUntilElementPresent(templateStyles);
        templateStyles.sendKeys(functionClass.generateProductName());
        functionClass.waitUntilElementPresent(saveTemplateButton);
        saveTemplateButton.click();
    }

    public boolean verifyNewTemplateAdded(){
        functionClass.waitUntilElementPresent(templateSearchField);
        templateSearchField.sendKeys(TestHelperMarketing.getTemplateName());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
       if (driver.getPageSource().contains(TestHelperMarketing.getTemplateName()))
           return true;
       else return false;

    }

    public void editNewNewsletterTemplate(){
        marketingDashboardPage.clickOnNewsletterTemplateLink();
        functionClass.waitUntilElementPresent(templateSearchField);
        templateSearchField.sendKeys(TestHelperMarketing.getTemplateName());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        WebElement editButton=driver.findElement(By.xpath(String.format
                ("//td[contains(text(),' %s ')]",TestHelperMarketing.getTemplateName())));
        functionClass.waitUntilElementPresent(editButton);
        editButton.click();
        functionClass.waitUntilElementPresent(templateNameField);
        TestHelperMarketing.setChangeTemplateName(functionClass.generateTemplate());
        templateNameField.clear();
        templateNameField.sendKeys(TestHelperMarketing.getChangeTemplateName());
        functionClass.waitUntilElementPresent(templateSubjectField);
        templateSubjectField.clear();
        templateSubjectField.sendKeys(functionClass.generateWebsiteName());
        functionClass.waitUntilElementPresent(templateStyles);
        templateStyles.clear();
        templateStyles.sendKeys(functionClass.generateProductName());
        functionClass.waitUntilElementPresent(saveTemplateButton);
        saveTemplateButton.click();
    }

    public boolean verifyTemplateEdited(){
        functionClass.waitUntilElementPresent(templateSearchField);
        templateSearchField.sendKeys(TestHelperMarketing.getChangeTemplateName());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        if (driver.getPageSource().contains(TestHelperMarketing.getChangeTemplateName()))
            return true;
        else return false;

    }


    public void deleteAnExistingNewsletterTemplate(){
        marketingDashboardPage.clickOnNewsletterTemplateLink();
        functionClass.waitUntilElementPresent(templateSearchField);
        templateSearchField.sendKeys(TestHelperMarketing.getChangeTemplateName());
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        functionClass.sleep(2);
        WebElement editButton=driver.findElement(By.xpath(String.format
                ("//td[contains(text(),' %s ')]",TestHelperMarketing.getChangeTemplateName())));
        functionClass.waitUntilElementPresent(editButton);
        editButton.click();
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(deleteTemplateButton);
        deleteTemplateButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }

   public boolean verifyNewsletterTemplateDeleted() {
        functionClass.waitUntilElementPresent(templateSearchField);
        templateSearchField.sendKeys(TestHelperMarketing.getChangeTemplateName());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
       if (newsLetterTemplatesTable.size()>=1)
           return true;
       else
           return false;
   }
}
