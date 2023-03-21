package hardcore.test;

import hardcore.model.CalculatorForm;
import hardcore.page.GoogleCalculatorPage;
import hardcore.page.GoogleCloudPage;
import hardcore.service.CalculatorFormCreator;
import hardcore.util.StringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;


public class SmokeTest extends CommonConditions{

    @Test(description = "Check the region")
    public void regionTest () {
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

        Assert.assertEquals(StringUtils.getExpectedRegion(), page.getCurrentRegion());
    }
}
