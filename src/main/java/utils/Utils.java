package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static AppiumDriver<?> openTo(Device device, App app) {
        Driver.runAppium();
        return Driver.getDriver(device, app);
    }
    public static void clickTo(By locator) {

    }
}

