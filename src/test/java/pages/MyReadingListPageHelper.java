package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyReadingListPageHelper extends PageBase {
    @FindBy(id = "org.wikipedia:id/page_list_item_title")
    WebElement firstListTitle;
    @FindBy(id = "org.wikipedia:id/page_list_item_description")
    WebElement firstListDescription;


    public MyReadingListPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(firstListTitle, 10);
        waitUntilElementIsVisible(firstListDescription,10);
    }

    public String getfirstListTitle() {
        return firstListTitle.getText();
    }

    public String getfirstListDescription() {
        return firstListDescription.getText();
    }
}
