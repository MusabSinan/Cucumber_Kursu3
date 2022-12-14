package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {


    @Before //testNG deki before metodları gibi çalışır
    public void before() {

        System.out.println("Senaryo başladı..");

    }


    @After
    public void after(Scenario scenario) {//scenario türünden bir parameetre yolladık
        System.out.println("Senaryo Bitti");
        System.out.println("scenario sonucu=" + scenario.getStatus());
        System.out.println("scenario isFailed ?=" + scenario.isFailed());



        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        //excele sonuçları yazacağız
        ExcelUtility.writeExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx",
                scenario, GWD.threadBrowserName.get(), date.format(formatter));

        // ekran görüntüsü al senaryo hatalı ise
        if (scenario.isFailed()) {
            // klasöre
            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            //ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("target/FailedScreenShots/" + scenario.getId() + date.format(formatter) + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // ekran görüntüsü al senaryo hatalı ise
        GWD.quitDriver();
    }

    public String getBase64Screenshot() {
        return ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
