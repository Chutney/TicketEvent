import java.util.*;

public class TicketInDoor implements Ticket {
    private final double price;
    private String eventName;
    private int id;
    private GregorianCalendar dateOfPurchase;
    private GregorianCalendar dateOfEvent;

    public TicketInDoor(int id, GregorianCalendar dateOfEvent, String eventName) {
        this.eventName = eventName;
        this.id = id;
        this.price = 150;
        this.dateOfPurchase = new GregorianCalendar(TimeZone.getTimeZone("GMT+2"));
        this.dateOfEvent = dateOfEvent;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public GregorianCalendar getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String toString() {
        return String.join("\n", List.of(
                "Event: "+eventName,
                "Date: "+dateOfEvent.getTime(),
                "ID: "+id,
                "Price: "+price,
                "Ticket Type: Purchase in the door",
                "Purchase date: "+dateOfPurchase.getTime(),
                "################"
        ));
    }
}
