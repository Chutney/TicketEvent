import java.util.GregorianCalendar;

public class StudentID {
    private String name;
    private int id;
    private String institution;
    private GregorianCalendar expirationDate;

    public StudentID(String name, String institution, int year, int month, int dayOfMonth, int id) {
        this.name = name;
        this.institution = institution;
        this.id = id;
        expirationDate = new GregorianCalendar(year, month, dayOfMonth, 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public GregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    public int getId() {
        return id;
    }
}
