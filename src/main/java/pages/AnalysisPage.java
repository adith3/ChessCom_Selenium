package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalysisPage {
    @FindBy(css = "textarea[placeholder='Paste one or more PGNs, or drag & drop your PGN file here.']")
    public WebElement uploadPGN;

    @FindBy(css = "button[class='cc-button-component cc-button-primary cc-button-medium']")
    public WebElement addGame;

    @FindBy(css = "button[aria-label='Next Move']")
    public WebElement nextMove;

    public AnalysisPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}