package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkPageHelper extends PageBase {
    @FindBy(id = "org.wikipedia:id/view_page_title_text")
    WebElement linkName;
    @FindBy(id = "org.wikipedia:id/view_page_subtitle_text")
    WebElement linkNameDescription;
    @FindBy(xpath =
            "//android.widget.ImageView[@content-desc='Add this article to a reading list']")
    WebElement addArticleToReadingListWidget;
    @FindBy(id = "org.wikipedia:id/onboarding_button")
    WebElement goItButton;
    @FindBy(id = "org.wikipedia:id/text_input")
    WebElement nameListField;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    WebElement okButton;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='My lists']")
    WebElement enterMyListWidget;
    @FindBy(id = "org.wikipedia:id/menu_sort_options")
    WebElement menuSortOptionsButton;
    @FindBy(id = "org.wikipedia:id/item_title")
    WebElement theNameOfTheListCreated;


    public LinkPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(linkName, 10);
        waitUntilElementIsVisible(linkNameDescription, 10);
    }

    public String getLinkName() {
        return linkName.getText();
    }

    public String getlinkNameDescription() {
        return linkNameDescription.getText();
    }

    public void addArticleToReadingListButtonClick() {
        addArticleToReadingListWidget.click();
    }

    public void clickOnGoItButton() {
        waitUntilElementIsClickable(goItButton, 5);
        goItButton.click();
    }

    public void fillNameListField(String name) {
        waitUntilElementIsClickable(nameListField, 5);
        nameListField.clear();
        nameListField.sendKeys(name);
        waitUntilElementIsClickable(okButton, 5);
        okButton.click();
        waitUntilPageIsLoaded();
    }

    public void enterMyListsPage() {
        enterMyListWidget.click();
        waitUntilElementIsVisible(menuSortOptionsButton, 5);
    }

    public String nameOfCreatingList() {
        return theNameOfTheListCreated.getText();
    }
}
