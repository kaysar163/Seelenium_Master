package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.reportingmodule.CustomersPage;
import com.magentoapplication.ui.backend.reportingmodule.ReviewsPage;
import com.magentoapplication.ui.backend.reportingmodule.SalesPage;
import com.magentoapplication.ui.backend.reportingmodule.TagsPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReportingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;
    SalesPage salesPage;

    CustomersPage customersPage;

    TagsPage tagsPage;
    ReviewsPage reviewsPage;

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
    @After("@ReportingModuleTest")
    public void tearDown(){
        closeBrowser();
    }
}
