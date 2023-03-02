package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;
    private static ChromeOptions options;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        options = new ChromeOptions().addArguments("--incognito");
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
