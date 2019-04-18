package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.Page;

public class SearchResults extends Page {

    @FindBy(id = "number-of-search-results-and-search-terms")
    private WebElement searchResultsHeader;

    @FindBy(id = "results-list")
    private WebElement resultsList;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayingResultsFor(String term) {
        return resultsList.isDisplayed()
                && searchResultsHeader.getText().contains(String.format("Result(s) for '%s'", term));
    }
}
