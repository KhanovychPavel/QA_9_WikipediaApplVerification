package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LinkPageHelper;
import pages.MyListsPageHelper;
import pages.MyReadingListPageHelper;

public class HomePageTests extends TestBase {
    LinkPageHelper linkPage;
    MyListsPageHelper myListsPage;
    MyReadingListPageHelper myReadingList;

    @BeforeMethod(alwaysRun = true)
    public void initTests() {
        linkPage = PageFactory.initElements(driver, LinkPageHelper.class);
        myListsPage = PageFactory.initElements(driver, MyListsPageHelper.class);
        myReadingList = PageFactory.initElements(driver, MyReadingListPageHelper.class);
    }

    @Test
    public void wikiTest() {
        Assert.assertEquals("Search Wikipedia", homePage.getSearchFieldText());
    }

    @Test
    public void searchByTextAndOpenFirstLinkRotation() {
        homePage.searchFieldFill("Java");
        System.out.println("First article title: " + homePage.getFirstLinkTitle());
        System.out.println("First article description: " + homePage.getFirstLinkDescription());
        homePage.openFirstLink();
        linkPage.waitUntilPageIsLoaded();

        linkPage.rotateToLandScape();
        linkPage.waitUntilPageIsLoaded();
        linkPage.rotateToPortrait();
        linkPage.waitUntilPageIsLoaded();

        Assert.assertEquals("Java", linkPage.getLinkName());
        Assert.assertEquals("Indonesian island", linkPage.getlinkNameDescription());

    }

    @Test
    public void searchByTextAndOpenFirstLinkBackGround() {
        homePage.searchFieldFill("Java");
        System.out.println("First article title: " + homePage.getFirstLinkTitle());
        System.out.println("First article description: " + homePage.getFirstLinkDescription());
        homePage.openFirstLink();
        linkPage.waitUntilPageIsLoaded();

        linkPage.runBackGround(5);
        linkPage.waitUntilPageIsLoaded();

        Assert.assertEquals("Java", linkPage.getLinkName());
        Assert.assertEquals("Indonesian island", linkPage.getlinkNameDescription());

    }

    @Test(groups = "smoke testing")
    public void Mob_01_Mob_03_AddLinkToReadingListVerification() {
        homePage.searchFieldFill("Java");
        homePage.openFirstLink();

        linkPage.waitUntilPageIsLoaded();
        linkPage.addArticleToReadingListButtonClick();
        linkPage.clickOnGoItButton();
        linkPage.fillNameListField("My first list");
        linkPage.returnToHomePage();

        homePage.waitUntilPageIsLoaded();

        linkPage.enterMyListsPage();

        myListsPage.waitUntilPageIsLoaded();
        myListsPage.openfirstMyReadingListItem();

        myReadingList.waitUntilPageIsLoaded();

        Assert.assertEquals("Java", myReadingList.getfirstListTitle());
        Assert.assertEquals("island of Indonesia", myReadingList.getfirstListDescription());
    }

    @Test
    public void searchByTextAndSwipeUp() {
        homePage.searchFieldFill("Java");
        homePage.returnToHomePage();
        homePage.swipeUp();
        homePage.swipeDown();
        homePage.swipeUpToElement(By.xpath("//*[@text = 'History of Indonesia']"), 10);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
