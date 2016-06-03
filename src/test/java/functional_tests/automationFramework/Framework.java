package functional_tests.automationFramework;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Framework {

    private static final Logger logger = Logger.getLogger(Framework.class);

    public static WebDriver driver;
    public static DesiredCapabilities caps;

    public Framework() {
        PageFactory.initElements(driver, this);
    }


    public static void InstanceBrowser(boolean cookies) {

        String seleniumHubEndpoint = System.getProperty("selenium.hub.endpoint");
        if(StringUtils.isNotEmpty(seleniumHubEndpoint)) {
            caps = new DesiredCapabilities();
            caps.setCapability("browser", System.getProperty("selenium.hub.capability.browser", "firefox"));

            if(StringUtils.isNotEmpty(System.getProperty("selenium.hub.capability.browser_version"))) {
                caps.setCapability("browser_version", System.getProperty("selenium.hub.capability.browser_version"));
            }

            if(StringUtils.isNotEmpty(System.getProperty("selenium.hub.capability.os"))) {
                caps.setCapability("os", System.getProperty("selenium.hub.capability.os"));
            }

            if(StringUtils.isNotEmpty(System.getProperty("selenium.hub.capability.os_version"))) {
                caps.setCapability("os_version", System.getProperty("selenium.hub.capability.os_version"));
            }
            if(StringUtils.isNotEmpty(System.getProperty("selenium.hub.capability.browserstack.debug"))) {
                caps.setCapability("browserstack.debug", System.getProperty("selenium.hub.capability.browserstack.debug"));
                caps.setCapability("acceptSslCerts", "true"); // Avoid Invalid Certificate errors
            }

            try{
                driver = new RemoteWebDriver(
                        new URL(seleniumHubEndpoint),
                        caps
                );
            }  catch (MalformedURLException e){
                e.printStackTrace();
            }

        } else {
            if (cookies == true) {
                FirefoxProfile profile = new ProfilesIni().getProfile("default");
                profile.setPreference("network.cookie.cookieBehavior", 2);
                driver = new FirefoxDriver(profile);
            }
            else {
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("reader.parse-on-load.enabled", false);
                driver = new FirefoxDriver(firefoxProfile);
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void navigate( String strUrl, Boolean cookies) throws InterruptedException {
        //Instances the Browser to be launched
        InstanceBrowser(cookies);
        driver.get(strUrl);
        driver.findElement(By.cssSelector("#mailchimp-signup > div > button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3); //you can play with the time integer  to wait for longer than 15 seconds.`
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-backdrop fade in")));



    }

    public static void driverquit(boolean HeadlessDriverFlag){ //flag determines whether the Webdriver is headless or not
        // This method closes the driver
        if (HeadlessDriverFlag == false)
            driver.quit();
    }

    public static void SaveScreenShot(String strNameSeed) throws IOException {
        //String scrBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("SCREENSHOT :" +scrFile );
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("./TestResults/" + strNameSeed + ".png"));
    }

    public Set<String> findBrokenImages() {
        // Find Broken Images
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));

        Set<String> brokenImages = new LinkedHashSet<String>();

        for (WebElement image : imagesList) {
            try {

                HttpClient httpclient = HttpClientBuilder.create().build();
                HttpResponse response = httpclient.execute(new HttpGet(image.getAttribute("src")));
                if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    brokenImages.add(image.getAttribute("src"));
                }
            } catch (IOException ioe) {
                logger.warn("Bad image " + image);
            }
        }

        return brokenImages;

    }

    public static void hover(WebElement elems){
        // Hovering over elements
        Actions builder = new Actions(driver);
        Actions hover = builder.moveToElement(elems);
        hover.perform();

    }


}

