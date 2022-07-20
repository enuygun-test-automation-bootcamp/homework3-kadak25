package HashMapMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import static HashMapMethod.HashMapConstants.*;


public class  HashMapDrivers {


    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    HashMap<String, WebDriver> driverHashMap() {

        HashMap<String, WebDriver> hashMap = new HashMap<String, WebDriver>();
        hashMap.put("chrome", this.chromeDriver);
        hashMap.put("firefox", this.firefoxDriver);
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

        return hashMap;

    }


    public void goHomePage() {
        chromeDriver.get(base_Url);
        firefoxDriver.get(base_Url);
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
