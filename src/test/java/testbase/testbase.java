package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import Utilities.ConfigLoader;

public class testbase  {
    protected WebDriver driver;

    public WebDriver initializeDriver() {
        String browser = ConfigLoader.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(ConfigLoader.getProperty("headless"));

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigLoader.getProperty("chromeDriverPath"));
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                this.driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", ConfigLoader.getProperty("geckoDriverPath"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                this.driver = new FirefoxDriver(firefoxOptions);
                break;

            case "safari":
                // Safari doesn't support headless mode by default
                this.driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser " + browser + " is not supported.");
        }

        driver.manage().window().maximize();
        driver.get(ConfigLoader.getProperty("url"));
        return driver;  // Return the driver instance
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
