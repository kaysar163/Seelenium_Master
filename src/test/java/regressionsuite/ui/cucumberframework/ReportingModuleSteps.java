package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.reportingmodule.*;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class ReportingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;
    SalesPage salesPage;

    CustomersPage customersPage;

    TagsPage tagsPage;
    ReviewsPage reviewsPage;
    Actions actions;
    ProductsPage productsPage;

    @Before("@ReportingModuleTest")
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.reportingModuleLogin();

    }

    @Given("Admin user is already in the dashboard page reporting")
    public void adminUserIsAlreadyInTheDashboardPageReporting() {
        salesPage=new SalesPage(driver);
        customersPage=new CustomersPage(driver);
        tagsPage=new TagsPage(driver);
        reviewsPage=new ReviewsPage(driver);
        actions=new Actions(driver);
        productsPage=new ProductsPage(driver);
    }

    @When("the user views tags for customers report")
    public void theUserViewsTagsForCustomersReport() {
        tagsPage.viewTagsForCustomers();
    }

    @Then("the user sees customers tags")
    public void theUserSeesCustomersTags() {
        Assert.assertTrue(tagsPage.verifyTagsViewedForCustomers());
    }


    @When("the user views the customers by number of orders report")
    public void theUserViewsTheCustomersByNumberOfOrdersReport() {
        customersPage.viewCustomersByNumberOfReports();
    }

    @Then("the user sees customers by number of orders report")
    public void theUserSeesCustomersByNumberOfOrdersReport() {
        Assert.assertTrue(customersPage.verifyViewsCustomersReport());
    }
    @When("Reporting manager clicks on popular button under tags button")
    public void reportingManagerClicksOnPopularButtonUnderTagsButton() {
        tagsPage.clickOnPopularTags();
    }

    @Then("Reporting manager should view popular tags on popular tags page")
    public void reportingManagerShouldViewPopularTagsOnPopularTagsPage() {
        Assert.assertTrue(tagsPage.verifyThatPopularTagsDisplayed());
    }
    @When("Reporting manager click on show reviews button on product reviews page")
    public void reportingManagerClickOnShowReviewsButtonOnProductReviewsPage() {
        reviewsPage.clickProductReviews();
    }

    @Then("reporting manager should be able to view all product reviews")
    public void reportingManagerShouldBeAbleToViewAllProductReviews() {
        Assert.assertTrue(reviewsPage.verifyThatAllReviewsShown());
    }
    @When("reporting manager fills out report date {string} and{string}")
    public void reportingManagerFillsOutReportDateAnd(String arg0, String arg1) {
        salesPage.viewTotalOrderedReport(arg0,arg1);

    }
    @Then("total ordered report should display")
    public void totalOrderedReportShouldDisplay() {
        Assert.assertTrue(salesPage.verifyOrderedReport());
    }

    @When("reporting manager opens the Sales Total Refunded Report and fills out report data {string} and{string}")
    public void reportingManagerOpensTheSalesTotalRefundedReportAndFillsOutReportDataAnd(String arg0, String arg1) {
        salesPage.salesTotalRefundedReport(arg0,arg1);
    }

    @Then("Total Refunded should be displayed")
    public void totalRefundedShouldBeDisplayed() {
        Assert.assertTrue(salesPage.verifyRefundedReport());
    }


    @When("Reporting manager views downloads page")
    public void reportingManagerViewsDownloadsPage() {
        productsPage.seeProductsDownloadReport();


    }

    @Then("Reporting manager should see downloaded reports")
    public void reportingManagerShouldSeeDownloadedReports() {
        productsPage.verifySeeProductsDownloadReport();
    }
    @After("@ReportingModuleTest")
    public void tearDown(){
        closeBrowser();
    }
}
