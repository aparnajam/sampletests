package functional_tests.pages;

/**
 * Created by aparnajammula on 5/9/16.
 */
import functional_tests.automationFramework.Framework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage extends Framework {

    //Page Objects

    @FindBy(css = "div[data-qa='ModelGroupItem'] section:nth-child(1) div.models a.model") private List<WebElement> pAllModels;
    public List<WebElement> Standard_Models() {return pAllModels;}

    @FindBy(css = "#brand > img") private WebElement logo;
    public WebElement logo() {return logo;}

    @FindBy(css = "#menu-top-nav-secondary-1 > li") private WebElement orderOnline;
    public WebElement orderOnline() {return orderOnline;}

    @FindBy(css ="#menu-top-nav-1 > li.menu-menu > a") private WebElement menu;
    public WebElement menu() {return menu;}

    @FindBy(css ="#menu-top-nav-1 > li.menu-locations > a") private WebElement locations;
    public WebElement locations() {return locations;}

    @FindBy(css = "div.gallery-wrap .slide-overlay") private WebElement carousel;
    public WebElement carousel() {return carousel;}

    @FindBy(css ="#menu-footer-nav-1 > li.menu-contact > a") private WebElement contact;
    public WebElement contact() {return contact;}

    @FindBy(css ="#menu-footer-nav-1 > li.menu-sweetlife-festival > a") private WebElement festival;
    public WebElement festival() {return festival;}


    // Class Methods

    public void clickOnlineOrder() {
        homePage page = PageFactory.initElements(driver, homePage.class);
        page.orderOnline().click();
    }

    public void clickMenu() {
        homePage page = PageFactory.initElements(driver, homePage.class);
        page.menu().click();

    }

    public void clickLocations() {
        homePage page = PageFactory.initElements(driver, homePage.class);
        page.locations().click();
    }

    public void clickContact() {
        homePage page = PageFactory.initElements(driver, homePage.class);
        page.contact().click();
    }

    public void clickFestival() {
        homePage page = PageFactory.initElements(driver, homePage.class);
        page.festival().click();
    }

}