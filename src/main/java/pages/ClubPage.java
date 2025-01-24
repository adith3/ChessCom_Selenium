package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClubPage {
    @FindBy(css = "#vue-instance > div.v5-section.v5-section-content.clubs-header-container > div.clubs-header-footer > div > button")
    public WebElement goToChat;

    @FindBy(css = "button.cc-button-component.cc-button-secondary.cc-button-large.cc-button-full.clubs-live-chat")
    public WebElement helloWorldMessage;

    public ClubPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

