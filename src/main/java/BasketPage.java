import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

public class BasketPage extends BasePage {
    public BasketPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "btnOrderInThisShop")
    private MobileElement buttonOrder;

    public CheckoutPage goToCheckoutPage() {
        buttonOrder.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new CheckoutPage(driver);
    }
}
