package InterfaceMethod;
import org.openqa.selenium.By;


public class InterfaceMain {

    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.enuygun.com/");
        chromeDriver.findElement(By.id("ctx-LoginBtn"));
        chromeDriver.act.click();


        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.enuygun.com/");
        firefoxDriver.findElement(By.id("ctx-LoginBtn"));


    }
}
