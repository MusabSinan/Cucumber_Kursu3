package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverInfo;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {


    public static WebDriver driver;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();  //driver üretecek
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {

        //Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
        // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
        // çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
        // demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
        //donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç

        // threadDriver.get() -> ilgili tread deki driveri verecek
        // threadDriver.set(driver) -> ilgili thread e driver set ediliyor.

        Locale.setDefault(new Locale("EN"));//bu dil problemini kaldırdı runners classddaki 07 file ındaki rapor türü için
        System.setProperty("user.language", "EN");     //bu burada olmalı kesinlikle olmalı SparkReport dosyasına bak

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null)
            threadBrowserName.set("chrome");//parallel çalışmayan yani XML den parametreyle gelmeyenler için geri çağıran basic arayanlar için


        if (threadDriver.get() == null) {

            String browserName = threadBrowserName.get();//bu threaddeki browsername i verdi

            switch (browserName) {

                case "chrome":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox":
                    //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    threadDriver.set(new OperaDriver());
                    break;

            }


        }
        return threadDriver.get();
    }


    public static void quitDriver() {

        Bekle(3);

        if (threadDriver.get() != null) {//driver varsa
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();

            driver = null;

            threadDriver.set(driver);

        }
    }

    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
