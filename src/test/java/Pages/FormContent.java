package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {


    public FormContent() {

        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Academic Period'])[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "//span[contains(text(),' 2021-2022 ')]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "//span[text()='Grade Level']")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[3]")
    private WebElement gradeLevel2;


    WebElement myElement;


    public void findAndClick(String strElement) {

        //burada string isimden webelemente ulaşacağız

        switch (strElement) {

            case "academicPeriod":
                myElement = academicPeriod;
                break;
            case "academicPeriod1":
                myElement = academicPeriod1;
                break;
            case "gradeLevel":
                myElement = gradeLevel;
                break;
            case "gradeLevel2":
                myElement = gradeLevel2;
                break;


        }

        clickFunction(myElement);
    }


}

/*


         //YUKARIDAKİ ELEMENETLER ÇALIŞMAZSA BUNLARI DENE

@FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;
 */