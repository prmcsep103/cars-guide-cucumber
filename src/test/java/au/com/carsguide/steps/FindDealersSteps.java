package au.com.carsguide.steps;

import au.com.carsguide.pages.FindDealersResultPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FindDealersSteps {
    @Then("^I navigate to \"([^\"]*)\" url page$")
    public void iNavigateToUrlPage(String url) {
        new FindDealersResultPage().verifyCarDealersPage(url);
    }

    @And("^I should see the dealer names displayed on page$")
    public void iShouldSeeTheDealerNamesDisplayedOnPage(DataTable dataTable) {
        List<String> dealerName = dataTable.asList(String.class);
        SoftAssert softAssertions = new SoftAssert();
        for (int i = 1; i <= dealerName.size() - 1; i++) {
            softAssertions.assertTrue(new FindDealersResultPage().isDealerDisplayed(dealerName.get(i)),"'"+dealerName.get(i)+"' dealer not found");
        }
        softAssertions.assertAll();
    }
}
