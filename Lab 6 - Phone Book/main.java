import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPhone Book Menu");
            System.out.println("1. Add Contact");
            System.out.println("2. Find Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("First Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lName = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();
                    addressBook.addContact(new Contact(fName, lName, address, phone));
                    break;

                case "2":
                    System.out.print("Enter full name to find: ");
                    String nameToFind = scanner.nextLine();
                    Contact found = addressBook.findContact(nameToFind);
                    System.out.println(found != null ? found : "Contact not found.");
                    break;

                case "3":
                    System.out.print("Enter full name to edit: ");
                    String nameToEdit = scanner.nextLine();
                    System.out.print("New Address: ");
                    String newAddr = scanner.nextLine();
                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();
                    boolean edited = addressBook.editContact(nameToEdit, newAddr, newPhone);
                    System.out.println(edited ? "Contact updated." : "Contact not found.");
                    break;

                case "4":
                    System.out.print("Enter full name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    boolean deleted = addressBook.deleteContact(nameToDelete);
                    System.out.println(deleted ? "Contact deleted." : "Contact not found.");
                    break;

                case "5":
                    addressBook.displayAllContacts();
                    break;

                case "6":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
