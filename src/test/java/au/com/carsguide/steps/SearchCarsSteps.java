package au.com.carsguide.steps;

import au.com.carsguide.pages.HomePage;
import au.com.carsguide.pages.SearchCarsPage;
import au.com.carsguide.pages.SearchCarsResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCarsSteps {
    @When("^I click \"([^\"]*)\" link$")
    public void iClickLink(String subMenuItem) {
        new HomePage().selectFromSubMenu(subMenuItem);
    }

    @Then("^I navigate to \"([^\"]*)\" page$")
    public void iNavigateToPage(String expectedContains) {
        new SearchCarsPage().verifyHeadingText(expectedContains);
    }

    @And("^I select make \"([^\"]*)\"$")
    public void iSelectMake(String make) {
        new SearchCarsPage().selectMake(make);
    }

    @And("^I select model \"([^\"]*)\"$")
    public void iSelectModel(String model) {
        new SearchCarsPage().selectModel(model);
    }

    @And("^I select location \"([^\"]*)\"$")
    public void iSelectLocation(String location) {
        new SearchCarsPage().selectLocation(location);
    }

    @And("^I select price \"([^\"]*)\"$")
    public void iSelectPrice(String priceTo) {
        new SearchCarsPage().selectPriceTo(priceTo);
    }

    @And("^I click on Find My Next Car tab$")
    public void iClickOnFindMyNextCarTab() {
        new SearchCarsPage().clickOnFindMyNextCarButton();
    }


    @Then("^I should see the make \"([^\"]*)\" in results$")
    public void iShouldSeeTheMakeInResults(String make) {
        new SearchCarsResultPage().verifySearchFilter(make);
    }

}
