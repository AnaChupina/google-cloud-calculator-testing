package hardcore.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailPage {
    private static final String URL = "https://yopmail.com/ru/email-generator";
    private final WebDriver driver;

    @FindBy(xpath = "//div[@id='geny']")
    private WebElement searchMailAddress;
    @FindBy(xpath = "//span[contains(text(), 'Проверить почту')]")
    private WebElement searchCheckEmail;
    @FindBy(xpath = "//div[contains(text(), 'Google Cloud Price Estimate')]")
    private WebElement searchEmailSubject;
    @FindBy(xpath = "//div[@id='mail']//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement searchTotalCostFromEmail;
    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement searchButtonRefresh;
    @FindBy(xpath = "//iframe[@name='ifinbox']")
    private WebElement searchInboxFrame;
    @FindBy(xpath = "//iframe[@name='ifmail']")
    private WebElement searchMailFrame;

    public YopMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public YopMailPage openPage() {
        driver.get(URL);
        ExplicitWait.waitForPresenceOfElement(driver, "//div[@id='geny']");
        return this;
    }
    public String getEmailAddress () {
        return searchMailAddress.getAttribute("outerText");
    }
    public String getTotalEstimatedCostFromEmail() {
        ExplicitWait.waitForClickabilityOfElement
                (driver, "//span[contains(text(), 'Проверить почту')]");
        searchCheckEmail.click();

        for (int i = 0; i < 10; ++i) {
            searchButtonRefresh.click();
            try {
                driver.switchTo().frame(searchInboxFrame);
                ExplicitWait.waitForPresenceOfElement
                        (driver, "//div[contains(text(), 'Google Cloud Price Estimate')]");
            } catch (TimeoutException ex) {
                driver.switchTo().defaultContent();
                continue;
            }
            break;
        }

        searchEmailSubject.click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame(searchMailFrame);
        return searchTotalCostFromEmail.getText();
    }

}
