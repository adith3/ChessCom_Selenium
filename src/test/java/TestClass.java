import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import pages.*;

import java.io.FileInputStream;
import java.nio.file.*;
import java.util.Properties;

public class TestClass {

    WebDriver driver;
    LoginPage loginPage;
    LivePage livePage;
    ProfilePage profilePage;
    ClubPage clubPage;
    MemberPage memberPage;
    AnalysisPage analysisPage;
    Properties config;

    @BeforeClass
    public void setUp() throws Exception {
        config = new Properties();
        FileInputStream configFile = new FileInputStream("src/main/resources/config.properties");
        config.load(configFile);

        System.setProperty("webdriver.chrome.driver", config.getProperty("chromeDriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        livePage = new LivePage(driver);
        clubPage = new ClubPage(driver);
        memberPage = new MemberPage(driver);
        analysisPage = new AnalysisPage(driver);
    }

    @Test(priority = 1)
    public void testLogin() throws Exception {
        loginPage.loginPage.click();
        loginPage.emailInput.sendKeys(config.getProperty("username"));
        loginPage.passwordInput.sendKeys(config.getProperty("password"));
        loginPage.submitButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void testProfile() throws Exception {
        driver.get(config.getProperty("settings"));
        profilePage.firstName.clear();
        profilePage.firstName.sendKeys(config.getProperty("player"));
        profilePage.lastName.clear();
        profilePage.lastName.sendKeys(config.getProperty("lastName"));
        profilePage.location.clear();
        profilePage.location.sendKeys(config.getProperty("location"));
        profilePage.submitButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void testHome() throws Exception {
        driver.get(config.getProperty("board"));
        Select pieces = new Select(driver.findElement(By.id("board_pieces_gamePieceStyle")));
        pieces.selectByVisibleText("Wood");
        Select board = new Select(driver.findElement(By.id("board_pieces_gameBoardColor")));
        board.selectByVisibleText("Bases");
        driver.findElement(By.id("board_pieces_save")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void testPrivacy() throws Exception {
        driver.get(config.getProperty("privacy"));
        Select messages = new Select(driver.findElement(By.id("privacy_messagePrivacy")));
        messages.selectByVisibleText("Only my friends");
        Select chat = new Select(driver.findElement(By.id("privacy_allowGlobalChat")));
        chat.selectByVisibleText("Friends Only");
        driver.findElement(By.cssSelector("#privacy_save")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void testLive() throws Exception {
        driver.get(config.getProperty("live"));
        livePage.focusModeCheckbox.click();
        livePage.hideRatingsCheckbox.click();
        livePage.lowTimeWarningCheckbox.click();
        livePage.premoveEnabledCheckbox.click();
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void testClub() throws Exception {
        driver.get(config.getProperty("clubs"));
        WebElement targetElement = driver.findElement(By.cssSelector(".post-view-meta-image"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);
        clubPage.goToChat.click();
        clubPage.helloWorldMessage.sendKeys("Hello World");
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void testMembers() throws Exception {
        driver.get(config.getProperty("members"));
        memberPage.searchMember.sendKeys("SiliconHail", Keys.ENTER);
        memberPage.addFriend.click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void testAnalysis() throws Exception {
        driver.get(config.getProperty("analysis"));
        String pgnData = Files.readString(Paths.get("src/main/resources/fischer-tal.pgn"));
        analysisPage.uploadPGN.sendKeys(pgnData);
        analysisPage.addGame.click();
        for (int i = 0; i < 20; i++) analysisPage.nextMove.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
