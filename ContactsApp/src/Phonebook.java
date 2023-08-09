import java.util.HashMap;

/**
 * A Phonebook class that manages contacts using a HashMap.
 */
public class Phonebook {
    private HashMap<String, String> phonebook;

    /**
     * Constructs a new Phonebook.
     */
    public Phonebook() {
        phonebook = new HashMap<>();
    }

    private boolean numberExists(String number) {
        return phonebook.containsKey(number);
    }

    /**
     * Adds a new contact to the phonebook.
     *
     * @param number The phone number of the contact.
     * @param name   The name of the contact.
     */
    public void addContact(String number, String name) {
        if (numberExists(number)) {
            System.out.println("Number " + number + " already saved.");
        } else {
            phonebook.put(number, name);
            System.out.println("Contact '" + name + "' successfully saved.");
        }
    }

    /**
     * Deletes a contact from the phonebook.
     *
     * @param number The phone number of the contact to be deleted.
     */
    public void deleteContact(String number) {
        if (numberExists(number)) {
            phonebook.remove(number);
            System.out.println("Contact with number " + number + " successfully removed.");
        } else {
            System.out.println("Contact with number " + number + " not found.");
        }
    }

    /**
     * Updates the phone number of a contact in the phonebook.
     *
     * @param number     The current phone number of the contact.
     * @param newNumber  The new phone number to be updated.
     */
    public void updateContact(String number, String newNumber) {
        if (numberExists(number)) {
            String name = phonebook.get(number);
            if (numberExists(newNumber)) {
                System.out.println("New number already exists.");
            } else {
                phonebook.remove(number);
                addContact(newNumber, name);
                System.out.println("Contact updated.");
            }
        } else {
            System.out.println("Contact with number " + number + " not found.");
        }
    }

    /**
     * Displays the contents of the phonebook.
     */
    public void viewPhonebook() {
        System.out.println("Phonebook:");
        phonebook.forEach((number, name) -> System.out.println(name + ": " + number));
    }
}
