package Pages.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},

        plugin = {"html:target//cucumber-reports.html"} //bu kod raporlama için var
        //plugin = {"html:target\\cucumber-reports.html"}  olursada çalışır
)
public class _06_TestRunnerRegressionWithPlugin extends AbstractTestNGCucumberTests {


}
