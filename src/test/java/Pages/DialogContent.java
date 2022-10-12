package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogContent extends Parent { //parentın methodlarını kullanabilmek için extend yapılmalı

    public DialogContent() {

        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginbutton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;


    @FindBy(xpath = "//*[contains(text(),'already exists')]")
    private WebElement alreadyExist;


    @FindBy(css = "button[aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        //burada string isimden webelemente ulaşacağız yukarıda private yaptık burada onlara methodla ulaşacağız

        switch (strElement) {

            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":
                myElement = nameInput;
                break;
            case "codeInput":
                myElement = codeInput;
                break;
            case "shortName":
                myElement = shortName;
                break;
            case "searchInput":
                myElement = searchInput;
                break;
            case "integrationCode":
                myElement = integrationCode;
                break;
            case "priorityCode":
                myElement = priorityCode;
                break;
        }

        sendKeysFunction(myElement, value);

    }

    public void findAndClick(String strElement) {

        //burada string isimden webelemente ulaşacağız

        switch (strElement) {
            case "acceptCookies":
                myElement = acceptCookies;
                break;
            case "loginbutton":
                myElement = loginbutton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "closeDialog":
                myElement = closeDialog;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "deleteDialogButton":
                myElement = deleteDialogButton;
                break;


        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {


        //burada string isimden webelemente ulaşacağız

        switch (strElement) {
            case "dashboard":
                myElement = dashboard;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
            case "alreadyExist":
                myElement = alreadyExist;
                break;
        }

        verifyContainsText(myElement, text);

    }

    public void searchAndDelete(String searchText) {

        findAndSend("searchInput", searchText);// aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton");// arama butonuna bas

        waitUntilLoading();
        // WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));

        findAndClick("deleteButton");// silme butonua bas
        findAndClick("deleteDialogButton");// dilogdaki silme butonuna bas


    }


}
