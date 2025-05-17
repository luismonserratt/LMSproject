import java.util.Scanner;

/**
 * Name: Luis Augusto Monserratt Alvarado
 * Course: 202530 Software Development I CEN-3024C-31774
 * Date: May 16, 2025
 *
 * Class: LMSConsole
 * Description: Console application to interact with the Library system.
 */
public class LMSConsole {
    // Library object to manage patrons
    private Library library;
    // Scanner object for user input
    private Scanner scanner;

    /**
     * Constructor initializes the library and scanner.
     */
    public LMSConsole() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    /**
     * Main method - entry point of the application.
     */
    public static void main(String[] args) {
        LMSConsole console = new LMSConsole();
        console.handleUserInput();
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\nLibrary Management System Menu:");
        System.out.println("1. Add Patron from File");
        System.out.println("2. Add Patron Manually");
        System.out.println("3. Remove Patron");
        System.out.println("4. List All Patrons");
        System.out.println("5. Exit");
        System.out.print("Please enter your choice: ");
    }

    /**
     * Handles user input and calls corresponding Library methods.
     */
    private void handleUserInput() {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    library.addPatronFromFile(filePath);
                    System.out.println("Patrons loaded from file.");
                    break;

                case "2":
                    Patron newPatron = getNewPatronDetails();
                    library.addPatronManually(newPatron.getId(), newPatron.getName(),
                            newPatron.getAddress(), newPatron.getOverdueFine());
                    System.out.println("Patron added manually.");
                    break;

                case "3":
                    System.out.print("Enter Patron ID to remove: ");
                    String idToRemove = scanner.nextLine();
                    boolean removed = library.removePatron(idToRemove);
                    if (removed) {
                        System.out.println("Patron removed.");
                    } else {
                        System.out.println("Patron ID not found.");
                    }
                    break;

                case "4":
                    library.listAllPatrons();
                    break;

                case "5":
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to enter details for a new patron.
     * Returns a new Patron object.
     */
    private Patron getNewPatronDetails() {
        System.out.print("Enter Patron ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patron Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patron Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Overdue Fine amount: ");
        double fine = 0;
        try {
            fine = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, setting fine to 0.");
        }
        return new Patron(id, name, address, fine);
    }
}
