package CW2;

public class Booking {
    String BookName,AuthorName,Field, date;
    int bookNumber, Quantity;
    
    
    Booking(String BookName, String AuthorName, String date, String Field, int bookNumber, int Quantity ){
        this.BookName=BookName;
        this.AuthorName=AuthorName;
        this.date=date;
        this.Field=Field;
        this.bookNumber=bookNumber;
        this.Quantity=Quantity;
    }
}