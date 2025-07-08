package Books;
import Services.*;
public class PaperBook extends Book {
    private int stock;
    public PaperBook(String isbn, String title, int publishedyear, double price,int stock) {
        super(isbn, title, publishedyear, price);
        this.stock = stock;
    }
    @Override
    public double buy(String isbn,int quantity, String email, String address) {
    if(quantity <=0) {
        throw new IllegalArgumentException("Quantity must be greater than 0");
    }
    else if(quantity > stock) {
        throw new IllegalArgumentException("Sorry Our stock now is only "+stock);
    }
    stock -= quantity;
    ShippingService.send(address);
    return quantity*getPrice();
    }
}