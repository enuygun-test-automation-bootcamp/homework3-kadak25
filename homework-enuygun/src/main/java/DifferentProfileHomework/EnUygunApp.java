package DifferentProfileHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

import static DifferentProfileHomework.Constants.Constants.*;

public class EnUygunApp {

    WebDriver driver;

    public EnUygunApp() {
        try {
            //Chrome driver kurulumunu burada yaptık
            Path resourceDirectory = Paths.get("homework-enuygun", "src", "main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //1. Ödev olan farklı profil ile açma kısmını burada ChromeOptions ile "user-data-dir" ile profilin pathini vererek
            // yapıyoruz.
            options.addArguments("user-data-dir=C:\\Users\\KADAK\\AppData\\Local\\Google\\Chrome\\User Data\\enuygundeneme");
            options.addArguments("start-maximized");
            WebDriver driver = new ChromeDriver(options);
            this.driver = driver;
        } catch (IllegalStateException e) {
            System.out.println("Driver kurulumunda bir sorun oluştu" + e);
        }

    }

    public void goHomePage() {
        driver.get(base_Url);
    }


}
