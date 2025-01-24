package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberPage {
    @FindBy(css = "input[placeholder='Search Members']")
    public WebElement searchMember;

    @FindBy(css = ".icon-button-icon.user-plus.icon-font-chess")
    public WebElement addFriend;

    public MemberPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}


