package InheritanceMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InheritanceBase {

    public WebDriver chromeDriver;
    public WebDriver firefoxDriver;



    public void driverSetup() {
        //driver kurulumlarımızı burada yapıyoruz
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

    //Yapmak istediğimiz işlemleri metodlar ile yapıyoruz
    public void goHomePage(){
        chromeDriver.get("https://www.enuygun.com/");
        firefoxDriver.get("https://www.enuygun.com/");
    }

    public void moveToLoginPage(){
        chromeDriver.findElement(By.id("ctx-LoginBtn")).click();
        firefoxDriver.findElement(By.id("ctx-LoginBtn")).click();
    }

    public void moveToRegisterPage(){
        chromeDriver.findElement(By.id("ctx-RegisterBtn")).click();
        firefoxDriver.findElement(By.id("ctx-RegisterBtn")).click();
    }

}
