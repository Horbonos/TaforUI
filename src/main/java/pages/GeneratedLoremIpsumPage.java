package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class GeneratedLoremIpsumPage extends BasePage{

    public GeneratedLoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='lipsum']/p[1]")
    private WebElement generatedFirstParagraph;

    @FindBy(xpath = "//*[@id='lipsum']/p")
    private WebElement generatedParagraphWithWordSize;

    @FindBy(xpath = "//div[@id='lipsum']")
    private WebElement generatedParagraphWithBytesSize;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> generatedParagraphs;

    @FindBy(xpath = "//div[@class='boxed']")
    private WebElement windowGenerated;

    public String getTextWindowGenerated(){
        return windowGenerated.getText();
    }

    public String getTextGeneratedParagraphWithBytesSize(){
        return generatedParagraphWithBytesSize.getText();
    }

    public String getTextGeneratedParagraphWithWordSize(){
        return generatedParagraphWithWordSize.getText();
    }


    public String getTextGeneratedFirstParagraph(){
        return generatedFirstParagraph.getText();
    }


}
