import java.util.Scanner;

class Contacts {
    String firstName = "Go";
    String lastName = "Digit";
    String address = "visakhapatnam";
    String city = "hyderabad";
    String state = "AndhraPradesh";
    String email = "sathwika@gmail.com";
    int pincode = 530027;
    int number = 00000000;

    public void updateContactInfo(String newAddress, String newCity, String newState, String newEmail) {
        this.address = newAddress;
        this.city = newCity;
        this.state = newState;
        this.email = newEmail;
    }
}

public class AddressBook {
    public static void main(String[] args) {
        Contacts contact = new Contacts();

        System.out.println("Welcome to Address Book! Enter the person's contact name:");
        Scanner sc = new Scanner(System.in);
        String contactName = sc.nextLine();

        if (contact.firstName.equalsIgnoreCase(contactName)) {
            System.out.print("Enter new address: ");
            String newAddress = sc.nextLine();
            System.out.print("Enter new city: ");
            String newCity = sc.nextLine();
            System.out.print("Enter new state: ");
            String newState = sc.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = sc.nextLine();

            contact.updateContactInfo(newAddress, newCity, newState, newEmail);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found. Please check the name.");
        }
    }
}
