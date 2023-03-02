package ui.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.WebDriverSingleton;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = "https://demoqa.com/books";
    protected static Logger logger = LogManager.getLogger();
    protected WebDriver driver;

    protected BasePage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    protected WebElement waitForElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void fillForm(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected BasePage scrollPageDown(By locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(locator);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        return this;
    }
}
