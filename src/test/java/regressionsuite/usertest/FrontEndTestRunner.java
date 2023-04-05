package regressionsuite.usertest;

import com.magentoapplication.usermodule.CheckOutOrderPage;
import com.magentoapplication.usermodule.CreateAnAccountPage;
import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class FrontEndTestRunner extends TestBase {
    FrontEndLoginPage frontEndLoginPage;
    CheckOutOrderPage checkOutOrderPage;

    CreateAnAccountPage createAnAccountPage;

    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        checkOutOrderPage = new CheckOutOrderPage(driver);
    }



    @Test
    public void login() {

        frontEndLoginPage.login();
    }

    @Test
    public void CreateAnAccount() {

        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();


    }
    @Test
    public void checkOrderPge() {
        frontEndLoginPage.login();
        checkOutOrderPage.CheckOutOrderPage();
        Assert.assertTrue(checkOutOrderPage.verifyCheckOutOrder());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

