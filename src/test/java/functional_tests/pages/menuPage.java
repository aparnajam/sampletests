package functional_tests.pages;

/**
 * Created by aparnajammula on 5/9/16.
 */
import functional_tests.automationFramework.Framework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class menuPage extends Framework {

    //Page Objects


    @FindBy(css = "#region div.modal-body") private WebElement regionModal;
    public WebElement regionModal() {return regionModal;}


    // Class Methods

    public void clickOnlineOrder() {

    }

}
