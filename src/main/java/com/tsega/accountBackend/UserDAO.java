package com.tsega.accountBackend;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
@Component
public class UserDAO {
    private ArrayList<User> userList = new ArrayList<>();

    public UserDAO(){
        userList.add(new User("tsega@tsega.com", "password12", "Tsega Tsahai", "11/26/1996", 'F'));
        userList.add(new User("jermain@tsega.com", "password3", "Jermain Cole", "01/28/1983", 'M'));
    }
    public User addUser(User user){
        userList.add(user);
        return user;
    }

    public ArrayList<User> displayAllUsers(){
        return userList;
    }

    public User removeUser(User user){
        userList.remove(user);
        return user;
    }
//    //remove contact by firstname
//    public void removeContact(String firstname) {
//        Iterator<Contact> it = userList.iterator();
//        while(it.hasNext()){
//            Contact contact = it.next();
//            if(contact.getFirstName().equals(firstname)){
//                it.remove();
//                System.out.println("Removed " + contact.getFirstName() + " " + contact.getLastName() + " from your contacts");
//            }
//        }
//    }
//    //Update contact's phone number
//    public void updateContact(Contact contact) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you like to update? ");
//        System.out.println("\t 1 for first name");
//        System.out.println("\t 2 for last name");
//        System.out.println("\t 3 for phone number");
//        System.out.println("\t 4 for email");
//        int userChoice = scanner.nextInt();
//        scanner.nextLine();
//        switch (userChoice){
//            case 1:
//                System.out.println("Please enter the updated first name: ");
//                String newFirstName = scanner.nextLine();
//                contact.setFirstName(newFirstName);
//                System.out.println("Success!");
//                break;
//            case 2:
//                System.out.println("Please enter the updated last name: ");
//                String newLastName = scanner.nextLine();
//                contact.setLastName(newLastName);
//                System.out.println("Success!");
//                break;
//            case 3:
//                System.out.println("Please enter the updated phone number: ");
//                String newNumber = scanner.nextLine();
//                contact.setPhoneNumber(newNumber);
//                System.out.println("Success!");
//                break;
//            case 4:
//                System.out.println("Please enter the updated email address: ");
//                String newEmail = scanner.nextLine();
//                contact.setEmailAddress(newEmail);
//                System.out.println("Success!");
//                break;
//            default:
//                System.out.println("ERROR: Invalid Option");
//                break;
//        }
//    }
//
//    public void printContacts(){
//        for (Contact contact : userList)
//            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmailAddress());
//    }

    //   CRUD
    //Add method     -   Create
    //Print Contacts   - Retreive
    //Update           - Update
    //Remove contact   - Delete

}



