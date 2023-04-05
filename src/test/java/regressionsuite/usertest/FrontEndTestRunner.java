package regressionsuite.usertest;

import com.magentoapplication.usermodule.CreateAnAccountPage;
import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.usermodule.NewsletterSubscriptionPage;
import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class FrontEndTestRunner extends TestBase{
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;
    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
    }

    @Test
    public void login() {

        frontEndLoginPage.login();
    }
    @Test
    public void CreateAnAccount(){

      createAnAccountPage.fillAccountRegistrationForm();
      createAnAccountPage.verifyCreateAnAccountSuccessful();


}
    @Test
    public void clickNewsletterSubscriptionLink(){
        frontEndLoginPage.login();
        newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
