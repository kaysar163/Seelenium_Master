package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.AllReviewsPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;
    AllReviewsPage allReviewsPage;


    @Before()
    public void setUp() {
        setupBrowserBackEnd();
        backEndLogin.marketingModuleLogin();

    }

    @Given("Admin user is already in the dashboard page")
    public void adminUserIsAlreadyInTheDashboardPage() {
    }

    @When("the user fills out Newsletter template information")
    public void theUserFillsOutNewsletterTemplateInformation() {
    }

    @Then("A new template should be added")
    public void aNewTemplateShouldBeAdded() {
    }

    @After()
    public void tearDown() {
        closeBrowser();
    }

   // @Given(": Admin user is already in the dashboard page")
   // public void adminUserIsAlreadyInTheDashboardPage() {

   // }

    @When(":User view all reviews")
    public void userViewAllReviews() {
        allReviewsPage.viewAllReviewsFunction();

    }

    @Then(":All reviews should be viewed")
    public void allReviewsShouldBeViewed() {
        allReviewsPage.verifyViewAllReviewsFunction();
    }
}
