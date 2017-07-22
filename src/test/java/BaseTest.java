import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    static AndroidDriver<MobileElement> driver;


    @BeforeTest
    public void setUp() throws InterruptedException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app/Android");
        File app = new File(appDir, "mavenDebug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "NotUsed");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.medicom.maven.debug");
        capabilities.setCapability("appActivity", "com.medicom.maven.activity.StartActivity");
        capabilities.setCapability("newCommandTimeout", "60");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @AfterTest

    public void tearDown () {
        driver.closeApp();
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

