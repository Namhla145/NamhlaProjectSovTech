package framework.testng;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseSeleniumTest {
    protected static final ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    protected RemoteWebDriver getDriver() {
        return drivers.get();
    }
}
