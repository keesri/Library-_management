import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

class Account_creations {
    String name;
    long phone_number;
    String gender;
    long accountNumber;
    String password;
    long deposit;
    ArrayList<Long> deposit_history = new ArrayList<>();
    ArrayList<Long> withdraw_history = new ArrayList<>();
    ArrayList<String> statement = new ArrayList<>();

    Account_creations() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: ");
        this.name = scan.nextLine();

        while (true) {
            try {
                System.out.print("Select gender: 1.Male 2.Female ");
                int gender_selection = scan.nextInt();
                if (gender_selection == 1) {
                    this.gender = "Male";
                    break;
                } else if (gender_selection == 2) {
                    this.gender = "Female";
                    break;
                } else {
                    System.out.println("Incorrect option, select the correct option!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter 1 for Male or 2 for Female.");
                scan.nextLine(); // Clear invalid input
            }
        }

        while (true) {
            try {
                System.out.print("Enter your phone number: ");
                this.phone_number = scan.nextLong();
                if (String.valueOf(this.phone_number).length() == 10) {
                    this.accountNumber = (long) (Math.random() * 10000000000L);
                    System.out.println("Generated Account Number: " + accountNumber);
                    scan.nextLine(); // Consume newline

                    while (true) {
                        System.out.print("Set password: ");
                        this.password = scan.nextLine();
                        if (password_checker(password)) {
                            break;
                        } else {
                            System.out.println("Invalid password, Try Again!");
                        }
                    }
                    break;
                } else {
                    System.out.println("Invalid phone number, it must be 10 digits. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid 10-digit phone number.");
                scan.nextLine(); // Clear invalid input
            }
        }

        System.out.println("Your Account is created successfully!!");
    }

    public static boolean password_checker(String password) {
        String PasswordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(PasswordPattern);
    }
}
