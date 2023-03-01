package ui.step;

import ui.page.AuthorizedUserPage;

public class AuthorizedUserStep extends AuthorizedUserPage {
    public String getAuthorizedUserName() {
        return getTextFromLabelUserName();
    }
}
