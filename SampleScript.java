import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleScript {

    public static String accessKey = "ACCESS_KEY";
    public static String userName = "USERNAME";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S9");
        caps.setCapability("os_version", "8.0");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("autoAcceptAlerts", "true");
        caps.setCapability("build", "Support Automate");
        caps.setCapability("project", "Test Run");
        caps.setCapability("name", "Sample App");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();

        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(50000);

        driver.getContextHandles();

        Thread.sleep(50000);

        driver.getContextHandles();

        Thread.sleep(100000);

        driver.quit();
    }
}
