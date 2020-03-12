package UIObjects;

import annotations.Location;
import org.openqa.selenium.SearchContext;


@Location("login.properties")
public class LoginPage extends BaseUIObject {

    public LoginPage(SearchContext searchContext) {
        super(searchContext);

    }

    public void login(String username, String password) {
        getElement("username").sendKeys(username);
        getElement("password").sendKeys(password);
//        getElement("loginBtn").click();
    }
}
