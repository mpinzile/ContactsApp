import java.util.Scanner;

/**
 * A simple Contacts App that allows users to manage their contacts.
 */
public class ContactsApp {
    public static void main(String[] args) {
        boolean run = true;
        Phonebook phonebook = new Phonebook();
        Scanner input = new Scanner(System.in);
        System.out.println("Contacts App");

        while (run) {
            printMenu();
            String choice = input.nextLine();
            switch (choice) {
                case MenuOptions.ADD_CONTACT -> {
                    System.out.println("Enter contact name:");
                    String name = input.nextLine();
                    System.out.println("Enter contact phone number:");
                    String phone = input.nextLine();
                    phonebook.addContact(phone, name);
                }
                case MenuOptions.DELETE_CONTACT -> {
                    System.out.println("Enter contact phone number to be deleted:");
                    String phoneToDelete = input.nextLine();
                    phonebook.deleteContact(phoneToDelete);
                }
                case MenuOptions.VIEW_CONTACTS -> phonebook.viewPhonebook();
                case MenuOptions.EDIT_CONTACT -> {
                    System.out.println("Enter contact phone number to update:");
                    String phoneToUpdate = input.nextLine();
                    System.out.println("Enter new phone number:");
                    String newPhoneNumber = input.nextLine();
                    phonebook.updateContact(phoneToUpdate, newPhoneNumber);
                }
                case MenuOptions.EXIT -> {
                    run = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice. Please choose again.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. View Contacts");
        System.out.println("4. Edit Contact");
        System.out.println("5. Exit");
        System.out.print("Please choose an option: ");
    }

}
