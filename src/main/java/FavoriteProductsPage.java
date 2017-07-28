import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class FavoriteProductsPage extends BasePage {
    public FavoriteProductsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "recycle_viewFavorites")
    private MobileElement listOfFavorites;

    @AndroidFindBy (id = "action_search")
    private MobileElement standartSearch;


}


//FIXME: NEED TO DEVELOP TEST-CASES
