package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {
    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {

        ArrayList<ArrayList<String>> dbList = DBUtility.getListData(query);
        System.out.println(dbList);

        DialogContent dc = new DialogContent();
        List<WebElement> uiList = dc.waitUntilVisibleListAllElement(dc.nameList);

        for (int i = 0; i < dbList.size(); i++) {

            Assert.assertEquals("Hatalı Durum",dbList.get(i).get(1),uiList.get(i).getText());

        }


    }
}
