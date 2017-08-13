import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test

    public void createOrder() {
      BasePage basePage = new BasePage(driver);
      basePage.goToBasket();
      BasketPage basketPage = new BasketPage(driver);
      basketPage.goToCheckoutPage();
      CheckoutPage checkoutPage = new CheckoutPage(driver);
    }

    @Test

    public void create() {
        BasePage basePage = new BasePage(driver);
        basePage.search("Testtesttest123");
    }


}
