package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TagsPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;

    public TagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }

    @FindAll(
            @FindBy(xpath = "//table[@id='customers_grid_table']//tbody//tr")
    )
    List<WebElement> verifyTagsViewedForCustomers;

    @FindBy(xpath = "//a[text()='Show Tags']")
    WebElement showTagsLink;
    @FindBy(xpath = "//*[text()='Popular']")
    WebElement popularButton;
    @FindAll({@FindBy(xpath = "//div[@class=\"grid\"]//tbody/tr")})
    List<WebElement> popularTags;



    public void viewTagsForCustomers(){
        functionClass.waitUntilElementPresent(showTagsLink);
        showTagsLink.click();
    }

    public boolean verifyTagsViewedForCustomers(){
        return verifyTagsViewedForCustomers.size()>=1;
    }
    public void clickOnPopularTags(){
        reportingDashboardPage.clickOnPopularLink();
        functionClass.waitUntilElementPresent(popularButton);
        popularButton.click();
    }
    public boolean verifyThatPopularTagsDisplayed(){
        if(popularTags.size()>=1)
            return true;
        else return false;
    }

}


