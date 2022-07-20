package EnumMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import static EnumMethod.EnumConstants.*;


public class EnumApp {

    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    public EnumApp(Drivers drivers) {
        //switch case yapısı ile driverımızı seçiyoruz ve kurulumunu yapıyoruz
        switch (drivers) {
            case CHROME:
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

                break;
            case FIREFOX:
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


                break;
            default: {
                //Daha fazla driver olmadığı için default kısmına seçilen bir driverı atıyoruz ben chrome driver'ı atadım
                try {
                    Path resourceDirectory = Paths.get("src", "main", "resources");
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


            }


        }
    }

    //Her driver için ayrıca method oluşturup işlemleri yaptırıyoruz ve main sınıfımızda çağırıyoruz
    public void goHomePageChrome() {
        chromeDriver.get(base_Url);
    }

    public void goHomePageFirefox() {
        firefoxDriver.get(base_Url);
    }

    public void moveToLogInPageChrome() {
        chromeDriver.findElement(loginButtonLocator).click();
    }

    public void moveToLogInPageFirefox() {
        firefoxDriver.findElement(loginButtonLocator).click();
    }

    public void moveToRegisterPageChrome() {
        chromeDriver.findElement(registerButtonLocator).click();
    }

    public void moveToRegisterPageFirefox() {
        firefoxDriver.findElement(registerButtonLocator).click();
    }
}
