package Pages;


import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

            //ortak fonksiyonları buraya tanımlayacağız POM da kullnacağımız DialogContent classı
            //buradan extends yapcak inheritance modeli temiz kod için birde framework oluşması için
public class Parent {


    public void sendKeysFunction(WebElement element, String value) {


        waitUntilVisible(element);//gözükene kadar bekle

        scrollToElement(element);//elemente scroll yap

        //kutucuğu temizle
        element.clear();

        //değeri gönder
        element.sendKeys(value);

    }

    public void waitUntilVisible(WebElement element) {//method yaptık yukarıda çağırdık
        //beklme kısmı
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void scrollToElement(WebElement element) {//method yaptık yukarıda çağırdık

        //kaydırmayı yap
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void clickFunction(WebElement element) {

        waitUntilClickable(element);//tıkanabilir olana kadar bekle
        scrollToElement(element);//elemente kadar scrollyap
        element.click();//click yap

    }

    public void waitUntilClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsText(WebElement element, String text) {

        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

    }

    public void waitUntilLoading() {//bu method bu projeye özel
        WebDriverWait wait = new WebDriverWait(GWD.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }


    public List<WebElement> waitUntilVisibleListAllElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));

        return elementList;
    }


}
