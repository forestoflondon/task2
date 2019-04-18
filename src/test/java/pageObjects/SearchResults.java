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

    @FindBy(id = "no-results-message")
    private WebElement noResultsMessage;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayingResultsFor(String term) {
        return resultsList.isDisplayed()
                && searchResultsHeader.getText().contains(String.format("Result(s) for '%s'", term));
    }

    public boolean isDisplayingNoResultsFor(String term) {
        return noResultsMessage.isDisplayed()
                && searchResultsHeader.getText().equals(String.format("0 Result(s) for '%s'", term));
    }
}
