package Pages.Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature"},   //buraya feature filesın path i verilecek
        glue = {"StepDefinitions"}        //stepdefinitions ın klasörü yazılacak

)
public class _01_TestRunner extends AbstractTestNGCucumberTests {//burada mutlaka extends olmalı



}
