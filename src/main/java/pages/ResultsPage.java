package pages;

import modals.FiltersForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BasePage<ResultsPage>{
    @FindBy(css = "button.sc-giAqHp.iyYKWx")
    private WebElement filtersButton;
    @Override
    public String getUrl() {
        return "";
    }

    @Override
    protected void isLoaded() throws Error {

    }
    public FiltersForm promptFiltersModal(){
        filtersButton.click();
        return new FiltersForm().get();
    }
}
