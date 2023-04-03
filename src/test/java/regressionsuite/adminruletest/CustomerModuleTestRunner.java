package regressionsuite.adminruletest;

import com.magentoapplication.utility.TestBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CustomerModuleTestRunner extends TestBase {

    @BeforeClass
    public void setUp(){
        setupBrowserBackEnd();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
