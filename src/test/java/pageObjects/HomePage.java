package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.Page;

public class HomePage extends Page {

    @FindBy(id = "query")
    private WebElement searchBox;

    @FindBy(id = "search")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void Visit() {
        browser.navigate().to("https://link.springer.com/");
    }

    public void searchFor(String query) {
        searchBox.sendKeys(query);
        searchButton.click();
    }
}
