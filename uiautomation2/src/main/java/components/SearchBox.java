package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBox extends BaseComponent{
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement input;


    public void sendKeys(String str){
        input.sendKeys(str);
    }


}
