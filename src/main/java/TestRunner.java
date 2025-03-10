import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "stepDefinitions", plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
monochrome = true)
public class TestRunner {
	// No code needed here. This class is used as an entry point for running tests.
}
