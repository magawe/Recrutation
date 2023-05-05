import static helpers.DateHelper.getDateFromNow;

import enums.DatePickers;
import modals.FiltersForm;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

public class FunctionalTests {
    private FiltersForm filtersForm;
    @BeforeClass
    public void goToFiltersModal(){
        String checkInDate = getDateFromNow(1);
        String checkOutDate = getDateFromNow(3);
        filtersForm =
        new SearchPage()
                .goToPage()
                .setDateByCalendar(checkInDate, DatePickers.CheckIn)
                .setDateByCalendar(checkOutDate, DatePickers.CheckOut)
                .performSearch()
                .promptFiltersModal();
    }

    @Test(priority=1)
    public void entryPriceFromTest() {
        String price =
        filtersForm
                .setPriceFrom("50")
                .getPriceFrom();
        Assert.assertEquals(price, "50");
    }
    @Test (priority=1)
    public void entryPriceToTest() {
        String price =
        filtersForm
                .setPriceTo("500")
                .getPriceTo();
        Assert.assertEquals(price, "500");
    }
    @Test (priority=1)
    public void bedsMaxValueTest() {
        String amountOfBeds =
        filtersForm
                .setAmountOfBeds(11)
                .getAmountOfBeds();
        Assert.assertEquals(amountOfBeds, "10");
    }
    @Test (priority=1)
    public void bedRoomsMinValueTest() {
        String amountOfRooms =
                filtersForm
                        .setMinAmountOfRooms()
                        .getAmountOfRooms();
        Assert.assertEquals(amountOfRooms, "0");
    }
    @Test (priority=2)
    public void amenitiesCheckboxesTest() {
        int selectedAmenities =
                filtersForm
                        .selectAllAmenities()
                        .getSelectedAmenities();
        Assert.assertEquals(selectedAmenities, 10);
    }
    @Test (priority=3)
    public void clearAllAmenitiesTest(){
        int selectedAmenities =
        filtersForm
                .clickClearAll()
                .getSelectedAmenities();
        Assert.assertEquals(selectedAmenities, 0);
    }
}

