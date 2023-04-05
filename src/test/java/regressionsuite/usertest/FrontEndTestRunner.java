package regressionsuite.usertest;

import com.magentoapplication.usermodule.CreateAnAccountPage;
import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.usermodule.MyDashboardPage;
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

    MyDashboardPage myDashboardPage;
    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
        myDashboardPage=new MyDashboardPage(driver);
    }

    @Test
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar",priority =1 )
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();

    }

    @Test
    public void changePasswordTest(){
        createAnAccountPage.fillAccountRegistrationForm();
        //frontEndLoginPage.login();
        myDashboardPage.changePassword();
        myDashboardPage.verifyPasswordChanged();
    }
   @Test
   public void myTagsLink(){
        frontEndLoginPage.login();
        myDashboardPage.myTagsLink();
        myDashboardPage.verifyMyTags();
   }
    @Test
    public void clickNewsletterSubscriptionLink(){
        newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

