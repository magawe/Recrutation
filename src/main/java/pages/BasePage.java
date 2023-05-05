package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static helpers.WebDriverHelper.getWebDriver;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    private static final String BASE_URL = "https://kamil-demo.alpinizm.uz/";

    @Override
    protected void load() {
        getWebDriver().get(BASE_URL + getUrl());
    }

    public T goToPage() {
        PageFactory.initElements(getWebDriver(), this);
        load();
        return get();
    }
    public T getPage() {
        PageFactory.initElements(getWebDriver(), this);
        return get();
    }
    public abstract String getUrl();
}
