package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebActionHelper {
    public static boolean isElementClickable(WebDriver webDriver, By by) {

        try
        {
            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (WebDriverException ex)
        {
            return false;
        }
        return true;
    }
    public static boolean isElementVisible(WebDriver webDriver, By by) {

        try
        {
            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (WebDriverException ex)
        {
            return false;
        }
        return true;
    }
    public static void selectElement(WebDriver webDriver, By by, int which) {
        List<WebElement> elements = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        elements.get(which).click();
    }
    public static String getElementInnerText(WebDriver webDriver, By by, int which) {
        List<WebElement> elements = webDriver.findElements(by);
        return elements.get(which).getAttribute("innerHTML");
    }
    public static void setInputText(WebDriver webDriver, By by, String text) {
        WebElement element = webDriver.findElement(by);
        element.sendKeys(text);
    }
    public static String getInputValue(WebDriver webDriver, By by) {
        WebElement element = webDriver.findElement(by);
        return element.getAttribute("value");
    }
    public static void selectCheckBoxes(WebDriver webDriver, By by) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);",
                webDriver.findElement(by));
        List<WebElement> elements = webDriver.findElements(by);
        for (WebElement checkbox: elements){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", checkbox);
        }
    }
    public static int getSelectedCheckBoxes(WebDriver webDriver, By by) {
        int selectedCheckboxes = 0;
        List<WebElement> elements = webDriver.findElements(by);
        for (WebElement checkbox : elements) {
            if (checkbox.isSelected()){
                selectedCheckboxes++;
            }
        }
        return selectedCheckboxes;
    }
}
