package InterfaceMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public interface WebDriver {

     void get(String url);

     void findElement(By locator);

     void close();

     void quit();

     void click(Actions act);


}
