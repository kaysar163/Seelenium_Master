package regressionsuite.usertest;

import com.magentoapplication.usermodule.CreateAnAccountPage;
import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class FrontEndTestRunner extends TestBase{
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;
    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
    }

    @Test
    public void login() {

        frontEndLoginPage.login();
    }
    @Test(description = "kaysar",priority =1 )
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
       // createAnAccountPage.verifyCreateAnAccountSuccessful();


}
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

