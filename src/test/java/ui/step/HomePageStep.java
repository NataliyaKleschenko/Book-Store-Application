package ui.step;

import ui.page.HomePage;

import java.util.List;

public class HomePageStep extends HomePage {
    public void openPageAndClickOnLoginButton() {
        openPage()
                .clickToLogin();
    }
    public List<String> geListOfTitleUI() {
        openPage();
        return getListOfTitles();
    }
}