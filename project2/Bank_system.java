import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Bank_system {
    public static void main(String[] args) {

       ArrayList<Account_creations> user_accounts = new ArrayList<>();
        boolean breaking_loop = true;
        while(breaking_loop){
            Scanner scan = new Scanner(System.in);
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Details\n5. Transaction history\n6. Log out");
            System.out.print("Enter the Option: ");
            int select_option = scan.nextInt();

            switch(select_option) {
                case 1:
                    Account_creations bank_account_creation = new Account_creations();
                    user_accounts.add(bank_account_creation);
                    break;
                
                case 2:
                    boolean breaking_loop_deposit = true;
                    while(breaking_loop_deposit){
                        Deposit deposit = new Deposit();
                        for(Account_creations user : user_accounts){
                            if(deposit.accountNumber == user.accountNumber && deposit.password.equals(user.password)){
                                System.out.print("Enter the amount to deposit: ");
                                long amount = scan.nextInt();
                                user.deposit = user.deposit+amount;
                                user.deposit_history.add(amount);
                                LocalDateTime now = LocalDateTime.now();
                                DateTimeFormatter formate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                String dateTime = now.format(formate);
                                String deposit_amount = " Deposit "+ String.valueOf(amount);
                                user.statement.add(dateTime.concat(deposit_amount));
                                breaking_loop_deposit = false;
                                System.out.println("Successfully amount deposited to your account");                                break;

                            }
                            else{
                                System.out.println("Authentication error");
                            }
                        }
                        
                    }
                    break;
                
                case 3:
                    boolean  breaking_loop_withdraw = true;
                    while( breaking_loop_withdraw ){
                        Withdraw withdraw = new Withdraw();
                        for(Account_creations user :  user_accounts){
                            if(withdraw.accountNumber == user.accountNumber && withdraw.password.equals(user.password)){
                                while(true){
                                    System.out.println("Enter the amount to deposit");
                                    long amount = scan.nextInt();
                                    if(user.deposit > amount || user.deposit == amount){
                                        user.deposit = user.deposit-amount;
                                        user.withdraw_history.add(amount);
                                        breaking_loop_withdraw = false;
                                        LocalDateTime now = LocalDateTime.now();
                                        DateTimeFormatter formate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
                                        String dateTime = now.format(formate);
                                        String Withdraw_amount =" Withdraw "+ String.valueOf(amount);
                                        user.statement.add(dateTime.concat(Withdraw_amount));
                                        System.out.println("Transaction successfully completed");
                                        breaking_loop_withdraw = false;
                                        break;
                                    }
                                    else{
                                        System.out.println("Insufficient Balance ");
                                        
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Invalid User,Please enter the valid account number and password!");
                            }
                        }
                    }
                    break;


                case 4:
                    Entry_checkup entry_checkup = new Entry_checkup();
                    for(Account_creations user : user_accounts){
                        if(entry_checkup.accountNumber == user.accountNumber && entry_checkup.password.equals(user.password)){
                            System.out.println("Account Holder: "+user.name);
                            System.out.println("Account Holder Gendarity: "+user.gender);
                            System.out.println("Account holder phone number: "+user.phone_number);
                            System.out.println("Account holder account number: "+user.accountNumber);
                            System.out.println("Account holder password: "+user.password);
                            System.out.println("Balance: "+user.deposit);
                            System.out.println("Account holder deposit history: "+user.deposit_history);
                            System.out.println("Account holder withdraw history: "+user.withdraw_history);
                            
                        }
                    }
                    break;

                    case 5:
                        Entry_checkup transaction_history_checkup = new Entry_checkup();
                        for(Account_creations user : user_accounts){
                            if(transaction_history_checkup.accountNumber == user.accountNumber && transaction_history_checkup.password.equals(transaction_history_checkup.password)){
                                for(String statement : user.statement){
                                    System.out.println(statement);
                                }
                            }
                            else{
                                System.out.println("Enter the valid account number and password!");
                            }
                        }
                        break;
                        
                    case 6:
                        breaking_loop = false;
                        break;

                    default:
                        System.out.println("Invalid option, Please Select Valid option");
            }
                    
        }
        
    }
}
