import java.util.*;

public class TicketBeforeDoor implements Ticket {
    private final double price;
    private final double base_price = 120;
    private int id;
    private GregorianCalendar dateOfPurchase;
    private GregorianCalendar dateOfEvent;
    private String eventName;

    public TicketBeforeDoor(int id, GregorianCalendar dateOfEvent, String eventName) {
        this.eventName = eventName;
        this.id = id;
        this.dateOfPurchase = new GregorianCalendar(TimeZone.getTimeZone("GMT+2"));
        this.dateOfEvent = dateOfEvent;
        if(dateOfPurchase.getTimeInMillis()+Math.pow(8.64,8) >= this.dateOfEvent.getTimeInMillis()) {
            this.price = base_price;
            System.out.println("I ran base price");
        } else {
            this.price = base_price*0.85;
            System.out.println("I ran reduced base price");
        }
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
                "################",
                "Event: "+eventName,
                "Date: "+dateOfEvent.getTime(),
                "ID: "+id,
                "Price: "+price,
                "Ticket Type: Purchase before event",
                "Purchase date: "+dateOfPurchase.getTime(),
                "################"
        ));
    }
}
