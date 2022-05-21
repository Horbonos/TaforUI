package button;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {

    @Getter
    private WebElement dynamicWebElement;
    private WebDriver driver;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextXpath(String elementLabel, int elementNumber) {

        return String.format("(//*[normalize-space()=\"%s\"])[%s]", elementLabel, elementNumber);
    }

    public void setValueToDynamicWebElement(String xpath){
        dynamicWebElement = driver.findElement(By.xpath(xpath));
    }
}
