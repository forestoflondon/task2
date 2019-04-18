package features;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pageObjects.HomePage;
import pageObjects.SearchResults;
import support.TestCase;

@Execution(ExecutionMode.CONCURRENT)
class Search extends TestCase {

    @Test
    void searchWithResultsTest() throws Exception {
        givenImOnTheHomePage();
        whenISearchFor("floccinaucinihilipilification");
        thenIAmShownResultsFor("floccinaucinihilipilification");
    }

    private void givenImOnTheHomePage() throws Exception {
        site.on(HomePage.class).Visit();
    }

    private void whenISearchFor(String term) throws Exception {
        site.on(HomePage.class).searchFor(term);
    }

    private void thenIAmShownResultsFor(String term) throws Exception {
        assert (site.on(SearchResults.class).isDisplayingResultsFor(term));
    }
}
