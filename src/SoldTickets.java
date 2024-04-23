import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SoldTickets {

    private ArrayList<Ticket> soldTickets;
    String eventName;

    public SoldTickets(String eventName) {
        this.soldTickets = new ArrayList<>();
        this.eventName = eventName;
    }

    public void addTicket(Ticket ticket) {
        soldTickets.add(ticket);
    }

    public String totalTicketsSold() {
        int tcktStud = 0;
        int tcktBeforeDoor = 0;
        int tcktAfterDoor = 0;
        double totalPrice = 0;

        for (Ticket tckt : soldTickets) {
            if (tckt instanceof TicketInDoor) {
                tcktAfterDoor++;
            } else if(tckt instanceof TicketStudent) {
                tcktStud++;
            } else {
                tcktBeforeDoor++;
            }
            totalPrice += tckt.getPrice();
        }

        return String.join("\n",List.of(
                "Tickets sold before event: "+tcktBeforeDoor,
                "Tickets sold on event: "+tcktAfterDoor,
                "Student tickets sold: "+tcktStud,
                "Total price: "+totalPrice+"$"
        ));
    }

    public String toString() {
        soldTickets.sort(Comparator.naturalOrder());
        String[] toStringArray = new String[soldTickets.size()];

        for (int i = 0; i < toStringArray.length; i++) {
            toStringArray[i] = soldTickets.get(i).toString();
        }

        return String.join("\n",toStringArray);

    }

    public String getAllStudyCardID() {
        ArrayList<TicketStudent> tcktStudList = new ArrayList<>();
        for (Ticket tckt : soldTickets) {
            if(tckt instanceof TicketStudent studTckt) {
                tcktStudList.add(studTckt);
            }
        }

        if(tcktStudList.isEmpty()) {
            return "No student tickets purchased.";
        }

        tcktStudList.sort(Comparator.naturalOrder());
        String[] toStringArray = new String[tcktStudList.size()];


        for (int i = 0; i < tcktStudList.size(); i++) {
            toStringArray[i] = tcktStudList.get(i).toString();
        }

        return String.join("\n",toStringArray);
    }

    public int getIDtoSet() {
        return soldTickets.size()+1;
    }
}
