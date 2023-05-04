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
    ShoppingCartPage shoppingCartPage;

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
        shoppingCartPage= new ShoppingCartPage(driver);
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

    @When("Reporting manager views low stock page")
    public void reportingManagerViewsLowStockPage() {
        productsPage.seeLowStockReport();

    }

    @Then("Reporting manager should see low stock reports")
    public void reportingManagerShouldSeeLowStockReports() {
        productsPage.verifySeeLowStockReport();
    }

    @When("reporting manager opens the Sales Coupons Report")
    public void reportingManagerOpensTheSalesCouponsReport() {
        salesPage.salesCouponsUsageReport();
    }

    @Then("Coupons Usage should be displayed")
    public void couponsUsageShouldBeDisplayed() {
        Assert.assertTrue(salesPage.verifyCouponsUsageReport());
    }



    @When("Reporting Manager view most viewed page between time period {string} and{string}")
    public void reportingManagerViewMostViewedPageBetweenTimePeriodAnd(String arg0, String arg1) {
        productsPage.seeMostViewedReport(arg0,arg1);


    }
    @Then("Reporting Manager should see most viewed report")
    public void reportingManagerShouldSeeMostViewedReport() {
        productsPage.verifyMostViewedReport();
    }

    @When("Reporting Manager view products {string} and {string}")
    public void reportingManagerViewProductsAnd(String arg0, String arg1) {
        productsPage.viewProductsOrderedReport(arg0,arg1);

    }

    @Then("Reporting Manager should see Ordered Report")
    public void reportingManagerShouldSeeOrderedReport() {
        Assert.assertTrue(productsPage.verifyProductsOrderedReport());
    }



    @When("see Shopping Cart - Abandoned carts Report")
    public void seeShoppingCartAbandonedCartsReport() {
        shoppingCartPage.viewSalesShippedReport();

        
    }

    @Then("verify see Shopping Cart - Abandoned carts Report")
    public void verifySeeShoppingCartAbandonedCartsReport() {
        Assert.assertTrue(shoppingCartPage.verifyViewSalesShippedReportSuccessfully());

    }

    @When("Reporting Manager Navigate to Total Invoiced vs Paid Report page and select period and date {string} {string} and click show Report button")
    public void reportingManagerNavigateToTotalInvoicedVsPaidReportPageAndSelectPeriodAndDateAndClickShowReportButton(String arg0, String arg1) {
        salesPage.TotalInvoicedVsPaidReport(arg0,arg1);
    }

    @Then("Total Invoiced Vs Paid report view successfully")
    public void totalInvoicedVsPaidReportViewSuccessfully() {
        salesPage.verifyTotalInvoicedVsPaidReport();
    }

    @When("reporting manager fills out report date for the shipped  {string} and{string}")
    public void reportingManagerFillsOutReportDateForTheShippedAnd(String arg0, String arg1) {
        salesPage.salesTotalShippedReport(arg0,arg1);
    }

    @Then("Total Shipped Report view successfully")
    public void totalShippedReportViewSuccessfully() {
        salesPage.verifyTotalShippedReport();
    }

    @When("Reporting Manager view bestsellers page between time period {string} and{string}")
    public void reportingManagerViewBestsellersPageBetweenTimePeriodAnd(String arg0, String arg1) {
        productsPage.viewProductBestsellerReport(arg0,arg1);

    }

    @Then("Reporting manager should see bestsellers report")
    public void reportingManagerShouldSeeBestsellersReport() {
        productsPage.verifyProductBestsellerReport();
    }


    @When("Reporting manager should be see customers")
    public void reportingManagerShouldBeSeeCustomers() {customersPage.seeNewAccounts();
    }

    @Then("Reporting manager should be able to see new accounts")
    public void reportingManagerShouldBeAbleToSeeNewAccounts() {customersPage.verifySeeNewCustomers();
    }
    @After("@ReportingModuleTest")
    public void tearDown(){
        closeBrowser();
    }


}

