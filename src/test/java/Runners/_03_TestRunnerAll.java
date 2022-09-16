package Pages.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


        features = {"src/test/java/FeatureFiles/" },//FeatureFiles dosyasındaki bütün senaryoları çalıştırdı yani bütün testleri
        glue = {"StepDefinitions"}

)

public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {

}