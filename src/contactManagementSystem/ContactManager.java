package contactManagementSystem;

import exceptions.IncorrectNameFormatException;
import exceptions.IncorrectPhNumberLength;

import java.util.ArrayList;

public class ContactManager {

	private ArrayList<Contact> contactList = new ArrayList<>();

	public void addContact(Contact c) throws IncorrectNameFormatException, IncorrectPhNumberLength {

		if (!isValidName(c.getName())) {
			throw new IncorrectNameFormatException();
		}
		if (!isValidPhoneNumber(c.getPhoneNo())) {
			throw new IncorrectPhNumberLength();
		}
		if (!isValidEmail(c.getEmail())) {
			System.out.println("Invalid email format. Must contain '@' and end with '.com'");
			return;
		}

		for (Contact contact : contactList) {
			if (contact.getId() == c.getId()) {
				System.out.println("Error: Duplicate ID detected. Please enter a unique ID.");
				return;
			}
		}

		contactList.add(c);
		System.out.println("Contact added successfully.");


	}

	public void updateContact(int id, String newName, String newPhoneNo, String newEmail) throws IncorrectNameFormatException, IncorrectPhNumberLength {
		if (!isValidName(newName)) {
			throw new IncorrectNameFormatException();
		}
		if (!isValidPhoneNumber(newPhoneNo)) {
			throw new IncorrectPhNumberLength();
		}
		if (!isValidEmail(newEmail)) {
			System.out.println("Invalid email format.");
			return;
		}

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
		} else {
			System.out.println("All Contacts:");
			for (Contact c : contactList) {
				System.out.println(c);
			}
		}
	}

	public void searchByName(String name) {
		boolean found = false;
		for (Contact c : contactList) {
			if (c.getName().toLowerCase().contains(name.toLowerCase())) {
				if (!found) {
					System.out.println("Matching contacts found:");
				}
				System.out.println(c);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No matching contact found.");
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

	public boolean isValidPhoneNumber(String phoneNo) {
		return phoneNo.matches("\\d{10}");
	}

	public boolean isValidEmail(String email) {
		return email.contains("@") && email.endsWith(".com");
	}

	public boolean isValidName(String name) {
		return name.matches("[a-zA-Z0-9]+");
	}

}
