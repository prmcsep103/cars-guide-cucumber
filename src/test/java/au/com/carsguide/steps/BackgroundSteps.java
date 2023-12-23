package au.com.carsguide.steps;

import au.com.carsguide.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BackgroundSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
        new HomePage().verifyHomePage();
    }

    @And("^I mouse hover on \"([^\"]*)\" tab$")
    public void iMouseHoverOnTab(String menuItem) {
        new HomePage().selectFromMenu(menuItem);
    }


}
