package stepDefs;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.Utils;

import java.util.List;
import static utils.Locators.*;
import static utils.Utils.openTo;

public class SumOfIntegers{

    AppiumDriver<?> driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Given("user on start page")
    public void userOnStartPage() {
        driver = openTo(Device.HUAWEI, App.CALCULATOR);
        wait = new WebDriverWait(driver, 20);
        // driver.resetApp();
        // driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        int max = list.size();
        int i = 1;
        for (Integer num : list) {
            if(i++ != max){
                clickTo(lButtonAdd);
            }
            clickTo(lButtonEquals);
        }

    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int arg0) {

    }
    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
