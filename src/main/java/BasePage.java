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
        log.info("Click on unauthorized profile page icon");
        bottomProfile.click();
        return new UnAuthProfilePage(driver);
    }

    public ProfilePage goToProfilePage() {
        log.info("Click on profile page icon");
        bottomProfile.click();
        return new ProfilePage(driver);
    }

    public EmptyFavoriteProductsPage goToEmptyFavoriteProductsPage() {
        log.info("Click on empty favorites icon");
        bottomFavorite.click();
        return new EmptyFavoriteProductsPage(driver);
    }

    public FavoriteProductsPage goToFavoriteProductsPage() {
        log.info("Click on favorites icon");
        bottomFavorite.click();
        return new FavoriteProductsPage(driver);
    }

    public CategoriesPage goToCategoriesPage() {
        log.info("Click on profile icon");
        bottomProfile.click();
        return new CategoriesPage(driver);
    }

    public ProductsListPage search(String search_value) {
        log.info("Search");
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
        log.info("Click on basket icon");
        cartIcon.click();
        return new BasketPage(driver);
    }

    //    public String getToastMessage() throws InterruptedException {
//
//        String filePath = System.getProperty("user.dir");
//        File file = new File(filePath, "/toastmessages");
//        sleep(2000l);
//        captureScreenshot(filePath + "/toastmessages");
//        String str = "";
//        BytePointer outText;
//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//
//        if (api.Init(".", "RUS") != 0) {
//            System.err.println("Could not initialize tesseract.");
//            System.exit(1);
//        }
//
//        lept.PIX image = pixRead(file+"/toastmessage1.png");
//        api.SetImage(image);
//
//        // Get OCR result
//        outText = api.GetUTF8Text();
//        str = outText.getString();
//        System.out.println("OCR output:\n" + str);
//
//        // Destroy used object and release memory
//        api.End();
//        outText.deallocate();
//        pixDestroy(image);
//        System.out.println(str);
//        return str;
//    }

//    public void captureScreenshot(String path) {
//        File scrFile = ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.FILE);
//        try {
//            String filePath=path+"/toastmessage1.png";
//            FileUtils.copyFile(scrFile,  new File(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
