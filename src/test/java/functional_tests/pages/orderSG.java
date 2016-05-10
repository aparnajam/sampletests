package functional_tests.pages;

/**
 * Created by aparnajammula on 5/9/16.
 */
import functional_tests.automationFramework.Framework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class orderSG extends Framework {

    //Page Objects

    @FindBy(css = ".test-zipcode-field") private WebElement zipCode;
    public WebElement zipCode() {return zipCode;}


    // Class Methods


}
