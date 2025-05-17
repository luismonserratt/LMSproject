import java.io.*;
import java.util.*;

/**
 * Name: Luis Augusto Monserratt Alvarado
 * Course: 202530 Software Development I CEN-3024C-31774
 * Date: May 16, 2025
 *
 * Class: Library
 * Description: Manages a list of patrons. Allows adding, removing, and listing them.
 */
public class Library {
    // List to store all patrons in the library
    private List<Patron> patrons;

    /**
     * Constructor initializes the list of patrons.
     */
    public Library() {
        patrons = new ArrayList<>();
    }

    /**
     * Reads patron data from a CSV file and adds them to the list.
     * Each line must contain: id, name, address, overdueFine
     */
    public void addPatronFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 4) {
                    patrons.add(new Patron(
                            parts[0].trim(),     // ID
                            parts[1].trim(),     // Name
                            parts[2].trim(),     // Address
                            Double.parseDouble(parts[3].trim()) // Fine
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    /**
     * Adds a new patron manually with given data.
     */
    public void addPatronManually(String id, String name, String address, double overdueFine) {
        patrons.add(new Patron(id, name, address, overdueFine));
    }

    /**
     * Removes a patron by ID.
     * Returns true if the patron was found and removed.
     */
    public boolean removePatron(String id) {
        Patron p = findPatronById(id);
        return p != null && patrons.remove(p);
    }

    /**
     * Prints a list of all patrons.
     */
    public void listAllPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            patrons.forEach(System.out::println);
        }
    }

    /**
     * Searches for a patron by ID and returns the matching object.
     * Returns null if not found.
     */
    private Patron findPatronById(String id) {
        for (Patron p : patrons) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
