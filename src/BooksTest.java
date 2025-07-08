import Books.*;
import Exceptions.*;
import Services.CheckInventory;

   public class BooksTest {
        public static void main(String[] args) throws Exception {
            System.out.println("------------------------Adding books ------------------------");
            PaperBook  paperBook1= new PaperBook("P01","Paper Book 1",2000,100.0,10);
            PaperBook  paperBook2= new PaperBook("P02","Paper Book 2",2010,150,20);
            EBook ebook1 = new EBook("E03","Electronic Book 2",2018,50.0,"PDF");
            EBook ebook2 = new EBook("E04","Electronic Book 3",2009,90.0,"PDF");
            DemoBook demoBook = new DemoBook("D03","Demo Book 4",2015,150.0);
            System.out.println("Books're now added ");
            CheckInventory inventory = new CheckInventory();
            inventory.add(paperBook1);
            inventory.add(paperBook2);
            inventory.add(ebook1);
            inventory.add(ebook2);
            inventory.add(demoBook);
            System.out.println();
            System.out.println("------------------------Removing Outdated ------------------------\"");
            System.out.println("Removing outdated books older than 20 years");
            inventory.removeOutdated(20);
            System.out.println();

            System.out.println("Trying to buy a removed book whose ISBN is P01:");
            try {
                inventory.buy("P01", 1, "saif@gmail.com", "Menouf");
            } catch (BookNotFoundException b) {
                System.out.println(b.getMessage());
            }
            System.out.println("Trying to buy paper book with quantity exceeding stock:");
            try {
                double paidPaperBook = inventory.buy("P01", 20, "saif@gmail.com", "Menouf");
                System.out.println("Total paid is " + paidPaperBook);
              } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Successful buying for paper book:");
            try {
                double paidPaperBook = inventory.buy("P02", 1, "saif@gmail.com", "Menouf");
                System.out.println("Total paid is " + paidPaperBook );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Successful buying for ebook");
            try {
                double paidEBook = inventory.buy("E03", 10, "saif@gmail.com", "Menouf");
                System.out.println("Total paid is " + paidEBook);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Trying to buy demo book:");
            try {
                double paidDemoBook = inventory.buy("D03", 2, "saif@gmail.com", "Menouf");
                System.out.println("Total paid: " + paidDemoBook);
            } catch (DemoException d) {
                System.out.println(d.getMessage());
            }


        }
    }
