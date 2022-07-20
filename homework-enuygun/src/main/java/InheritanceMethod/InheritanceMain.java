package InheritanceMethod;


public class InheritanceMain extends InheritanceBase {


    public static void main(String[] args) {
        //Base sınıfı içeren Main sınıfı içinde nesne oluşturup metodları kullanıyoruz
        InheritanceMain main = new InheritanceMain();

        main.driverSetup();
        main.goHomePage();
        //main.moveToLoginPage();
        main.moveToRegisterPage();

    }
}
