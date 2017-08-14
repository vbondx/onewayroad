import android.util.Log;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test

    public void create() {
        BasePage basePage = new BasePage(driver);
        basePage.search("testproduct123");
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.buyProduct(0);
        productsListPage.goToBasketPageFromCard(0);
        BasketPage basketPage = new BasketPage(driver);
        basketPage.goToCheckoutPage();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterName("username");
        checkoutPage.enterPhone("0632350342");
        checkoutPage.enterEmail("minnnune@gmail.com");
        checkoutPage.choosePaymentType(0);
        checkoutPage.chooseDeliveryType(0);
        checkoutPage.scrollToComments();
        checkoutPage.enterLastName("lastname");
        checkoutPage.chooseRegion(0);
        checkoutPage.enterAddress("address");
        checkoutPage.submit();
        OrderThankYouPage orderThankYouPage = new OrderThankYouPage(driver);
        if (orderThankYouPage.textDisplayed() == true) {
            Assert.assertTrue(orderThankYouPage.textDisplayed());
            System.out.println("Test passed");
        } else {
            Assert.assertTrue(orderThankYouPage.textDisplayed());
            System.out.println("Test failed. Please see your element's path in last method.");
        }


    }


}
