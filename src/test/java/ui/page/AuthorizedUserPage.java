package ui.page;

import org.openqa.selenium.By;

public class AuthorizedUserPage extends BasePage{
    private final By labelUserName = By.id("userName-value");
    public String getTextFromLabelUserName() {
      return getTextFromElement(labelUserName);
    }
}
