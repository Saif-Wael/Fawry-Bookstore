package Books;
import Services.*;
public class EBook extends Book {
    private String FileType;
    public EBook(String isbn, String title, int publishyear, double price, String fileType){
        super(isbn,title,publishyear, price);
        if (fileType == null || fileType.isEmpty()) {
            throw new IllegalArgumentException("File type cannot be null or empty");
        }
        this.FileType = fileType;
    }
    @Override
    public double buy(String isbn, int quatity, String email, String address) {
        MailShipping.send(email);
        return quatity*getPrice();
    }
}
