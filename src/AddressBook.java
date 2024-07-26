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
    }
}
