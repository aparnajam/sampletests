package functional_tests.stepDefinition;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import functional_tests.automationFramework.Framework;
import functional_tests.pages.*;

import static org.testng.Assert.*;

/**
 * Created by aparnajammula on 5/9/16.
 */
public class smokeTest extends Framework {

    homePage hp = new homePage();
    orderSG os = new orderSG();


    @Then("^make sure the page is displayed properly$")
    public void makeSureThePageIsDisplayedProperly() throws Throwable {
        Eyes eyes = new Eyes();
        eyes.setApiKey("SC99VWqipsgAzkvjWhWtQMcSojnc3eftuA3K2QxGGSqY110");
        driver = eyes.open(driver, "Applitools", "Home Page", new RectangleSize(1024, 600));
        eyes.setMatchLevel(MatchLevel.CONTENT);
        eyes.checkWindow("sweetgreen");
        eyes.close();
    }

    @And("^click orderonline button$")
    public void clickOrderonlineButton() throws Throwable {
        hp.clickOnlineOrder();
    }

    @Then("^user should be redirected to ordering site$")
    public void userShouldBeRedirectedToOrderingSite() throws Throwable {
        assertTrue(os.zipCode().isDisplayed());
    }

}
