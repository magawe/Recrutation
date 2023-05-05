package helpers;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {
    private static final ThreadLocal<WebDriver> webDriverThread = new ThreadLocal<>();
    private static final ChromeOptions chromeOptions = new ChromeOptions();
    public static WebDriver webDriver;
    public static WebDriver getWebDriver() {
        chromeOptions.addArguments("--start-maximized");

        if (webDriverThread.get() == null) {
            webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

            webDriverThread.set(webDriver);
        }
        return webDriverThread.get();
    }
    public void quitWebDriver(WebDriver driver) {
        driver.quit();
        webDriverThread.remove();
    }
}
