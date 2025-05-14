package contactManagementSystem;

import java.util.ArrayList;

public class ContactManager {

    private ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(Contact c) {
        contactList.add(c);
        System.out.println("Contact added successfully.");
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Contact c : contactList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:");
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void searchByNumber(String number) {
        boolean found = false;
        for (Contact c : contactList) {
            if (c.getPhoneNo().equalsIgnoreCase(number)) {
                System.out.println("Contact found:");
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteById(int id) {
        Contact toRemove = null;
        for (Contact c : contactList) {
            if (c.getId() == id) {
                toRemove = c;
                break;
            }
        }
        if (toRemove != null) {
            contactList.remove(toRemove);
            System.out.println("Contact with ID " + id + " has been deleted successfully.");
        } else {
            System.out.println("Contact with ID " + id + " not found.");
        }
    }

    public void updateContact(int id, String newName, String newPhoneNo, String newEmail) {
        boolean updated = false;
        for (Contact c : contactList) {
            if (c.getId() == id) {
                c.setName(newName);
                c.setPhoneNo(newPhoneNo);
                c.setEmail(newEmail);
                System.out.println("Contact successfully updated.");
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("Contact not found, so it can't be updated.");
        }
    }

    public void showAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
        } 
        else {
            System.out.println("All Contacts:");
            for (Contact c : contactList) {
                System.out.println(c);
            }
        }
    }
}
