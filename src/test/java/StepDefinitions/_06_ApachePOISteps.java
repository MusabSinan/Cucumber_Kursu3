package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _06_ApachePOISteps {

    DialogContent dc = new DialogContent();

    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        for (ArrayList<String> satir : tablo) {

            dc.findAndClick("addButton");
            dc.findAndSend("nameInput", satir.get(0));
            dc.findAndSend("shortName", satir.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage", "success");
        }

    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 1);
                                                                             //ilk satırın ilk sütununu göndereceğimiz için 1 sütun aldık burada
        for (ArrayList<String> satir : tablo) {

            dc.searchAndDelete(satir.get(0));
            dc.findAndContainsText("successMessage", "success");

        }

    }
}
