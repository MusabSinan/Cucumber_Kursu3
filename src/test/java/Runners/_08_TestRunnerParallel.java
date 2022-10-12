package Runners;


import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}
        //plugin = {"html:target//cucumber-reports.html"}//bu basit rapor için tanımlanan plug in

)
public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser){
      //burada browserı set edeccek

        GWD.threadBrowserName.set(browser);//bu threade browsername set edildi



    }

}
