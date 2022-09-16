package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();

    DialogContent dc = new DialogContent();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setup");
        ln.findAndClick("parameters");
        ln.findAndClick("Countries");


    }

    @When("Create a country")
    public void createACountry() {

        String randomGenName= RandomStringUtils.randomAlphabetic(8);  //random kelime üretecek 8 karakterli
        String randomGenCode= RandomStringUtils.randomNumeric(4); //random 4 haneli sayı verecek

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", randomGenName);
        dc.findAndSend("codeInput", randomGenCode);
        dc.findAndClick("saveButton");


    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {


        dc.findAndContainsText("successMessage", "success");

    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {


        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("saveButton");

    }
}
