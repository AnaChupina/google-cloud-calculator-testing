package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hardcore.page.ExplicitWait.waitForPresenceOfElement;

public class GoogleCloudPage {
    private static final String URL = "https://cloud.google.com/";
    private final WebDriver driver;

    @FindBy(xpath="//div[@class='devsite-search-container']")
    private WebElement buttonOpenSearch;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleCloudPage openPage() {
        driver.get(URL);
        waitForPresenceOfElement(driver, "//button[@aria-label='Open search']");
        return this;
    }
    public GoogleCalculatorPage searchContentAndClick (String content) {
        String element = "//div[@class='gs-title']//b[text()='" + content + "']";
        buttonOpenSearch.click();
        searchField.sendKeys(content);
        searchField.sendKeys("\n");
        waitForPresenceOfElement(driver, element);
        WebElement resultsOfSearch = driver.findElement(By.xpath(element));
        resultsOfSearch.click();
        return new GoogleCalculatorPage(driver);
    }
}