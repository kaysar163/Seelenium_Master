package regressionsuite.ui.cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-Marketing-Module-testReport.html","json:target/cucumber.json"},
        features = {"classpath:features/reporting.feature"}
//        tags ="@seeCustomersByNumberOfOrdersReport "
)
public class CucumberTestRunner {

}
