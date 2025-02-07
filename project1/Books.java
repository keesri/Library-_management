public class Books {
    int book_id;
    String book_author;
    String book_name;
    String is_available;
    int book_count;
    public Books(String book_name,String book_author,int book_id,int book_count,String is_available){
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_id = book_id;
        this.book_count = book_count;
        this.is_available = is_available;
    }
}