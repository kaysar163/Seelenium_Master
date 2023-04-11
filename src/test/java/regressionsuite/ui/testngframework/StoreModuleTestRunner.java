package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.storemodule.StoreModuleDashboardPage;
import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.security.auth.spi.LoginModule;

public class StoreModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;


    @BeforeClass
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.storeModuleLogin();
    }




    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
