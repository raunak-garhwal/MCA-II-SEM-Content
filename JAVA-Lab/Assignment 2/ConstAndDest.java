// Constructors and Destructors: Write a class Book with a parameterized constructor to initialize the book's title, author, and price. Include a destructor (using the finalize method) that prints a message when an object is garbage collected. Create and destroy a few Book objects in the main method.

// Define the Book class with a parameterized constructor and finalize method
class Book {
    private String title;
    private String author;
    private double price;

    // Parameterized constructor to initialize the book's attributes
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Book created: " + title + " by " + author + " at $" + price);
    }

    // Finalize method acting as a destructor (called by garbage collector)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Book object is being garbage collected: " + title);
        super.finalize();
    }
}

// Main class to demonstrate the creation and destruction of Book objects
public class ConstAndDest {
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("1984", "George Orwell", 19.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 14.99);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);

        // Suggesting garbage collection (Note: finalize() may not be called immediately)
        book1 = null;
        book2 = null;
        book3 = null;

        // Requesting garbage collection
        System.gc();

        // End of main method
        System.out.println("End of main method.");
    }
}