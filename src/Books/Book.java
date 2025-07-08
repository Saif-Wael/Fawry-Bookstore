package Books;

public abstract class Book {
    protected final String ISBN;
    protected final String Title;
    protected final int PublishedYear;
    protected double Price;

    Book(String ISBN, String Title, int PublishedYear, double Price) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.PublishedYear = PublishedYear;
        this.Price = Price;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public String getTitle() {
        return this.Title;
    }
    public int getPublishedYear() {
        return this.PublishedYear;
    }
    public double getPrice() {
        return this.Price;
    }
    public abstract double buy(String isbn,int quatity,String email,String address);

    public boolean isOutdated(int years) {
        int currentYear = java.time.Year.now().getValue();
        return (currentYear - PublishedYear) > years;
    }
}
