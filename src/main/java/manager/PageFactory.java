package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactory {

    WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoremIpsumPage getLoremIpsumPage(){
        return new LoremIpsumPage(driver);
    }

    public GeneratedLoremIpsumPage getGeneratedLoremIpsumPage(){
        return new GeneratedLoremIpsumPage(driver);
    }
}
