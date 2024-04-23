import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Event {

    private String eventName;
    private GregorianCalendar dateOfEvent;
    private SoldTickets soldTickets;


    public Event(String eventName, int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        this.eventName = eventName;
        this.dateOfEvent = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, 0);
        soldTickets = new SoldTickets(eventName);
    }

    public String buyTicket(StudentID studID) {
        GregorianCalendar currentDate = new GregorianCalendar(TimeZone.getTimeZone("GMT+2"));
        int idToSet = soldTickets.getIDtoSet();
        Ticket generatedTicket;

        if(currentDate.before(dateOfEvent)) {
            if(studID != null) {
                if(currentDate.after(studID.getExpirationDate())) {
                    return "This studentID is expired!";
                } else {
                    generatedTicket = new TicketStudent(idToSet, dateOfEvent, studID, eventName);
                }
            } else {
                generatedTicket = new TicketBeforeDoor(idToSet, dateOfEvent, eventName);
            }
        } else {
            generatedTicket = new TicketInDoor(idToSet, dateOfEvent, eventName);
        }


        soldTickets.addTicket(generatedTicket);
        return generatedTicket.toString();

    }

    public String buyTicket() {
        return buyTicket(null);
    }

    public String totalTicketsSold() {
        return soldTickets.totalTicketsSold();
    }

    public String listOfSoldTickets() {
        return soldTickets.toString();
    }

    public String getAllStudyCardID() {
        return soldTickets.getAllStudyCardID();
    }


}
