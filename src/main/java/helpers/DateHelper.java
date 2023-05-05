package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateHelper {
    private  static final DateFormat dateFormat = new SimpleDateFormat("d MMMMM yyyy", Locale.US);
    private static final Calendar calendar = Calendar.getInstance();
    public static String getDateFromNow(int amountOfDays) {
        calendar.add(Calendar.DATE, amountOfDays);
        return dateFormat.format(calendar.getTime());
    }
}
