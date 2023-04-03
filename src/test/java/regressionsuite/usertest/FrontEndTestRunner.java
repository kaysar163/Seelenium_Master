package regressionsuite.usertest;

import com.magentoapplication.usermodule.FrontEndLoginPage;
import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrontEndTestRunner extends TestBase {
    FrontEndLoginPage frontEndLoginPage;
    @BeforeClass
    public void setUp(){
        setupBrowserFrontEnd();
        frontEndLoginPage=new FrontEndLoginPage(driver);
    }

    @Test
    public void login(){
        frontEndLoginPage.login();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
