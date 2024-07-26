class Contacts {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    int pincode;
    int number;

    public Contacts(String first_name, String last_name, String address, String city, String state, String email, int pincode, int number) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.pincode = pincode;
        this.number = number;
    }
}

public class AddressBook {
    private Contacts[] contacts;
    private int numContacts;

    public AddressBook() {
        this.contacts = new Contacts[100]; // Adjust the size as needed
        this.numContacts = 0;
    }

    public void addContact(Contacts contact) {
        if (numContacts < contacts.length) {
            contacts[numContacts] = contact;
            numContacts++;
        } else {
            System.out.println("Address book is full. Cannot add more contacts.");
        }
    }

    public void displayContacts() {
        for (int i = 0; i < numContacts; i++) {
            Contacts contact = contacts[i];
            System.out.println("Name: " + contact.firstName + " " + contact.lastName);
            System.out.println("Address: " + contact.address + ", " + contact.city + ", " + contact.state + " - " + contact.pincode);
            System.out.println("Email: " + contact.email);
            System.out.println("Phone Number: " + contact.number);
            System.out.println();
        }
    }

    public void editContact(String first_name, String last_name, Contacts new_contact) {
        for (int i = 0; i < numContacts; i++) {
            Contacts contact = contacts[i];
            if (contact.firstName.equals(first_name) && contact.lastName.equals(last_name)) {
                contacts[i] = new_contact;
                System.out.println("Contact for " + first_name + " " + last_name + " has been updated.");
                return;
            }
        }
        System.out.println("Contact for " + first_name + " " + last_name + " not found.");
    }

    public void deleteContact(String first_name, String last_name) {
        for (int i = 0; i < numContacts; i++) {
            Contacts contact = contacts[i];
            if (contact.firstName.equals(first_name) && contact.lastName.equals(last_name)) {
                // Shift remaining contacts to fill the gap
                for (int j = i; j < numContacts - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                numContacts--;
                System.out.println("Contact for " + first_name + " " + last_name + " has been deleted.");
                return;
            }
        }
        System.out.println("Contact for " + first_name + " " + last_name + " not found.");
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        // Create a new contact
        Contacts newContact = new Contacts(
                "John",
                "Doe",
                "123 Main St",
                "Anytown",
                "California",
                "john.doe@example.com",
                12345,
                1234567890
        );
        addressBook.addContact(newContact);
        addressBook.displayContacts();

        // Edit an existing contact
        Contacts updatedContact = new Contacts(
                "John",
                "Doe",
                "456 Elm St",
                "Newtown",
                "California",
                "john.doe@example.com",
                54321,
                111111
        );
        addressBook.editContact("John", "Doe", updatedContact);
        addressBook.displayContacts();

        // Delete a contact
        addressBook.deleteContact("John", "Doe");
        addressBook.displayContacts();
    }
}
