import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

public class RecoveryPasswordNextPage extends BasePage {

    public RecoveryPasswordNextPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Мы отправили инструкцию']")
    private MobileElement instruction;

    @AndroidFindBy (id = "btnCheckMail")
    private MobileElement checkMailButton;

    public boolean instructionTextDisplayed() {
        boolean instructionText = instruction.isDisplayed();
        return instructionText;
    }

    public GoogleMailPage goToMail() {
        checkMailButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new GoogleMailPage(driver);
    }
}
