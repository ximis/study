package UIObjects;

import annotations.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utils.ReadLocations;

import java.util.Map;
import java.util.Properties;

public class BaseUIObject {
    protected Map<String, Map<String,String>> locations = null;

    protected SearchContext searchContext;


    public BaseUIObject(SearchContext searchContext){
        this.searchContext = searchContext;

        if(this.getClass().isAnnotationPresent(Location.class)){
            locations = ReadLocations.readLocation(this.getClass().getAnnotation(Location.class).value());
        }
    }

    protected WebElement getElement(String name){

        WebElement element = null;

        Map<String, String> locator =  locations.get(name);

        if(locator != null){
            if(locator.get("type").equals("xpath")){
                element = searchContext.findElement(By.xpath(locator.get("locator")));
            }
        }

        return element;
    }
}
