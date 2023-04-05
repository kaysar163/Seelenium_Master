package regressionsuite.usertest;

import com.magentoapplication.usermodule.CreateAnAccountPage;
import com.magentoapplication.usermodule.EditAccountInformation;
import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.usermodule.MyDashboardPage;
import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class FrontEndTestRunner extends TestBase {
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;

    EditAccountInformation editAccountInformation;

    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
    }

    @Test
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar", priority = 1)
    public void CreateAnAccount() {
        createAnAccountPage.fillAccountRegistrationForm();
        // createAnAccountPage.verifyCreateAnAccountSuccessful();


    }

    @Test(description = "User should be able to edit account information")
    public void editAccountInfo() {

        editAccountInformation = new EditAccountInformation(driver);
        editAccountInformation.EditAccountInfo();
        editAccountInformation.VerifySuccessfullyEdit();


    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

