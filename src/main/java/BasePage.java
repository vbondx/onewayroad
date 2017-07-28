import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by v.bondarenko on 24.07.17.
 */
public class BasePage {

    AppiumDriver<MobileElement> driver;
    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @AndroidFindBy(id = "top_item")
    private MobileElement bottomTop;

    @AndroidFindBy (id = "category_item")
    private MobileElement bottomCategory;

    @AndroidFindBy (id = "favorite_item")
    private MobileElement bottomFavorite;

    @AndroidFindBy (id = "profile_item")
    private MobileElement bottomProfile;

    @AndroidFindBy (id = "searchViewStub")
    private MobileElement headerSearchField;

    @AndroidFindBy (id = "action_basket")
    private MobileElement cartIcon;


    public UnAuthProfilePage goToUnAuthProfilePage() {
        bottomProfile.click();
        return new UnAuthProfilePage(driver);
    }

    public ProfilePage goToProfilePage() {
        bottomProfile.click();
        return new ProfilePage(driver);
    }

    public EmptyFavoriteProductsPage goToEmptyFavoriteProductsPage(){
        bottomFavorite.click();
        return new EmptyFavoriteProductsPage(driver);
    }

    public FavoriteProductsPage goToFavoriteProductsPage(){
        bottomFavorite.click();
        return new FavoriteProductsPage(driver);
    }

    public CategoriesPage goToCategoriesPage(){
        bottomProfile.click();
        return new CategoriesPage(driver);
    }

    public ProductListPage search(String search_value){
        headerSearchField.sendKeys(search_value);
        return new ProductListPage(driver);
    }

    public ProductListPage searchWithSuggest(String serach_value) {
        headerSearchField.sendKeys(serach_value);
        return new ProductListPage(driver);                                 //FIXME: ADD THIS SEARCH METHOD
    }

    public BasketPage goToBasket() {
        cartIcon.click();
        return new BasketPage(driver);
    }
}