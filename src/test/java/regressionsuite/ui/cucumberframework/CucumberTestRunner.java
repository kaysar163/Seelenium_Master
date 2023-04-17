package regressionsuite.ui.cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-product-ui-testReport.html","json:target/cucumber.json"},
        features = {"classpath:features,src/test/resources/features/marketing.feature"},
        tags="@cucumberTestRunner"
)
public class CucumberTestRunner {

}
