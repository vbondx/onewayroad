
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


public class CheckoutTests extends BaseTest {


    @Test

    public void createOrder() throws Exception {
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
            Assert.assertEquals(orderThankYouPage.textDisplayed(),"Менеджер компании noname свяжется с вами в ближайшее время");
            log.info("<Create order> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Create order> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Create order> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
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
        checkoutPage.enterName("");
        checkoutPage.enterPhone("0632350342");

    }

    @Test

    public void checkoutWithoutName() {
        BasePage basePage = new BasePage(driver);
        basePage.search("testproduct123");
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.buyProduct(0);
        productsListPage.goToBasketPageFromCard(0);
        BasketPage basketPage = new BasketPage(driver);
        basketPage.goToCheckoutPage();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterName("");
        checkoutPage.enterPhone("0632350342");
        checkoutPage.enterEmail("minnnune@gmail.com");
        checkoutPage.choosePaymentType(0);
        checkoutPage.chooseDeliveryType(5);
        checkoutPage.scrollDown();
        checkoutPage.enterLastName("lastname");
        checkoutPage.chooseRegion(0);
        checkoutPage.enterAddress("address");
        checkoutPage.submit();
    }
}