package ObjectandClassMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;

import static ObjectandClassMethod.ObjectConstants.*;


public class ObjectApp {

    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    WebDriverWait wait;

    public ObjectApp() {
        //driver kurulumlarını burada gerçekleştiriyoruz
        try {
            Path resourceDirectory = Paths.get("homework-enuygun", "src", "main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            WebDriver chromeDriver = new ChromeDriver(options);
            this.chromeDriver = chromeDriver;
            System.out.println("Launching Chrome Browser");
        } catch (IllegalStateException e) {
            System.out.println("There was a problem installing the driver" + e);
        }
        try {
            Path resourceDirectory = Paths.get("homework-enuygun", "src", "main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.setProperty("webdriver.gecko.driver", absolutePath + "/binary/geckodriver.exe");
            WebDriver firefoxDriver = new FirefoxDriver();
            this.firefoxDriver = firefoxDriver;
            System.out.println("Launching Firefox Browser");
        } catch (IllegalStateException e) {
            System.out.println("There was a problem installing the driver" + e);
        }

    }


    //metotlarımızı ve doğrulama işlemlerimizi yapıyoruz
    public void goHomePage() {
        try {
            chromeDriver.get(base_Url);
            firefoxDriver.get(base_Url);
            String firefoxCurrentUrl = firefoxDriver.getCurrentUrl();
            String chromeCurrentUrl = chromeDriver.getCurrentUrl();
            if (chromeCurrentUrl.equals(base_Url))
                if (firefoxCurrentUrl.equals(base_Url)) {
                    System.out.println("All browsers went to base url");
                }

        } catch (Exception e) {

            System.out.println("There was a problem navigating to the url");
        }

    }

    public void moveToLogInPage() {
        chromeDriver.findElement(loginButtonLocator).click();
        firefoxDriver.findElement(loginButtonLocator).click();
    }

    public void moveToRegisterPage() {
        chromeDriver.findElement(registerButtonLocator).click();
        firefoxDriver.findElement(registerButtonLocator).click();
    }
}
