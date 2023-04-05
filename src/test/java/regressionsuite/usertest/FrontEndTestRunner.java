package regressionsuite.usertest;

import com.magentoapplication.usermodule.*;
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
    AddProductsToShoppingCart addProductsToShoppingCart;
    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
        myDashboardPage=new MyDashboardPage(driver);
    }

    @Test(priority =1)
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar",priority =2 )
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();

    }
    @Test(description = "muyesser",priority = 3)
    public  void addShoppingCartTest(){
        addProductsToShoppingCart=new AddProductsToShoppingCart(driver);
        addProductsToShoppingCart.addToShoppingCart();
        addProductsToShoppingCart.verification();
    }

    @Test(enabled=false)
    public void changePasswordTest(){
        createAnAccountPage.fillAccountRegistrationForm();
        //frontEndLoginPage.login();
        myDashboardPage.changePassword();
        myDashboardPage.verifyPasswordChanged();
    }

    @Test(enabled=false)
    public void clickNewsletterSubscriptionLink(){
        newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

