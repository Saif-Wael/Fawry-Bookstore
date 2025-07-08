package Books;

import Exceptions.DemoException;

public class DemoBook extends Book{
    public DemoBook(String isbn, String title, int publishedyear, double price) {
        super(isbn, title, publishedyear, price);
    }
    @Override
    public double buy(String isbn ,int quantity, String email, String address) {
        throw new DemoException("The Demo Books are not for sale .");
    }
}
