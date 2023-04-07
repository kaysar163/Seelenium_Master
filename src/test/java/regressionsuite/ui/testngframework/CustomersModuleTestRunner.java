package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.customersmodule.CustomerManagerExportCustomers;
import com.magentoapplication.ui.backend.customersmodule.CustomersManagerPage;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CustomersModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    CustomersManagerPage customersManagerPage;
    CustomerManagerExportCustomers customerManagerExportCustomers;

    @BeforeClass
    public void setUp(ITestContext context){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.customersModuleLogin();
        customersManagerPage=new CustomersManagerPage(driver);
        context.setAttribute("driver",driver);
        customerManagerExportCustomers=new CustomerManagerExportCustomers(driver);
    }

    //@Test()
    //public void a(){
//        customersManagerPage.assignGroupToCustomer();
//        Assert.assertTrue(customersManagerPage.verifyUpdate());
    //}

    @Test()
    public void exportCustomerTest(){

        customerManagerExportCustomers.exportCustomers();
        Assert.assertTrue(customerManagerExportCustomers.verifyExportCustomer());


    }

    @AfterClass
    public void tearDown(){

        closeBrowser();
    }
}
