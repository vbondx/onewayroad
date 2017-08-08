import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EmptyFavoriteProductsPage extends BasePage {
    public EmptyFavoriteProductsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "buttonFavorites")
    private MobileElement catalogButton;

    public CategoriesPage goToCategories() {
        catalogButton.click();
        return new CategoriesPage(driver);
    }
}
