package dp.appiumjava.capabilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public enum AndroidDevicesCapabilities {


    ANDROID_OREO("resources/capabilities/android-oreo.json"),
    ANDROID_7("resources/capabilities/android-7.json");

    private String path;

    AndroidDevicesCapabilities(String path) {
        this.path = path;
    }

    public DesiredCapabilities getAndroidCapabilitiesFromPlataform() {
        DesiredCapabilities androidCapabilities = Load_capabilities.pathToDesiredCapabilitites(this.path);
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "");
        sauceOptions.setCapability("accessKey", "");
        androidCapabilities.setCapability("sauce:options", sauceOptions);
        //androidCapabilities.setCapability("app", new File("resources/apps/app-debug.apk").getAbsolutePath());
        return androidCapabilities;
    }

    public static void showAvaliableAndroidDevices() {
        System.out.println("======= ANDROID DEVICES ====== ");
        for (AndroidDevicesCapabilities androidDevicesCapabilities : AndroidDevicesCapabilities.values()) {
            System.out.println(androidDevicesCapabilities.name());
        }
    }
}
