package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.customersmodule.CustomerInformationPage;
import com.magentoapplication.ui.backend.customersmodule.CustomersManagerPage;
import com.magentoapplication.ui.backend.customersmodule.EditCustomerGroupPage;
import com.magentoapplication.utility.TestBase;
import org.apache.commons.collections4.sequence.EditScript;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CustomersModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;
    EditCustomerGroupPage editCustomerGroupPage;
    CustomersManagerPage customersManagerPage;
    CustomerInformationPage customerInformationPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.customersModuleLogin();
        customersManagerPage = new CustomersManagerPage(driver);
        customerInformationPage=new CustomerInformationPage(driver);
        editCustomerGroupPage=new EditCustomerGroupPage(driver);
        context.setAttribute("driver", driver);
    }


    @Test(enabled = false)
    public void a() {
//        customersManagerPage.assignGroupToCustomer();
//        Assert.assertTrue(customersManagerPage.verifyUpdate());
    }

    @Test(description= "kaysar", priority = 1)
    public void ManageraddnewcusstomerTest(){
        customerInformationPage.addCustomerMethod();
        Assert.assertTrue(customerInformationPage.verifyCustomer());

}
    @Test(description= "omercan", priority = 3,enabled = false)
    public void emailFilterTest() {
        customersManagerPage.FilterCustomersByEmail();
    }

    @Test(description = "Filter the Customer By Group Test-Rizvangul", priority = 4,enabled = false)
    public void FilterTheCustomerByGroupTest(){
        customersManagerPage.filterTheCustomerByGroup();
        Assert.assertTrue(customersManagerPage.verifyFilterTheCustomerByGroup());
    }
    
    @Test(description = "Irshad", priority = 11,enabled = false)
    public void deleteCustomerTest(){
        customersManagerPage.deleteCustomer();
        Assert.assertTrue(customersManagerPage.verifyDeleteCustomer());
    }
    @Test(description = "meryem", priority = 14,enabled = false)
    public void editCustomerGroup() {
        editCustomerGroupPage.editCustomerGroupInfo();
        Assert.assertTrue(editCustomerGroupPage.verifyCustomerGroupEditedTest());

    }
    @Test(description = "meryem", priority = 15,enabled = false)
    public void deleteCustomerGroup() {
        editCustomerGroupPage.deleteCustomerGroupInfo();
        Assert.assertTrue(editCustomerGroupPage.verifyCustomerGroupDeletedTest1());
    }
    @Test(description = "Memet")
    public void passwordResetTest(){
        customerInformationPage.customerPasswordChange();
        Assert.assertTrue(customerInformationPage.passwordSuccessfullyChanged());
    }

        @AfterClass
    public void tearDown(){
        closeBrowser();
    }


}
