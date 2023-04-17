package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.NewsletterTemplatePage;
import com.magentoapplication.ui.backend.marketingmodule.PendingReviewsPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;

    NewsletterTemplatePage newsletterTemplatePage;
    PendingReviewsPage pendingReviewsPage;

    @Before()
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();
        pendingReviewsPage=new PendingReviewsPage(driver);

    }

    @Given("Admin user is already in the dashboard page")
    public void adminUserIsAlreadyInTheDashboardPage() {
        //newsletterTemplatePage=new NewsletterTemplatePage(driver);
        pendingReviewsPage=new PendingReviewsPage(driver);
    }

    @When("the user fills out Newsletter template information")
    public void theUserFillsOutNewsletterTemplateInformation() {
        newsletterTemplatePage.addNewNewsletterTemplate();
    }

    @Then("A new template should be added")
    public void aNewTemplateShouldBeAdded() {
        newsletterTemplatePage.verifyNewTemplateAdded();
    }


    @When("the user edits newsletter template information")
    public void theUserEditsNewsletterTemplateInformation() {
        newsletterTemplatePage.editNewNewsletterTemplate();
    }

    @Then("the newsletter template should be edited")
    public void theNewsletterTemplateShouldBeEdited() {
        newsletterTemplatePage.verifyTemplateEdited();
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
