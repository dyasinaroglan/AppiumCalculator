package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service;  //appium'u otomatik olarak başlatacak olan servis

    public static AppiumDriver getDriver(Device device, App app) {
        driver = new AndroidDriver<>(service.getUrl(), capabilities(device, app));
        return driver;
    }


    public static void runAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams(); //appium'un loglarını temizleme işlemi

        service.start();
    }
    public static void stopAppium(){
        service.stop();
    }
    //Desired Capabilities --> JSON nesnesinde kodlanmış key ve value değerleridir.
    private static DesiredCapabilities capabilities(Device device, App app){ //istenen uygulama bilgilerini set eden method

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);//version: Android sisteminin versiyonu 11 ve 12 vardır. sürüm
        capabilities.setCapability("appium:deviceName", device.deviceName);//Android sisteminin adı P30 Lite veya samsung A33 gibi.
        capabilities.setCapability("platformName", device.platformName);//mobil işlemci-->Android, IOS, Windows, Mac

        capabilities.setCapability("appium:app", app.appPackage); //çalıştırmak, test etmek istediğimiz Android uygulamasının package adresi
        capabilities.setCapability("appium:appActivity", app.appActivity); //uygulamada başlatmak istediğimiz Android etkinliğinin adı

        return capabilities;
    }
}
