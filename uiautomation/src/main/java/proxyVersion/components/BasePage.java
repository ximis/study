package proxyVersion.components;

import Common.WebDrvierHelper;
import annotations.Path;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private String url;
    private int TIMEOUT = 10;

    public BasePage() {

        if(this.getClass().isAnnotationPresent(Path.class)){
            this.url = this.getClass().getAnnotation(Path.class).path();
            String title = this.getClass().getAnnotation(Path.class).title();

            WebDriver driver = WebDrvierHelper.getDriver();
            driver.get(url);

            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(new ExpectedCondition<String>() {
                @NullableDecl
                @Override
                public String apply(@NullableDecl WebDriver input) {
                    return input.getTitle();
                }
            });


            if (!driver.getTitle().contains(title)) {
                throw new IllegalStateException("This page isn't on the correct page: " + title);
            }

        }

    }

}
