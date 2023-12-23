package au.com.carsguide.pages;

import au.com.carsguide.propertyreader.PropertyReader;
import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Search Cars')]")
    WebElement searchCars;

    @CacheLookup
    @FindBy(xpath = "//div[@class='uhf-menu-left']//ul//li//a")
    List<WebElement> menuList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='uhf-menu-left']//ul//li//a")
    List<WebElement> subMenuList;

    public void verifyHomePage(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = PropertyReader.getInstance().getProperty("baseUrl");
        log.info("verifying homepage url.");
        AssertJUnit.assertEquals(expectedUrl,actualUrl);
    }

    public void selectFromMenu(String menuItem){
        List<WebElement> list = menuList;
        for(WebElement name : list){
            if(name.getText().trim().equalsIgnoreCase(menuItem)){
             mouseHoverToElement(name);
                log.info("hover mouse to menu bar.");
                break;
            }
        }
    }

    public void selectFromSubMenu(String subMenuItem){
        List<WebElement> list = subMenuList;
        for(WebElement name: list){
            if(name.getText().trim().equalsIgnoreCase(subMenuItem)){
                waitUntilVisibilityOfElementLocated(searchCars,2);
                mouseHoverToElementAndClick(name);
                log.info("hover to submenu and click on element.");
                break;
            }
        }
    }
}
