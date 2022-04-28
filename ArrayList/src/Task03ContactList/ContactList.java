package Task03ContactList;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/


import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contactArrayList;

    public ContactList(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    public  ContactList() {
        this.contactArrayList = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.contactArrayList.add(contact);
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        for (Contact contact : contactArrayList) {
            if(contact.getName().indexOf(oldContact.getName()) >= 0) {
                System.out.print(contact);
                contact.setName(newContact.getName());
                contact.setPhone(newContact.getPhone());
                System.out.print(" --> ");
                System.out.println(contact);
            }
        }
    }

    public void removeContact(Contact contact) {
        if (this.contactArrayList.contains(contact)) {
            this.contactArrayList.remove(contact);
            System.out.println("Ok!");
        } else {
            System.out.println("Error!\n");
        }
    }

    public void searchContact(String contactName) {
        for (Contact contact: contactArrayList) {
            if (contact.getName().indexOf(contactName) >= 0) {
                System.out.println(contact);
            } else {
                System.out.println("Not found");
            }
        }
    }

    public void printList() {
        for (Contact contact: contactArrayList) {
            System.out.println(contact);
        }
    }
}
