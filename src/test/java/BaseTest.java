import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;

public class BaseTest {
    Logger log = Logger.getLogger("rootLogger");
    static AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Android/app");
        File app = new File(appDir, "app-prodProm-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "NotUsed");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "ua.prom.b2c");
        capabilities.setCapability("appActivity", "ua.prom.b2c.ui.main.MainActivity");
        capabilities.setCapability("newCommandTimeout", "60");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @AfterTest

    public void tearDown () {
        driver.quit();

    }

    @BeforeMethod

    public void setUpBeforeMethod() {
        driver.launchApp();
    }


    @AfterMethod
    public void tearDownMethod(){
        driver.closeApp();
    }
}

