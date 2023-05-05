package components;

import static helpers.WebDriverHelper.webDriver;
import static helpers.WebActionHelper.selectElement;
import static helpers.WebActionHelper.isElementClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class DatePicker extends LoadableComponent<DatePicker> {
    @Override
    protected void load() {
    }
    @Override
    protected void isLoaded() {
        if(!isElementClickable(webDriver, By.cssSelector(".sc-fcmMJX.kTRHBf"))) {
            throw new Error("DataPickers is not loaded to be clicked");
        }
    }
    public void setDateInPickers(String date, int which){
        String day =  date.split(" ", 2)[0];
        String monthYear = date.split(" ", 2)[1];
        String daySelector = "//div[contains(text(),'%s')]/ancestor::div[@class='sc-jXcxbT eINlL']" +
                "//div[@class='sc-WZYut bJAXZb CalendarDay' and text() = '%s']";
        daySelector = String.format(daySelector, monthYear, day);
        selectElement(webDriver, By.cssSelector(".sc-GvhzO.kSqeJg"), which);
        selectElement(webDriver, By.xpath(daySelector), 0);
    }
}
