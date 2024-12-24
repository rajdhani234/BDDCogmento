package RunnerTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/java/Features" }, 
        glue = "StepDefination", 
        dryRun = false, 
        monochrome = true, 
        plugin = {
            "html:target/cucumber-reports/cucumber.html", 
            "json:target/cucumber-reports/cucumber.json", 
            "junit:target/cucumber-reports/cucumber.xml",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class TestRunner {

}
