package enums;

public enum DatePickers {
    CheckIn(1),
    CheckOut(2);
    public final int which;
    DatePickers(int which) {
        this.which = which;
    }
}
