package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyListsPageHelper extends PageBase {
    @FindBy(id = "org.wikipedia:id/item_container")
    WebElement firstMyReadingListItem;


    public MyListsPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(firstMyReadingListItem, 10);
    }

    public void openfirstMyReadingListItem() {
        firstMyReadingListItem.click();
    }
}
