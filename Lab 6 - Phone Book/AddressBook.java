import java.io.*;
import java.util.*;

public class AddressBook {
    private List<Contact> contacts;
    private final String FILE_NAME = "contacts.dat";

    public AddressBook() {
        contacts = new ArrayList<>();
        loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        Collections.sort(contacts);
        saveContacts();
    }

    public Contact findContact(String fullName) {
        int index = binarySearch(fullName);
        return index >= 0 ? contacts.get(index) : null;
    }

    public boolean editContact(String fullName, String newAddress, String newPhone) {
        Contact contact = findContact(fullName);
        if (contact != null) {
            contact.setAddress(newAddress);
            contact.setPhoneNumber(newPhone);
            saveContacts();
            return true;
        }
        return false;
    }

    public boolean deleteContact(String fullName) {
        int index = binarySearch(fullName);
        if (index >= 0) {
            contacts.remove(index);
            saveContacts();
            return true;
        }
        return false;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact + "\n------------------");
            }
        }
    }

    private int binarySearch(String fullName) {
        int low = 0, high = contacts.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Contact midContact = contacts.get(mid);
            int cmp = midContact.getFullName().compareToIgnoreCase(fullName);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private void saveContacts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Failed to save contacts.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadContacts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                contacts = (List<Contact>) in.readObject();
                Collections.sort(contacts);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to load contacts.");
            }
        }
    }
}
