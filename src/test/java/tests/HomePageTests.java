package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LinkPageHelper;



public class HomePageTests extends TestBase {

    LinkPageHelper linkPage;

    @BeforeMethod
    public void initTests() {
        linkPage = PageFactory.initElements(driver, LinkPageHelper.class);

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
