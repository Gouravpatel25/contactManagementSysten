package driverPackage;

import java.util.Scanner;
import contactManagementSystem.Contact;
import contactManagementSystem.ContactManager;

import exceptions.IncorrectPhNumberLength;
import exceptions.IncorrectNameFormatException;

public class DriverClass {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ContactManager cm = new ContactManager();

        boolean flag = true;

        while (flag) {
            System.out.println("\nMain Menu:");
            System.out.println(" 1 - Add Contact");
            System.out.println(" 2 - Display All Contacts");
            System.out.println(" 3 - Search by Name");
            System.out.println(" 4 - Search by Number");
            System.out.println(" 5 - Delete by ID");
            System.out.println(" 6 - Update Contact");
            System.out.println(" 7 - Exit");
            System.out.print("Enter your choice: ");

            String choiceInput = sc.nextLine();
            if (!isNumeric(choiceInput)) {
                System.out.println("Invalid input. Please enter a number between 1 - 7");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phNo = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    try {
                        cm.addContact(new Contact(id, name, phNo, email));
                    } 
                    catch (IncorrectPhNumberLength | IncorrectNameFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    cm.showAllContacts();
                    break;

                case 3:
                    System.out.print("Enter Name to search: ");
                    String searchName = sc.nextLine();
                    cm.searchByName(searchName);
                    break;

                case 4:
                    System.out.print("Enter Number to search: ");
                    String searchNumber = sc.nextLine();
                    cm.searchByNumber(searchNumber);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    cm.deleteById(deleteId);
                    break;

                case 6:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Phone Number: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.nextLine();

                    try {
                        cm.updateContact(updateId, newName, newPhone, newEmail);
                    } 
                    catch (IncorrectPhNumberLength | IncorrectNameFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    flag = false;
                    System.out.println("Exiting successfully");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
    
    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
