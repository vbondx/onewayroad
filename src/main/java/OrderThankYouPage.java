import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderThankYouPage extends BasePage {
    public OrderThankYouPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy (id = "tvText")
    private MobileElement thankYouPageText;

    public String thankYouPageTextDisplayed() {
        String actualText = thankYouPageText.getText();
        return actualText;
    }
}
