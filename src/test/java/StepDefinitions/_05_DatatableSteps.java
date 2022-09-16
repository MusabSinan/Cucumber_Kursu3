package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DatatableSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    FormContent fc=new FormContent();
    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {

        List<String> ListElements=elements.asList(String.class);

        for (int i = 0; i < ListElements.size(); i++) {

            ln.findAndClick(ListElements.get(i));

        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {

        List<String> ListElements=elements.asList(String.class);

        for (int i = 0; i < ListElements.size(); i++) {

            dc.findAndClick(ListElements.get(i));

        }
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {

        List<List<String>> ListElements=elements.asLists(String.class);

        for (int i = 0; i < ListElements.size(); i++) {

            dc.findAndSend(ListElements.get(i).get(0),ListElements.get(i).get(1));
            // listin ilk elemanına(weblement adı), ikinci elemanı yani değeri gönder
        }

    }


    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for(int i=0;i<listElement.size();i++) {
            //   System.out.println("listElement = " + listElement.get(i));
            dc.searchAndDelete(listElement.get(i));
        }
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {

        List<String> ListElements=elements.asList(String.class);

        for (int i = 0; i < ListElements.size(); i++) {

            fc.findAndClick(ListElements.get(i));

        }
    }
}
