package dp.appiumjava.capabilities;

import java.net.MalformedURLException;
import java.net.URL;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactoryManager {

    private static AppiumDriver<?> Driver;
    private static AppiumDriverLocalService service;


    public static AppiumDriver<?> startDriverByMavenParameter(String mavenEnvironment) {

        if (Driver == null) {

            try {
                URL saucelabUrl= new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
                if (mavenEnvironment.contains("ANDROID")) {
                    Driver = new AndroidDriver<>(saucelabUrl, AndroidDevicesCapabilities.valueOf(mavenEnvironment).getAndroidCapabilitiesFromPlataform());
                } else if (mavenEnvironment.contains("IPHONE")) {
                    Driver = new IOSDriver<>(saucelabUrl, IOSDevicesCapabilities.valueOf(mavenEnvironment).getIOSCapabilitiesFromPlataform());
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Please check the arguements");
                AndroidDevicesCapabilities.showAvaliableAndroidDevices();
                IOSDevicesCapabilities.showAvaliableIphoneDevices();
                System.exit(1);
            } catch (UnreachableBrowserException e) {
                System.out.println(" Please start appium server, use appium in command line. ====");
                System.exit(1);
            } catch (MalformedURLException e) {
                System.out.println("Please check the URL");
                System.exit(1);
            }
        }

        return Driver;
    }

    public static AppiumDriver<?> getDriver() {
        return Driver;
    }

    public static void reLaunchApp() {
        if (Driver != null) {
            Driver.launchApp();
        }
    }

    public static void quitDriver() {
        if (Driver != null) {
            Driver.quit();
        }
    }

    public static String getPageHierarchy() {
        return Driver.getPageSource();
    }


}

