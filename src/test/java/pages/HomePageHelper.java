package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/search_container']/*[@class='android.widget.TextView']")
    WebElement searchField;
    @FindBy(id = "org.wikipedia:id/search_src_text")
    WebElement searchLinkField;
    @FindBy(id = "org.wikipedia:id/page_list_item_container")
    WebElement firstLink;
    @FindBy(id = "org.wikipedia:id/page_list_item_title")
    WebElement firstLinkTitle;
    @FindBy(id = "org.wikipedia:id/page_list_item_description")
    WebElement firstLinkDescription;

    public HomePageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable (searchField, 10);
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }

    public void searchFieldFill(String link) {
        searchField.click();
        waitUntilElementIsClickable(searchLinkField, 5);
        editField(searchLinkField, link);
        waitUntilElementIsClickable(firstLink, 10);
    }

    public String getFirstLinkTitle() {
        return firstLinkTitle.getText();
    }

    public String getFirstLinkDescription() {
        return firstLinkDescription.getText();
    }

    public void openFirstLink() {
        firstLink.click();
    }

}










































































//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/page_list_item_container']")
//    WebElement firstPageListItem;
//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/page_toolbar']//*[@class='android.widget.ImageView']")
//    WebElement moreOptionsButton;
//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/title']")
//    WebElement addToReadingList;
//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/create_button']/*@class='android.widget.TextView']")
//    WebElement createNewNote;
//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/text_input']")
//    WebElement nameOfTheListField;
//    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
//    WebElement okButton;
//    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/page_actions_tab_layout']")
//    WebElement pop_upString;
//    @FindBy(xpath =
//            "//*[@resource-id='org.wikipedia:id/page_actions_tab_layout']//*[@class=android.widget.ImageView")
//    WebElement viewList;