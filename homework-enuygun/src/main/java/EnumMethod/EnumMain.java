package EnumMethod;


public class EnumMain {

    public static void main(String[] args) {

        //Oluşturduğumuz driverları kullanabilmek için App sınıfından bir nesne oluşturup var olan metodları çağırıyoruz
       EnumApp chromeApp= new EnumApp(Drivers.CHROME);
       EnumApp firefoxApp = new EnumApp(Drivers.FIREFOX);

       chromeApp.goHomePageChrome();
       //chromeApp.moveToLogInPageChrome();
       chromeApp.moveToRegisterPageChrome();



       firefoxApp.goHomePageFirefox();
       //firefoxApp.moveToLogInPageFirefox();
       firefoxApp.moveToRegisterPageFirefox();


    }


}
