package hardcore.test;

import hardcore.model.CalculatorForm;
import hardcore.page.GoogleCalculatorPage;
import hardcore.service.CalculatorFormCreator;
import hardcore.util.StringUtils;
import hardcore.util.WindowSwitchUtils;
import hardcore.page.GoogleCloudPage;
import hardcore.page.YopMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleCloudPageTest extends CommonConditions {

    @Test(description = "Check total estimated monthly cost from email")
    public void totalEstimatedCostTest () {
        CalculatorForm testCalculatorForm = CalculatorFormCreator.withCredentialsFromProperty();
        GoogleCalculatorPage page = new GoogleCloudPage(driver)
                .openPage()
                .searchContentAndClick(StringUtils.getContentForSearch())
                .switchToCalculator()
                .addNumberOfInstances(testCalculatorForm)
                .addMachineType(testCalculatorForm)
                .addGPUs(testCalculatorForm)
                .addLocalSSD(testCalculatorForm)
                .addDatacenterLocation(testCalculatorForm)
                .addCommittedUsage(testCalculatorForm)
                .pushButtonAddToEstimate();
        String window1 = driver.getWindowHandle();
        String window2 = WindowSwitchUtils.getNewWindowHandleAndSwitch(driver);

        YopMailPage emailPage = new YopMailPage(driver)
                .openPage();
        String emailAddress = emailPage.getEmailAddress();

        driver.switchTo().window(window1);
        page.switchToCalculator();
        page.sendEmail(emailAddress);

        driver.switchTo().window(window2);

        Assert.assertEquals(testCalculatorForm.getTotalCost(), emailPage.getTotalEstimatedCostFromEmail());
    }
}