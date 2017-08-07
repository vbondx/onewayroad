import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created by v.bondarenko on 24.07.17.
 */
public class MainPage extends BasePage {


    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "ll")
    private MobileElement cardMenu;

    List<MobileElement> cardElementsList = cardMenu.findElementsById("card_view");

    public ProductsListPage goToMensJackets() {
        cardElementsList.get(0).click();
        return new ProductsListPage(driver);
    }

}
