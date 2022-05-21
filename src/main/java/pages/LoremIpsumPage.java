package pages;

import button.RadioButton;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

@Getter
public class LoremIpsumPage extends BasePage{

    RadioButton radioButton;

    public LoremIpsumPage(WebDriver driver) {
        super(driver);
        radioButton = new RadioButton(driver);
    }

    @FindBy(xpath = "//a[@href='http://ru.lipsum.com/']")
    private WebElement translateRusButton;

    @FindBy(xpath = "//*[@id='Panes']/div[1]/p")
    private WebElement firstParagraph;

    @FindBy(xpath = "//input[@value='Generate Lorem Ipsum']")
    private WebElement generateLoremIpsumButton;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement setValueButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxButton;

    public boolean isCheckboxButtonSelected(){
        return checkboxButton.isSelected();
    }

    public void openHomePage() {
        driver.get("https://www.lipsum.com/");
    }

    public void clickCheckboxButton(){
        radioButton.setValueToDynamicWebElement(radioButton.getTextXpath("Start with 'Loremipsum dolor sit amet...'",1));
        radioButton.getDynamicWebElement().click();
    }


    public void clickBytesGeneratedButton(){
       radioButton.setValueToDynamicWebElement(radioButton.getTextXpath("bytes", 1));
       radioButton.getDynamicWebElement().click();
    }

    public void setValueButton(String value){

        setValueButton.sendKeys(Keys.BACK_SPACE,value);
    }

    public void clickWordGeneratedButton(){
        radioButton.setValueToDynamicWebElement(radioButton.getTextXpath("words", 1));
        radioButton.getDynamicWebElement().click();
    }


    public void clickGenerateLoremIpsumButton(){
        generateLoremIpsumButton.click();
    }


    public String getTextFirstParagraph(){
        return firstParagraph.getText();
    }


    public void clickTranslateRusButton(){
        translateRusButton.click();
    }

}
