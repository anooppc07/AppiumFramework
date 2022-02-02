package dp.appiumjava.screens.base;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import dp.appiumjava.capabilities.DriverFactoryManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BaseScreen extends MobileElement {
    FluentWait wait=new WebDriverWait(DriverFactoryManager.
            getDriver(),120).pollingEvery(Duration.ofMillis(200));

    public BaseScreen() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverFactoryManager.getDriver()), this);
    }

    protected void waitForInsvisibilityOfElement(WebElement el) {
        new WebDriverWait(DriverFactoryManager.getDriver(), 5)
                .until(ExpectedConditions.invisibilityOf(el));
    }


    protected void waitForVisibilityOfElement(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
    }


    public static void swipe() {
//        new TouchAction(DriverFactoryManager.getDriver()).press(300, 1000).waitAction().moveTo(300, 50).release().perform();
    }

    public static void swipeInvert() {
//        new TouchAction(DriverFactoryManager.getDriver()).press(300, 50).waitAction().moveTo(300, 1000).release().perform();
    }

}