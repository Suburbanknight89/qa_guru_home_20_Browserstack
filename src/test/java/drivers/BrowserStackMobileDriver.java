package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.App;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(App.config.browserStackURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", App.config.browserStackUsername());
        desiredCapabilities.setCapability("browserstack.key", App.config.browserStackPassword());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", App.config.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");


        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
