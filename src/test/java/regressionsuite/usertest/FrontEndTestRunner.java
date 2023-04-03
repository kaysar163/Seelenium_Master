package regressionsuite.usertest;

import com.magentoapplication.utility.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FrontEndTestRunner extends TestBase {

    @BeforeClass
    public void setUp(){
        setupBrowserFrontEnd();
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
