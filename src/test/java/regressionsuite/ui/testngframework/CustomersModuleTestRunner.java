package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.utility.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class CustomersModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    @BeforeClass
    public void setUp(ITestContext context){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.customersModuleLogin();
    }



    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
