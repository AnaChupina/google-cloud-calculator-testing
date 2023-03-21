package hardcore.page;

import hardcore.model.CalculatorForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hardcore.page.ExplicitWait.waitForClickabilityOfElement;
import static hardcore.page.ExplicitWait.waitForPresenceOfElement;

public class GoogleCalculatorPage {
    private final WebDriver driver;
    @FindBy(xpath = "//md-tab-item//div[@class='tab-holder compute']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select[@placeholder='Series']//md-select-value")
    private WebElement series;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']//md-select-value")
    private WebElement machineTypeDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkboxGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement searchGPUType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageDropdown;
    @FindBy(xpath = "//div[contains(@class,'md-clickable')]//div[contains(text(), '1 Year')]")
    private WebElement search1Year;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimate;
    @FindBy(xpath = "//button[@title='Email Estimate']//span[contains(text(), 'email')]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement buttonSendEmail;
    @FindBy(xpath = "//md-card-content[@id='resultBlock']//div[contains(text(), 'Region')]")
    private WebElement searchCurrentRegion;

    public GoogleCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleCalculatorPage switchToCalculator() {
        WebElement iframe = waitForPresenceOfElement(driver, "//article[@id='cloud-site']/devsite-iframe/iframe");
        driver.switchTo().frame(iframe);

        iframe = driver.findElement(By.xpath("//iframe[@id='myFrame']"));
        driver.switchTo().frame(iframe);
        return this;
    }
    public GoogleCalculatorPage addNumberOfInstances (CalculatorForm form) {
        computeEngine.click();
        numberOfInstances.sendKeys(form.getNumberOfInstances());
        return this;
    }
    public GoogleCalculatorPage addMachineType (CalculatorForm form) {
        series.click();
        String seriesLocator = "//md-option[@value='" + form.getSeries() + "']";
        waitForClickabilityOfElement(driver, seriesLocator).click();

        machineTypeDropdown.click();
        String machineTypeLocator = "//md-option//div[contains(text(), '" + form.getMachineType() + "')]";
        waitForClickabilityOfElement(driver, machineTypeLocator).click();
        return this;
    }
    public GoogleCalculatorPage addGPUs(CalculatorForm form) {
        checkboxGPUs.click();
        searchGPUType.click();
        String typeOfGPULocator = "//div[contains(text(), '" + form.getTypeOfGPU() + "')]";
        waitForClickabilityOfElement(driver, typeOfGPULocator).click();

        numberOfGPUsDropdown.click();
        String numberOfGPUsLocator = "//div[contains(@class,'md-clickable')]//div[contains(text(), '" + form.getNumberOfGPUs() + "')]";
        waitForClickabilityOfElement(driver, numberOfGPUsLocator).click();
        return this;
    }
    public GoogleCalculatorPage addLocalSSD(CalculatorForm form) {
        localSSDDropdown.click();
        String localSSDLocator = "//div[@class='md-text ng-binding' and contains(text(), '" + form.getLocalSSD() + "')]";
        waitForClickabilityOfElement(driver, localSSDLocator).click();
        return this;
    }
    public GoogleCalculatorPage addDatacenterLocation(CalculatorForm form) {
        datacenterLocation.click();
        String datacenterLocator = "//div[contains(@class,'md-clickable')]//div[contains(text(), '" + form.getDatacenterLocation() + "')]";
        waitForClickabilityOfElement(driver, datacenterLocator).click();
        return this;
    }
    public GoogleCalculatorPage addCommittedUsage(CalculatorForm form) {
        committedUsageDropdown.click();
        String committedUsageLocator = "//div[contains(@class,'md-clickable')]//div[contains(text(), '" + form.getCommittedUsage() + "')]";
        waitForClickabilityOfElement(driver, committedUsageLocator).click();
        return this;
    }
    public GoogleCalculatorPage pushButtonAddToEstimate() {
        waitForClickabilityOfElement(driver, addToEstimate).click();
        return this;
    }
    public GoogleCalculatorPage sendEmail(String email) {
        waitForClickabilityOfElement
                (driver, emailEstimate).click();
        emailInput.click();
        emailInput.sendKeys(email);
        buttonSendEmail.click();
        return this;
    }
    public String getCurrentRegion() {
        return searchCurrentRegion.getText();
    }
}
