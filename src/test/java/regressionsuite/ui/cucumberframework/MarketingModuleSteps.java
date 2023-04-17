package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.PendingReviewsPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MarketingModuleSteps extends TestBase {
     WebDriver driver;
    BackEndLogin backEndLogin;
    PendingReviewsPage pendingReviewsPage;

   // @Before()
    //public void setUp(){
        //setupBrowserBackEnd();
        //backEndLogin.marketingModuleLogin();

    //}

    //@Given("Admin user is already in the dashboard page")
    //public void adminUserIsAlreadyInTheDashboardPage() {
    //}

    @When("the user fills out Newsletter template information")
    public void theUserFillsOutNewsletterTemplateInformation() {
    }

    @Then("A new template should be added")
    public void aNewTemplateShouldBeAdded() {
    }



    @Given("Admin user is already in the dashboard page")
    public void adminUserIsAlreadyInTheDashboardPage() {
        setupBrowserBackEnd();
        backEndLogin =new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();
        pendingReviewsPage=new PendingReviewsPage(driver);

    }


    @When("user update pending reviews")
    public void userUpdatePendingReviews() {
        pendingReviewsPage.managerUpdatePendingReviews();

    }

    @Then("pending reviews should be updated")
    public void pendingReviewsShouldBeUpdated() {
        pendingReviewsPage.verifyUpdatePendingReviews();
    }

    @After()
    public void tearDown(){
        closeBrowser();
    }


}
