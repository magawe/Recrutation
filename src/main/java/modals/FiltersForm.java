package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static helpers.WebActionHelper.*;
import static helpers.WebDriverHelper.webDriver;

public class FiltersForm extends LoadableComponent<FiltersForm> {
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded()  {
        if(!isElementVisible(webDriver, By.cssSelector(".sc-eHEENL.eTyCag"))) {
            throw new Error("Modal filters form is not visible");
        }
    }
    public FiltersForm setMinAmountOfRooms(){
        selectElement(webDriver, By.cssSelector("button.sc-fWWYYk.sc-gzcbmu.bZTTYU.fKwyEY"), 1);
        selectElement(webDriver, By.cssSelector("button.sc-fWWYYk.sc-fIxmyt.bZTTYU.cnkbFD"), 1);
        selectElement(webDriver, By.cssSelector("button.sc-fWWYYk.sc-fIxmyt.bZTTYU.cnkbFD"), 1);
        return this;
    }
    public FiltersForm setAmountOfBeds(int amount){
        for (int i = 0; i < amount; i++){
            selectElement(webDriver, By.cssSelector("button.sc-fWWYYk.sc-gzcbmu.bZTTYU.fKwyEY"), 0);
        }
        return this;
    }
    public FiltersForm setPriceFrom(String amount){
        setInputText(webDriver, By.cssSelector("input[placeholder='From']"), amount);
        return this;
    }
    public FiltersForm setPriceTo(String amount){
        setInputText(webDriver, By.cssSelector("input[placeholder='To']"), amount);
        return this;
    }
    public String getPriceFrom(){
        return getInputValue(webDriver, By.cssSelector("input[placeholder='From']"));
    }
    public String getPriceTo(){
        return getInputValue(webDriver, By.cssSelector("input[placeholder='To']"));
    }
    public String getAmountOfBeds(){
           return getElementInnerText(webDriver, By.cssSelector("span.sc-gVFcvn.gnLtVL"), 0);
    }
    public String getAmountOfRooms(){
        return getElementInnerText(webDriver, By.cssSelector("span.sc-gVFcvn.gnLtVL"), 1);
    }
    public FiltersForm selectAllAmenities(){
        selectCheckBoxes(webDriver, By.cssSelector("input.sc-cbeScs.edEwoZ"));
        return this;
    }
    public int getSelectedAmenities(){
        return getSelectedCheckBoxes(webDriver, By.cssSelector("input.sc-cbeScs.edEwoZ"));
    }
    public FiltersForm clickClearAll(){
        selectElement(webDriver, By.xpath("//b[text()='Clear all']"),0);
        return this;
    }
}
