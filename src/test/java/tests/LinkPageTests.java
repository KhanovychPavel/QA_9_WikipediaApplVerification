package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LinkPageHelper;

public class LinkPageTests extends TestBase {
    LinkPageHelper linkPage;

    @BeforeMethod(alwaysRun = true)
    public void initTests() {
        linkPage = PageFactory.initElements(driver, LinkPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        homePage.searchFieldFill("Java");
        homePage.openFirstLink();
        linkPage.waitUntilPageIsLoaded();

    }

    @Test
    public void addingToMyListVerification() {
        linkPage.addArticleToReadingListButtonClick();
        linkPage.clickOnGoItButton();
        linkPage.fillNameListField("My first list");
        linkPage.returnToHomePage();
        homePage.waitUntilPageIsLoaded();
        linkPage.enterMyListsPage();
        Assert.assertEquals("My first list", linkPage.nameOfCreatingList());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
