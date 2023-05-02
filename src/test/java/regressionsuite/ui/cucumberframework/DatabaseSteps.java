package regressionsuite.ui.cucumberframework;

import com.magentoapplication.backend.database.ConnectionType;
import com.magentoapplication.backend.database.DatabaseConnection;
import com.magentoapplication.utility.ApplicationConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;

public class DatabaseSteps {

    Connection connection;

    String config="config.properties";



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
    }

    @When("a new user registers to the system")
    public void aNewUserRegistersToTheSystem() {
    }

    @Then("the user should be in the database")
    public void theUserShouldBeInTheDatabase() {
    }

    @When("a new user add product root category")
    public void aNewUserAddProductRootCategory() {
        
    }

    @Then("added new product root category should be in the database")
    public void addedNewProductRootCategoryShouldBeInTheDatabase() {
    }
}
