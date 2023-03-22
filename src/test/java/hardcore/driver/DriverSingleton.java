package hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSingleton {
        private static WebDriver driver;
        private DriverSingleton(){}

        public static WebDriver getDriver(){
            if (null == driver){
                switch (System.getProperty("browser")){
                    case "Safari": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new SafariDriver();
                    }
                    default: {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                }
                driver.manage().window().maximize();
            }
            return driver;
        }

        public static void closeDriver(){
            driver.quit();
            driver = null;
        }
}
