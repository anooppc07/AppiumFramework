package dp.appiumjava.screens;

import com.applitools.eyes.appium.Eyes;
import dp.appiumjava.capabilities.DriverFactoryManager;
import dp.appiumjava.screens.base.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ActivityFeed_Screen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Julie- Anna\")")
    private MobileElement lnk_ActivityFeed;


    public void click_Login() {
        this.lnk_ActivityFeed.click();
    }

    public void  waitForActivityFeed(){
        waitForVisibilityOfElement(this.lnk_ActivityFeed);
    }

    public void verifyImageLoad(){
        Eyes eyes = new Eyes();
        eyes.setApiKey("Uo9x28agunjUbAae4VBoyoAPvF93t4nW8Kn8T4J8WZY110");
//        eyes.setForceFullPageScreenshot(true);
        // Start the test.
        eyes.open(DriverFactoryManager.
                getDriver(), "Activity Feed-image", "My first Appium native Java test!");

        // Visual validation.
        eyes.checkWindow("Activity Feed-image-Julia Ann");

        // End the test.
        eyes.close();
    }

    public void Click_ActivityFeed_DtlView(){
        this.lnk_ActivityFeed.click();
        waitForActivityFeed();
    }
}
