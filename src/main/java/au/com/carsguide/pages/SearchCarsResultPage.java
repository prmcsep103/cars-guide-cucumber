package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchCarsResultPage extends Utility {

    private static final Logger log = LogManager.getLogger(SearchCarsResultPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//body/div[@class='container search-results-container']/div[@id='all-tab-content']/div[@class='row']/div[@class='listing-col col-sm-16 col-md-12 col-lg-13 col']/div[@class='no-results ng-scope']/div[@class='no-results-content']/div[1]")
    WebElement makeInSearchResult;

    @FindBy(xpath = "//div[@class='no-results-content']//div//div")
    List<WebElement> unsuccessfullSearchCriteriaInResultPage;

    @FindBy(xpath = "//h1[contains(@class,'search--title')]")
    WebElement verifySearchHeading;

    public void verifySearchFilter(String make) {
        if (verifySearchHeading.getText().trim().contains("We did find these cars that almost match your criteria")) {
            for (WebElement name : unsuccessfullSearchCriteriaInResultPage) {
                if (name.getText().trim().equalsIgnoreCase(make)) {
                    String actual = name.getText().trim().toLowerCase();
                    boolean expected = actual.contains(make.toLowerCase());
                    log.info("Verifying make - actual displayed: '" + actual + "'");
                    Assert.assertTrue(expected);
                    log.info("verifying search results of make from data set: '" + make + "'");
                }
            }
        } else {
            String actual = verifySearchHeading.getText().toLowerCase();
            System.out.println("Actual getText printing=" + actual);
            boolean expected = actual.contains(make.toLowerCase());
            log.info("actual result: '" + actual + "'");
            Assert.assertTrue(expected);
            log.info("verifying search results of make from data set: '" + make + "'");
        }
    }

}
