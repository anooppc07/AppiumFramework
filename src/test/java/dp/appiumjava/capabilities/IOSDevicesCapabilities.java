package dp.appiumjava.capabilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public enum IOSDevicesCapabilities {

    IPHONE_8("resources/capabilities/iphone-8-dev.json"),
    IPHONE_8Plus("resources/capabilities/iphone-8Plus.json");

    private String path;

    IOSDevicesCapabilities(String path) {
        this.path = path;
    }

    public DesiredCapabilities getIOSCapabilitiesFromPlataform() {
        DesiredCapabilities iosCapabilities =  Load_capabilities.pathToDesiredCapabilitites(this.path);
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "anoop.pc");
        sauceOptions.setCapability("accessKey", "a0063fb8-25bf-4680-bf54-3b6dab9086d2");
        iosCapabilities.setCapability("sauce:options", sauceOptions);
//         iosCapabilities.setCapability("app", new File("resources/apps/TestApp.app").getAbsolutePath());
        return iosCapabilities;
    }

    public static void showAvaliableIphoneDevices() {
        System.out.println("======= IOS DEVICES ====== ");
        for (IOSDevicesCapabilities iosDevicesCapabilities : IOSDevicesCapabilities.values()) {
            System.out.println(iosDevicesCapabilities.name());
        }
    }
}
