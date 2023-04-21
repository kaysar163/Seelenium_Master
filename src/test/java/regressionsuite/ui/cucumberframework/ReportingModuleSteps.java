package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.reportingmodule.CustomersPage;
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

    CustomersPage customersPage;

    TagsPage tagsPage;

    @Before("@ReportingModuleTest")
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.reportingModuleLogin();

    }

    @Given("Admin user is already in the dashboard page reporting")
    public void adminUserIsAlreadyInTheDashboardPageReporting() {
        customersPage=new CustomersPage(driver);
        tagsPage=new TagsPage(driver);
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

    @After("@ReportingModuleTest")
    public void tearDown(){
        //closeBrowser();
    }

}
