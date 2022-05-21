package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactory;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GeneratedLoremIpsumPage;
import pages.LoremIpsumPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Steps {

    private static boolean isCheckboxButtonSelected;
    private WebDriver driver;
    LoremIpsumPage loremIpsumPage;
    GeneratedLoremIpsumPage generatedLoremIpsumPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory pageFactory = new PageFactory(driver);
        loremIpsumPage = pageFactory.getLoremIpsumPage();
        generatedLoremIpsumPage = pageFactory.getGeneratedLoremIpsumPage();

    }

    @Given("User opens homepage")
    public void openHomePage() {
        loremIpsumPage.openHomePage();
        loremIpsumPage.waitForPageLoadComplete();
    }

    @When("Switch to Russian language using one of the links")
    public void switchToRussianLanguage() {
        loremIpsumPage.clickTranslateRusButton();
        loremIpsumPage.waitForPageLoadComplete();
    }

    @Then("Verify that the text of the first  element, which is the first paragraph, contains the word «рыба».")
    public void firstParagraphContainsTheWordTest() {

        Assert.assertTrue(loremIpsumPage.getTextFirstParagraph().contains("рыба"));
    }

    @When("Press Generate Lorem Ipsum button")
    public void pressGenerateLoremIpsum() {
        isCheckboxButtonSelected = loremIpsumPage.isCheckboxButtonSelected();
        loremIpsumPage.clickGenerateLoremIpsumButton();
    }

    @Then("Verify that the first paragraph starts with Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    public void firstParagraphStartsWithTest() {
        Assert.assertTrue(generatedLoremIpsumPage.getTextGeneratedFirstParagraph().startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }

    @When("Uncheck start with Lorem Ipsum checkbox")
    public void uncheckCheckbox() {
        loremIpsumPage.clickCheckboxButton();
    }

    @Then("Verify that result no longer starts with Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    public void resultNoLongerStartsWithTest() {
        Assert.assertFalse(generatedLoremIpsumPage.getTextGeneratedFirstParagraph().startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }

    @Then("Run the generation 10 times and get the average number of paragraphs containing the word “lorem”")
    public void containsTheWordLoremTest() {
        int counter = 0;
        for(int i = 0; i<11;i++) {
            for (WebElement element : generatedLoremIpsumPage.getGeneratedParagraphs()) {
                if (element.getText().contains("lorem")) {
                    counter++;
                }
            }

        }
        Assert.assertTrue(counter/10<2);
    }

    @When("Click on word button")
    public void clickOnWordButton() {
        loremIpsumPage.waitForPageLoadComplete();
        loremIpsumPage.clickWordGeneratedButton();
    }

    @And("Input {string} into the number field")
    public void inputValueIntoTheNumberField(String value) {
        loremIpsumPage.setValueButton(value);
    }

    @Then("Verify the result has {string} words")
    public void verifyTheResultHasValueWords(String value) {
        String result = generatedLoremIpsumPage.getTextWindowGenerated();
        int value1 = Integer.parseInt(value);
        if(value1<=0){
            Assert.assertTrue(result.contains("Error: small value! Generation not correct"));
        }

        if(isCheckboxButtonSelected&&value1<5){
            Assert.assertTrue(result.contains("Error: small value! Generation not correct"));
        }
        if(isCheckboxButtonSelected){
            Assert.assertTrue(generatedLoremIpsumPage.getTextGeneratedParagraphWithWordSize()
                    .startsWith("Lorem ipsum dolor sit amet"));
        }

        Assert.assertEquals(value,
                String.valueOf(generatedLoremIpsumPage.getTextGeneratedParagraphWithWordSize().split(" ").length));
    }

    @When("Click on byte button")
    public void clickOnByteButton() {
        loremIpsumPage.clickBytesGeneratedButton();
    }

    @Then("Verify the result has {string} bytes")
    public void verifyTheResultHasValueBytes(String value) {
        String result = generatedLoremIpsumPage.getTextWindowGenerated();
        int value1 = Integer.parseInt(value);
        if(value1<=3){
            Assert.assertTrue(result.contains("Error: small value! Generation not correct"));
        }
        Assert.assertEquals(value,
                String.valueOf(generatedLoremIpsumPage.getTextGeneratedParagraphWithBytesSize().getBytes().length));


    }




    @After
    public void closeWebDriver() {
        driver.quit();
    }



}