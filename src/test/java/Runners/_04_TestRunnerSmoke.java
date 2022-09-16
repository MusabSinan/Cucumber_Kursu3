package Pages.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        tags = "@SmokeTest", //hangi senaryolarda bu  tag varsa onları çalıştırır
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}

)
public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}