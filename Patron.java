/**
 * Name: Luis Augusto Monserratt Alvarado
 * Course: 202530 Software Development I CEN-3024C-31774
 * Date: May 16, 2025
 *
 * Class: Patron
 * Description: Represents a library patron, including personal information and fines.
 */
public class Patron {
    // Unique identifier for the patron
    private String id;
    // Full name of the patron
    private String name;
    // Address of the patron
    private String address;
    // Overdue fine owed by the patron
    private double overdueFine;

    /**
     * Constructor to initialize all attributes of a Patron.
     */
    public Patron(String id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }

    /**
     * Gets the ID of the patron.
     */
    public String getId() { return id; }

    /**
     * Gets the name of the patron.
     */
    public String getName() { return name; }

    /**
     * Gets the address of the patron.
     */
    public String getAddress() { return address; }

    /**
     * Gets the current overdue fine of the patron.
     */
    public double getOverdueFine() { return overdueFine; }

    /**
     * Updates the overdue fine amount for the patron.
     */
    public void setOverdueFine(double overdueFine) {
        this.overdueFine = overdueFine;
    }

    /**
     * Returns a readable summary of the patron's information.
     */
    @Override
    public String toString() {
        return id + " | " + name + " | " + address + " | Fine: $" + overdueFine;
    }
}
