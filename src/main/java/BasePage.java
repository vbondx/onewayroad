import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import javafx.scene.input.KeyCode;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.security.Key;
import org.apache.log4j.Logger;


import static io.appium.java_client.android.AndroidKeyCode.*;


public class BasePage {

    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    Logger log = Logger.getLogger("rootLogger");


    @AndroidFindBy(id = "top_item")             //bottomNavi MA-
    private MobileElement bottomTop;

    @AndroidFindBy(id = "category_item")       //bottomNavi MA-
    private MobileElement bottomCategory;

    @AndroidFindBy(id = "favorite_item")       //bottomNavi MA-
    private MobileElement bottomFavorite;

    @AndroidFindBy(id = "profile_item")        //bottomNavi MA-
    private MobileElement bottomProfile;

    @AndroidFindBy(id = "searchViewStub")      //New Search Field MA-
    private MobileElement headerSearchField;

    @AndroidFindBy(id = "action_basket")
    private MobileElement cartIcon;


    public UnAuthProfilePage goToUnAuthProfilePage() {
        bottomProfile.click();
        return new UnAuthProfilePage(driver);
    }

    public ProfilePage goToProfilePage() {
        bottomProfile.click();
        return new ProfilePage(driver);
    }

    public EmptyFavoriteProductsPage goToEmptyFavoriteProductsPage() {
        bottomFavorite.click();
        return new EmptyFavoriteProductsPage(driver);
    }

    public FavoriteProductsPage goToFavoriteProductsPage() {
        bottomFavorite.click();
        return new FavoriteProductsPage(driver);
    }

    public CategoriesPage goToCategoriesPage() {
        bottomProfile.click();
        return new CategoriesPage(driver);
    }

    public ProductsListPage search(String search_value) {
        headerSearchField.click();
        driver.findElementById("search_view").sendKeys(search_value);        //FIXME: ENTER NOT WORKS WITH SEARCH
        ((AndroidDriver) driver).pressKeyCode(66);
        return new ProductsListPage(driver);
    }

    public ProductsListPage searchWithSuggest(String search_value) {
        headerSearchField.sendKeys(search_value);
        return new ProductsListPage(driver);                                 //FIXME: ADD THIS SEARCH METHOD
    }

    public BasketPage goToBasket() {
        cartIcon.click();
        return new BasketPage(driver);
    }
}
