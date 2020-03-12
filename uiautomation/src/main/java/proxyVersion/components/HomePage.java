package proxyVersion.components;

import annotations.Path;
import org.openqa.selenium.support.FindBy;

@Path(path = "https://qauat01at.logicmonitor.com/santaba/uiv3/alert/index.jsp", title = "Logicmonitor Hosted Monitoring System")
public class HomePage extends BasePage {

    @FindBy(xpath = "//form[@id='login-section']")
    public LoginComponent loginComponent;

}
