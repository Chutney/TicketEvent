import java.util.GregorianCalendar;

public interface Ticket extends Comparable<Ticket> {
    double getPrice();

    int getID();

    GregorianCalendar getDateOfPurchase();

    @Override
    default int compareTo(Ticket o) {
        return Integer.compare(this.getID(),o.getID());
    }
}
