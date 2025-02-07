import java.util.ArrayList;
class User_registration{
    String user_name;
    String user_email;
    String phone_number;
    ArrayList<String> User_borrow_details;
    public User_registration( String user_name, String user_email,String phone_number,ArrayList<String> user_borrow_details){
        this.user_name = user_name;
        this.user_email = user_email;
        this.phone_number = phone_number;
        this.User_borrow_details = user_borrow_details;

    }
}