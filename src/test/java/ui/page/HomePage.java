package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    private final By loginButton = By.xpath("//span[contains(text(),'Login')]");
    private final By booksContainer = By.xpath("//span[@class='mr-2']");

    public HomePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Page Opened " + driver.getCurrentUrl());
        return this;
    }

    public LoginPage clickToLogin() {
        scrollPageDown(loginButton).clickOnElement(loginButton);
        return new LoginPage();
    }

    public List<String> getListOfTitles() {
        List<WebElement> elements = driver.findElements(booksContainer);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
