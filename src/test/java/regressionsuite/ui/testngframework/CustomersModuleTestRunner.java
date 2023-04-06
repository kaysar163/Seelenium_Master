package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.customersmodule.CustomersManagerPage;
import com.magentoapplication.utility.TestBase;
import org.apache.commons.collections4.sequence.EditScript;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomersModuleTestRunner extends TestBase {
    @BeforeClass
    public void setUp() {

    }

    @Test(description= "kaysar", priority = 1)
    public void ManageraddnewcusstomerTest(){
        CustomersManagerPage.addCustomerMethod();
        CustomersManagerPage. verifyCustomer();
}
    @AfterClass
    public void tearDown(){

    }
}
