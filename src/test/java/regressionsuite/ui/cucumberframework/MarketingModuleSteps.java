package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.NewsletterSubscriptionPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MarketingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;
    NewsletterSubscriptionPage newsletterSubscriptionPage;

    @Before()
    public void setUp(){
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
    public void tearDown(){
        closeBrowser();
    }

    @Given("Admin user is already on the dashboard page")
    public void adminUserIsAlreadyOnTheDashboardPage() {
        
    }

    @When("the user enter the Newsletter subscribers page")
    public void theUserEnterTheNewsletterSubscribersPage() {
        newsletterSubscriptionPage.viewNewsLetterSubscribers();
    }

    @Then("Newsletter subscribers should be viewed.")
    public void newsletterSubscribersShouldBeViewed() {
       // newsletterSubscriptionPage.verifyViewNewsletterSubscribers();
        Assert.assertTrue(newsletterSubscriptionPage.verifyViewNewsletterSubscribers());
    }
}
