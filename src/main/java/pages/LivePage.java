package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LivePage {

    @FindBy(css = "label[for='live_chess_hideRatingsDuringGame']")
    public WebElement hideRatingsCheckbox;

    @FindBy(css = "div[class='cc-switch-component cc-switch-large'] label[for='live_chess_premoveEnabled']")
    public WebElement premoveEnabledCheckbox;

    @FindBy(css = "label[for='live_chess_lowTimeWarning']")
    public WebElement lowTimeWarningCheckbox;

    @FindBy(css = "label[for='live_chess_focusModeEnabled']")
    public WebElement focusModeCheckbox;

    public LivePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
