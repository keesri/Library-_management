import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    public static void main(String[] args) {
        Books book1 = new Books("social service", "charles", 100, 5, "available");
        Books book2 = new Books("science", "jane", 200, 3, "available");
        Books book3 = new Books("computerscience", "macheal", 300, 4, "available");
        Books book4 = new Books("software", "henry", 400, 5, "available");
        Books book5 = new Books("hardware", "srikanth", 500, 6, "available");

        ArrayList<Books> books = new ArrayList<>(List.of(book1, book2, book3, book4, book5));
        Set<User_registration> users = new HashSet<>();

        // Is User registered
        boolean isLoggedIn = false;
        Scanner scan = new Scanner(System.in);
        while (true) {
            isLoggedIn = false;

            System.out.print("1. Are you new to the library?\n2. Are you already a registered user?\n");
            System.out.print("Enter the choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                scan.nextLine();
                
                        
                        System.out.println("Enter the user name:");
                        String user_name = scan.nextLine();
                        System.out.println("Enter the user email address:");
                        String user_email = scan.nextLine();
                        ArrayList<String> borrow_book=new ArrayList<String>();
                        if (isValidEmail(user_email)) {
                            System.out.println("Enter the user phone number:");
                            String user_number = scan.nextLine();
                            if (isValidPhoneNumber(user_number)) {
                               
                                if (users.isEmpty()) {
                                    User_registration user_details = new User_registration(user_name, user_email, user_number,borrow_book);
                                    users.add(user_details);
                                    isLoggedIn = true;
                                    break;
                                } else {
                                    for (User_registration user : users) {
                                        if (!user.user_name.equals(user_name) && !user.user_email.equals(user_email) && !user.phone_number.equals(user_number)) {
                                            User_registration user_details = new User_registration(user_name, user_email, user_number,borrow_book);
                                            users.add(user_details);
                                            isLoggedIn = true;
                                            break;
                                        }
                                    }
                                    if (!isLoggedIn) {
                                        System.out.println("User already exists, Please try login instead.");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Invalid phone number, Try Again");
                                break;
                            }
                        } else {
                            System.out.println("Invalid user email!Try Again");
                            break;
                        }
                
                case 2:
                    scan.nextLine();
                    System.out.print("Enter the user name: ");
                    String user_name1 = scan.nextLine();
                    System.out.print("Enter the user email address: ");
                    String user_email1 = scan.nextLine();
                    System.out.print("Enter the user phone number: ");
                    String user_number1 = scan.nextLine();
                    for (User_registration user : users) {
                        if (user.user_name.equals(user_name1) && user.user_email.equals(user_email1) && user.phone_number.equals(user_number1)) {
                            System.out.println("verified");
                            isLoggedIn = true;
                            break;
                        }
                    }
                    if (!isLoggedIn) {
                        System.out.println("Authentication Failed, Please retry again.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice,Please select from the Above choices...");
                    break;
            }
            
                if (isLoggedIn) {
                    boolean checking=true;
                    while(checking){
                        System.out.println("Enter the needed option: \n1. Borrow books\n2. Return books\n3. Book details\n4. User details\n5. Log out");
                        int option = scan.nextInt();
                        switch (option) {
                            case 1:
                            
                                scan.nextLine();
                                System.out.println("Enter your name:");
                                String customer_name = scan.nextLine();
                                System.out.print("Enter your needed Book by Book_name or Book_author: ");
                                String needed_book = scan.nextLine();
                                for (Books book : books) {
                                    if (book.book_name.equals(needed_book) && book.book_count > 0 || book.book_author.equals(needed_book) && book.book_count > 0) {
                                        book.book_count--;
                                        if (book.book_count == 0) {
                                            book.is_available = "unavailable";
                                        }
                                        System.out.println("Your book is available");
                                        for(User_registration user:users){
                                        if( user.user_name.equals(customer_name)){
                                                user.User_borrow_details.add(needed_book);
                                            }
                                        }

                                        break;
                                    } else {
                                        System.out.println("Book is Unavailable");
                                        break;
                                    }
                                } 
                            
                                break;
                            
                            case 2:
                                
                                    scan.nextLine();
                                    System.out.println("Enter your name:");
                                    String return_customer_name = scan.nextLine();
                                    System.out.println("Enter your needed by Book_name: ");
                                    String return_book = scan.nextLine();
                                    for (Books book : books) {
                                        if (book.book_name.equals(return_book)) {
                                            book.book_count++;
                                            book.is_available = "Available";
                                            System.out.println("Your book is successfully returned");
                                            break;
                                        }
                                        else {
                                            System.out.println("Your book is not returned successfully, Try again Later");
                                            break;
                                        }
                                    }
                                
                                break;
                            case 3:
                                int count = 1;
                                for (Books book : books) {
                                    System.out.println(count + ".Book_name: " + book.book_name);
                                    System.out.println(count + ".Book_author: " + book.book_author);
                                    System.out.println(count + ".Book_id: " + book.book_id);
                                    System.out.println(count + ".Book_count: " + book.book_count);
                                    System.out.println(count + ".Book_is_available: " + book.is_available);
                                    count++;
                                }
                                break;
                            case 5:
                                isLoggedIn = false;
                                System.out.println("Thank You Visit Again!!");
                                checking=false;
                                break;
                            
                            case 4:
                            while(true) {
                                scan.nextLine();
                                System.out.print("Enter your email address to know user details: ");
                                String email = scan.nextLine();
                                if(isValidEmail(email)){
                                        
                                    for(User_registration user : users){
                                        if(user.user_email.equals( email)) {
                                                System.out.println("User name is:" +user.user_name);
                                                System.out.println("user email is:" + user.user_email);
                                                System.out.println("user phone_number is:" + user.phone_number);
                                                if(!user.User_borrow_details.isEmpty()){
                                                for(String borrow:user.User_borrow_details){
                                                    System.out.println("user borrow_details is:" + borrow);
                                                }
                                                }
                                                else{
                                                    System.out.println("user borrow details is empty");
                                                }
                                                
                                        }        
                                    }
                                

                                }
                            else{
                                System.out.println("undefined email address");
                                break;
                            }
                            break;
                            }
                                
                    
                        }
                    }
                }
            
        }
    }
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        return email.matches(emailPattern);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^[0-9]{10}$"; // Assumes a valid phone number is 10 digits
        return phoneNumber.matches(phonePattern);
    }
}