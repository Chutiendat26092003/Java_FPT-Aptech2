package Task03ContactList;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import ListStudentsManagerDetail.Student;

import java.util.Scanner;

public class TestContact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContactList contactList = new ContactList();

        int selection;
        System.out.println("Starting phone...\n");
        do {
            System.out.println("Available actions:\n press");
            System.out.println(
                    "0 - to shutdown\n"
                  + "1 - to print contacts\n"
                  + "2 - to add a new contact\n"
                  + "3 - to update existing contact\n"
                  + "4 - to remove an existing contact\n"
                  + "5 - query if an existing contact exists\n"
                  + "6 - to print a list of available actions.\n"
            );
            System.out.println("Choose your action: \n");

            selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1:
                    contactList.printList();
                    break;

                case 2:
                    System.out.println("Enter new contact name: "); String name1 = sc.nextLine();
                    System.out.println("Enter phone number: "); String phone1 = sc.nextLine();
                    Contact contact1 = new Contact(name1, phone1);
                    contactList.addContact(contact1);
                    break;

                case 3:
                    System.out.println("Enter existing contact name: "); String name2 = sc.nextLine();
                    Contact contact2 = new Contact(name2);

                    System.out.println("Enter new contact name: "); String name3 = sc.nextLine();
                    System.out.println("Enter new phone number: "); String phone3 = sc.nextLine();
                    Contact contact3 = new Contact(name3, phone3);

                    contactList.updateContact(contact2, contact3);
                    break;

                case 4:
                    System.out.println("Enter existing contact name: "); String name4 = sc.nextLine();
                    Contact contact4 = new Contact(name4);
                    contactList.removeContact(contact4);
                    break;

                case 5:
                    System.out.println("Enter existing contact name: "); String name5 = sc.nextLine();
                    contactList.searchContact(name5);
                    break;

                case 6:
                    System.out.println("Available actions:\n press");
                    System.out.println(
                                      "0 - to shutdown\n"
                                    + "1 - to print contacts\n"
                                    + "2 - to add a new contact\n"
                                    + "3 - to update existing contact\n"
                                    + "4 - to remove an existing contact\n"
                                    + "5 - query if an existing contact exists\n"
                                    + "6 - to print a list of available actions.\n"
                    );
                    System.out.println("Choose your action: \n");
                    break;
            }

        } while (selection != 0);{
            System.out.println("End!!");
        }

    }
}
