package Runners;


import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
)
public class _08_TestRunnerParallel_MasterReport extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) // bazı java versiyon hataları için
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        GWD.threadBrowserName.set(browser);
        //burada browser set edilecek
        // bu threade browsername set edildi.
    }


}

