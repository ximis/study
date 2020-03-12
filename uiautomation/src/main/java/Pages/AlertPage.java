package Pages;

import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage{
    private static String URL = "https://qauat01at.logicmonitor.com/santaba/uiv3/alert/index.jsp";




    public AlertPage(WebDriver driver){
        super(driver, "alert", URL);
    }




}
