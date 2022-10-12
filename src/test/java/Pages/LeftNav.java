package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setup;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement Countries;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement addcitizen;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement enteranceExam;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement Setup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement EnteranceExam;

    @FindBy(xpath = "(//span[text()='States'])")
    private WebElement States;
    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {

            case "setup":
                myElement = setup;
                break;
            case "parameters":
                myElement = parameters;
                break;
            case "Countries":
                myElement = Countries;
                break;
            case "Citizenship":
                myElement = addcitizen;
                break;
            case "nationalities":
                myElement = nationalities;
                break;
            case "fees":
                myElement = fees;
                break;
            case "enteranceExam":
                myElement = enteranceExam;
                break;
            case "Setup":
                myElement = Setup;
                break;
            case "EnteranceExam":
                myElement = EnteranceExam;
                break;
            case "States":
                myElement = States;
                break;
        }
        clickFunction(myElement);

    }


}
