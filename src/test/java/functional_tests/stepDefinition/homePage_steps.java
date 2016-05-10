package functional_tests.stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import functional_tests.automationFramework.Framework;
import functional_tests.pages.homePage;
import functional_tests.pages.menuPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


import java.io.IOException;

public class homePage_steps extends Framework{

    boolean HeadlessDriverFlag;
    homePage hp = new homePage();
    menuPage mp = new menuPage();

    @Given("^User goes to homepage$")
    public void userGoesToHomepage() throws Throwable {
        navigate("http://sweetgreen.com",false);
    }

    @Then("^verify sweetgreen logo is displayed$")
    public void verifySweetgreenLogoIsDisplayed() throws Throwable {
        assertNotNull(hp.logo());
    }

    @Then("^Verify user is able to access menu page$")
    public void verifyUserIsAbleToAccessMenuPage() throws Throwable {
         hp.clickMenu();
         assertEquals(driver.getTitle(),"menu | sweetgreen" );

    }

    @Then("^Verify user is able to access locations page$")
    public void verifyUserIsAbleToAccessLocationsPage() throws Throwable {
        hp.clickLocations();
    }

    @Then("^Verify user is able to access contact page$")
    public void verifyUserIsAbleToAccessContactPage() throws Throwable {
        hp.clickContact();
    }

    @Then("^Verify user is able to access festival page$")
    public void verifyUserIsAbleToAccessFestivalPage() throws Throwable {
        hp.clickFestival();
    }
}





