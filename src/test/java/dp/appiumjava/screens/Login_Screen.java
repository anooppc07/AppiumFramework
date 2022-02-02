package dp.appiumjava.screens;

import com.applitools.eyes.appium.Eyes;
import dp.appiumjava.capabilities.DriverFactoryManager;
import dp.appiumjava.screens.base.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static dp.appiumjava.capabilities.DriverFactoryManager.getDriver;

public class Login_Screen extends BaseScreen {


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign In\").className(\"android.widget.TextView\")")
    @iOSXCUITFindBy(xpath="//*[@label='Sign In']")
    private MobileElement btn_Login;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue with Email\").className(\"android.widget.TextView\")")
    @iOSXCUITFindBy(xpath="//*[@label='Continue with Email']")
    private MobileElement lnk_Continue_Email;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"okta-signin-username\")")
    @iOSXCUITFindBy(xpath="//*[contains(@value,'Email')]")
    private MobileElement txt_UserName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"okta-signin-password\")")
    @iOSXCUITFindBy(xpath="//*[contains(@value,'Password')]")
    private MobileElement txt_Password;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"okta-signin-submit\")")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@label,'Sign In')]")
    private MobileElement btn_Submit;


    public void click_Login() {
        waitForVisibilityOfElement(this.btn_Login);
//        Eyes eyes = new Eyes();
//        eyes.setApiKey("Uo9x28agunjUbAae4VBoyoAPvF93t4nW8Kn8T4J8WZY110");
//        eyes.setForceFullPageScreenshot(true);
//        // Start the test.
//        eyes.open(DriverFactoryManager.
//                getDriver(), "Contacts!", "My first Appium native Java test!");
//
//        // Visual validation.
//        eyes.checkWindow("Contact list!");
//
//        // End the test.
//        eyes.close();
        this.btn_Login.click();
    }

    public void setCreds_And_SignIn() throws InterruptedException {

        waitForVisibilityOfElement(this.txt_UserName);

        this.txt_UserName.click();
        this.txt_UserName.sendKeys("pygavymiq@getairmail.com");
//        ((AndroidDriver) getDriver()).getKeyboard().pressKey("pygavymiq@getairmail.com");
        this.txt_Password.click();
//        ((AndroidDriver) getDriver()).getKeyboard().pressKey("!Password1");
        this.txt_Password.sendKeys("!Password1");
//        ((IOSDriver) getDriver()).getKeyboard().pressKey("!Password1");
//        this.txt_UserName.getKeyBoard().sendKeys("pygavymiq@getairmail.com");
//        this.txt_Password.sendKeys("!Password1");

    }

    public void click_Continue_Email() {
        this.lnk_Continue_Email.click();
    }

    public void click_Submit() {
        this.btn_Submit.click();
    }



}
