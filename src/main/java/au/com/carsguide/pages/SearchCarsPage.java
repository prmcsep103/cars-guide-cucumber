package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchCarsPage extends Utility {

    private static final Logger log = LogManager.getLogger(SearchCarsPage.class.getName());

    public SearchCarsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='heading main-heading item-ad-wrapper ']//h1")
    WebElement headingText;

    @CacheLookup
    @FindBy(id = "makes")
    WebElement makeDropDown;

    @CacheLookup
    @FindBy(id = "models")
    WebElement modelDropDown;

    @CacheLookup
    @FindBy(id = "locations")
    WebElement locationDropDown;

    @CacheLookup
    @FindBy(id = "priceTo")
    WebElement priceDropDown;

    @CacheLookup
    @FindBy(xpath = "//input[@id='search-submit' and @type='submit']")
    WebElement findMyNextCarButton;

    public void verifyHeadingText(String expected) {
        String actual = headingText.getText().trim();
        boolean expectedResult = actual.contains(expected);
        log.info("Verifying heading text. '" + actual + "'");
        Assert.assertTrue(expectedResult);
    }

    public void selectMake(String make) {
        selectByVisibleTextFromDropDown(makeDropDown, make);
        log.info("select make: '" + make + "'");
    }

    public void selectModel(String model) {
        selectByValueFromDropDown(modelDropDown, model);
        log.info("select model: '" + model + "'");
    }

    public void selectLocation(String location) {
        selectByVisibleTextFromDropDown(locationDropDown, location);
        log.info("select location: '" + location + "'");
    }

    public void selectPriceTo(String priceTo) {
        selectByValueFromDropDown(priceDropDown, priceTo);
        log.info("select priceTo: '" + priceTo + "'");
    }

    public void clickOnFindMyNextCarButton() {
        clickOnElement(findMyNextCarButton);
        log.info("clicking on Find my next car button. ");
    }

}
