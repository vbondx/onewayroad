import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class OrderThankYouPage extends BasePage {
    public OrderThankYouPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "tvText")
    private MobileElement thankYouPageText;

    public String thankYouPageTextDisplayed() {
        String actualText = thankYouPageText.getText();
        return actualText;
    }

    public boolean textDisplayed() {
        String expectedText = "Менеджер компании noname свяжется с вами в ближайшее время";
        String actualText = thankYouPageText.getText();
        boolean text = actualText.equals(expectedText);
        return text;
    }
}
