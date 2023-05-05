package pages;
import static helpers.WebDriverHelper.webDriver;

import components.DatePicker;
import enums.DatePickers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage<SearchPage>{
    @FindBy(css = ".sc-giAqHp")
    private WebElement searchButton;
    @FindBy(css = ".sc-bXexck.iKXphs")
    private List<WebElement> datePickers;
    @Override
    public String getUrl() {
        return "";
    }

    @Override
    protected void isLoaded() throws Error {

    }
    public ResultsPage performSearch() {
        searchButton.click();
        return new ResultsPage().getPage();
    }
    public SearchPage setDateByInput(String date, DatePickers pickers){
        ((JavascriptExecutor) webDriver).executeScript(
                "var element=arguments[0]; element.innerHTML = '%s';".formatted(date), datePickers.get(pickers.which));
        return this;
    }
    public SearchPage setDateByCalendar(String date, DatePickers pickers){
        new DatePicker().get().setDateInPickers(date, pickers.which);
        return this;
    }
}
