package proxyVersion;

import Common.WebDrvierHelper;
import proxyVersion.components.HomePage;
import proxyVersion.components.LoginComponent;
import proxyVersion.support.PageFactoryInit;


public class t {
    public static void main(String[] args) {

        HomePage homePage= (HomePage) PageFactoryInit.init(HomePage.class);

        LoginComponent component = homePage.loginComponent;

        System.out.println("end");

        WebDrvierHelper.getDriver().quit();


    }

}
