package ui.step;

import ui.page.HomePage;

import java.util.List;

public class HomePageStep extends HomePage {
    public void openPageAndClickOnLoginButton() {
        openPage()
                .clickToLogin();
        logger.info("Page opened " + driver.getCurrentUrl());
    }
    public List<String> getListOfTitleUI() {
        openPage();
        logger.info(getListOfTitles());
        return getListOfTitles();
    }
}