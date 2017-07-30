import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class GooglePlayCabinetAppPage extends SignInPage {
    public GooglePlayCabinetAppPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Кабинет продавца Prom.ua']")
    private MobileElement titleApp;

    public boolean cabinetAppDisplayed() {
        boolean cabinetAppText = titleApp.isDisplayed();
        return cabinetAppText;
    }
}
