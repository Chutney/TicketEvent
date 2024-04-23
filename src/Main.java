import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        Event myEvent = new Event("DJ ALLSTAR", 2024,6,20,18,30);

        System.out.println(myEvent.buyTicket());
        System.out.println(myEvent.buyTicket(new StudentID("Noah Van Wagenen","KEA",2026,4,30,18)));
        System.out.println(myEvent.getAllStudyCardID());
        System.out.println(myEvent.totalTicketsSold());
    }
}
