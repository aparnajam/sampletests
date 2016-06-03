package functional_tests.stepDefinition;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import functional_tests.automationFramework.Framework;
import functional_tests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

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

    @And("^select a location$")
    public void selectALocation() throws Throwable {
        os.zipCode().sendKeys("11221");
        driver.findElement(By.cssSelector("#restaurants > div:nth-child(18) a")).click();
    }

    @Then("^pick a salad$")
    public void pickASalad() throws Throwable {
        driver.findElement(By.cssSelector("#menu > div:nth-child(3) > div.flex-row > div:nth-child(3)")).click();
    }

    @And("^Add it to the bag$")
    public void addItToTheBag() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("The example is" +driver.getTitle());
        assertTrue(driver.findElement(By.cssSelector("#ingredients-bar")).isDisplayed());
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='confirm-or-add']/button"))).click();
        SaveScreenShot("Check this one 3");
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., \""+ "Confirm" + "\")]"))).click();
        SaveScreenShot("Check this one 4");
    }

    @Then("^proceed to the checkout page$")
    public void proceedToTheCheckoutPage() throws Throwable {
        driver.findElement(By.cssSelector("div.checkout-btns > a > button")).click();
        driver.findElement(By.cssSelector("form input")).sendKeys("aparnajammula@gmail.com");
        driver.findElement(By.cssSelector("button.full-width.test-check-email-button")).click();
        driver.findElement(By.cssSelector("form div:nth-child(2) input")).sendKeys("iamgreen123");
        driver.findElement(By.cssSelector("#customers-signin > div > form > button")).click();
        assertTrue(driver.findElement(By.cssSelector("#checkout")).isDisplayed());
    }
}
