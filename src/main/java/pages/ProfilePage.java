package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    @FindBy(css = "#profile_firstName")
    public WebElement firstName;

    @FindBy(css = "#profile_lastName")
    public WebElement lastName;

    @FindBy(css = "#profile_location")
    public WebElement location;

    @FindBy(css = "#profile_save")
    public WebElement submitButton;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
