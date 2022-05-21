package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public final static long DEFAULT_TIMEOUT = 60;
    public final static String PAGE_LOAD_SCRIPT = "return document.readyState";
    public final static String COMPLETE = "complete";

    @Getter
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForPageLoadComplete() {
        getWebDriverWait().until(driver -> ((JavascriptExecutor) driver)
                .executeScript(PAGE_LOAD_SCRIPT).equals(COMPLETE));
    }

    public void waitForElementVisibility(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementClickable(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }
    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }



}
