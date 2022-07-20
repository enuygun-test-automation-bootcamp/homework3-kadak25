package EnumMethod;

import org.openqa.selenium.By;

public class EnumConstants {
    //Driverlar için gerekli olan url, locator gibi şeyleri constants sınıfında tutup App sınıfında çağırıyoruz
    public static final String base_Url = "https://www.enuygun.com/";
    public static final By loginButtonLocator = By.id("ctx-LoginBtn");
    public static final By registerButtonLocator = By.id("ctx-RegisterBtn");
}
