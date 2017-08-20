
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class CheckoutTests extends BaseTest {


    @Test

    public void createOrder() {
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
        checkoutPage.chooseDeliveryType(5);
        checkoutPage.scrollDown();
        checkoutPage.enterLastName("lastname");
        checkoutPage.chooseRegion(0);
        checkoutPage.enterAddress("address");
        checkoutPage.submit();
        OrderThankYouPage orderThankYouPage = new OrderThankYouPage(driver);
        try {
            log.info("Test passed");
            Assert.assertEquals(orderThankYouPage.textDisplayed(), "Менеджер компании noname свяжется с вами в ближайшее время");
        }   catch(AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(orderThankYouPage.textDisplayed(), "Менеджер компании noname свяжется с вами в ближайшее время");

        }
    }

    @Test

    public void swipeTest() {
        BasePage basePage = new BasePage(driver);
        basePage.search("testproduct123");
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.buyProduct(0);
        productsListPage.goToBasketPageFromCard(0);
        BasketPage basketPage = new BasketPage(driver);
        basketPage.goToCheckoutPage();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.scrollDown();
        checkoutPage.scrollUp();
    }
}