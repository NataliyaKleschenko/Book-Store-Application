package api.test;
import api.step.GetBooksStep;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.step.HomePageStep;
import ui.test.BaseTest;
import java.util.List;
public class IntegrationTest extends BaseTest {
    @Test
    @Description("check outputs from UI and API for equality list of books by title")
    public void compareListsOfTitles() {
        HomePageStep homePageStep = new HomePageStep();
        GetBooksStep getBooksStep = new GetBooksStep();
        List<String> listOfTitleUI = homePageStep.getListOfTitleUI();
        List<String> listOfTitleAPI = getBooksStep.getListOfTitlesAPI();

        Assert.assertEquals(listOfTitleUI,listOfTitleAPI);
    }
}
