package framework.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

public class BaseTest {
   // @Override
    @BeforeTest
    public void beforeTest(Method method) {
        //RemoteWebDriver driver =  (RemoteWebDriver) WebDriverFactory.createWebDriver();
    }
}
