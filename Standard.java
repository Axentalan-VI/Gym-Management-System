import java.time.LocalDate;

public class Standard extends Membership {

    private int months;
    private LocalDate startingDate;
    private LocalDate expiryDate;

    public Standard(String type, int months) {
        super(type);
        setMonths(months);
        setStartingDate(LocalDate.now());
        setExpiryDate(startingDate.plusMonths(months));

    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    @Override
    public String toString() {

        return "Membership : " + getMembership_ID() + "\nType : " + getType() + "\nStarting Date : " + getStartingDate()
                + "\nExpiry Date : " + getExpiryDate();
    }

}
