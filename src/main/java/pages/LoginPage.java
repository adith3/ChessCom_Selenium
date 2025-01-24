package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "a[class$='login ']")
    public WebElement loginPage;

    @FindBy(css = "input[aria-label$='Email']")
    public WebElement emailInput;

    @FindBy(css = "input[aria-label$='Password']")
    public WebElement passwordInput;

    @FindBy(id = "login")
    public WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
