package InterfaceMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ChromeDriver implements WebDriver {
    org.openqa.selenium.WebDriver driver;
    Actions act;
    public ChromeDriver() {
        try {
            Path resourceDirectory = Paths.get("homework-enuygun", "src", "main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            org.openqa.selenium.WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
            Actions act = new Actions(driver);
            this.act = act;
            this.driver = driver;
            driver.get("https://www.enuygun.com/");
            System.out.println("Launching Chrome Browser");
        } catch (IllegalStateException e) {
            System.out.println("There was a problem installing the driver" + e);
        }

    }

    @Override
    public void get(String url) {
        System.out.println("Launching url" + url);
    }


    @Override
    public void findElement(By locator) {
        System.out.println("Finding this elements" + locator);

    }

    @Override
    public void close() {
        System.out.println("Browser are closed ");
    }

    @Override
    public void quit() {
        System.out.println("Quit all the browsers ");
    }

    @Override
    public void click(Actions act) {
        System.out.println("Clicked an element");
        act.click();

    }


}
