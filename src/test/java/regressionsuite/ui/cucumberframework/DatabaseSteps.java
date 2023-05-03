package regressionsuite.ui.cucumberframework;

import com.magentoapplication.backend.database.ConnectionType;
import com.magentoapplication.backend.database.DataAccess;
import com.magentoapplication.backend.database.DatabaseConnection;
import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.CatalogDashboardPage;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;

public class DatabaseSteps extends TestBase {

    Connection connection;

    String config="config.properties";
    BackEndLogin backEndLogin;
    CatalogDashboardPage catalogDashboardPage;
    FunctionClass functionClass;


    String dbUrl= ApplicationConfig.readFromConfigProperties(config,"dbIp");
    String dbPort= (ApplicationConfig.readFromConfigProperties(config,"dbPort"));
    String dbUserName= ApplicationConfig.readFromConfigProperties(config,"dbUserName");
    String dbPassword= ApplicationConfig.readFromConfigProperties(config,"dbPassword");
    String dbDefault= ApplicationConfig.readFromConfigProperties(config,"dbDefault");




    @Before("@DatabaseTest")
    public void setUp(){
        connection= DatabaseConnection.connection(dbUrl,dbPort,dbDefault,dbUserName,dbPassword, ConnectionType.MYSQL);
    }

    @After("@DatabaseTest")
    public void tearDown(){
        DatabaseConnection.closeDataBaseConnection(connection);
    }

    @Given("connection is already established")
    public void connectionIsAlreadyEstablished() {
      backEndLogin=new BackEndLogin(driver);
      catalogDashboardPage=new CatalogDashboardPage(driver);
      functionClass=new FunctionClass(driver);

    }

    @When("a new user registers to the system")
    public void aNewUserRegistersToTheSystem() {

    }

    @Then("the user should be in the database")
    public void theUserShouldBeInTheDatabase() {

    }

    @When("a new user add product root category")
    public void aNewUserAddProductRootCategory() {
        backEndLogin.catalogModuleLogin();
        catalogDashboardPage.clickOnManageCategoriesLink();


        
    }

    @Then("added new product root category should be in the database")
    public void addedNewProductRootCategoryShouldBeInTheDatabase() {

    }
}
