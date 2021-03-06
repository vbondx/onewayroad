import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsListPage extends BasePage {
    public ProductsListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "recycle_viewSearch")
    private MobileElement viewSearch;

    @AndroidFindBy (id = "action_basket")
    private MobileElement basketIcon;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='КУПИТЬ']")
    private MobileElement buyButton;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='В КОРЗИНУ']")
    private MobileElement buyButtonInBasket;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='ПОЗВОНИТЬ']")
    private MobileElement buyButtonCall;

    List<MobileElement> itemElementsList = viewSearch.findElementsById("cvListing");

    public ProductCardPage goToProductCardPage(int i) {
        itemElementsList.get(i).findElementById("llItemListing").click();
        return new ProductCardPage(driver);
    }

    public BasketPage goToBasketPage() {
        log.info("Click on basket icon");
        basketIcon.click();
        return new BasketPage(driver);
    }

    public void buyProduct(int i) {
        log.info("Click on buy button in product card");
        itemElementsList.get(i).findElementByXPath("//android.widget.TextView[@text='КУПИТЬ']").click();
    }

    public BasketPage goToBasketPageFromCard(int i) {
        log.info("Click on basket button in product card");
        itemElementsList.get(i).findElementByXPath("//android.widget.TextView[@text='В КОРЗИНУ']").click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new BasketPage(driver);
    }
}
