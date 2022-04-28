package phonebook;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dang Kim Thi
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList("0985188655");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    contactList.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
//                    updateContact();
                    break;

                case 4:
//                    removeContact();
                    break;

                case 5:
//                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n"
                + "1  - to print contacts\n"
                + "2  - to add a new contact\n"
                + "3  - to update existing an existing contact\n"
                + "4  - to remove an existing contact\n"
                + "5  - query if an existing contact exists\n"
                + "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

        private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (contactList.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

}
