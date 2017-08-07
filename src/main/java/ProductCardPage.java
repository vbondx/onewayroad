import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by v.bondarenko on 27.07.17.
 */
public class ProductCardPage extends BasePage {                         //FIXME:NEED TO DEVELOP TESTS WITH NON-ACTUAL PRICES, DISCOUNTS ETC.
    public ProductCardPage(AppiumDriver<MobileElement> driver) {        //FIXME: ADD TEST TO ENABLED/DISABLED FAV
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private MobileElement backButton;

    @AndroidFindBy (id = "call_layout")
    private MobileElement callButton;

    @AndroidFindBy (id = "buy_layout")
    private MobileElement buyButton;

    @AndroidFindBy (id = "protect_block")
    private MobileElement protectBlock;

    @AndroidFindBy (id = "menu_item_share")
    private MobileElement shareIcon;

    @AndroidFindBy (id = "action_add_to_favorite")
    private MobileElement favoriteIcon;

    public void buyProduct() {
        buyButton.click();
    }

    public BasketPage goToBasketPage(){
        buyButton.click();
        return new BasketPage(driver);
    }

    public CompanyPhonesPopUp openCompanyPhonesPopUp() {
        callButton.click();
        return new CompanyPhonesPopUp(driver);
    }
}
