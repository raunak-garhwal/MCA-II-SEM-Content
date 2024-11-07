// Access Control: Create a class Library with fields for book title, author and ISBN. Use different access modifiers (private, protected, public) for these fields. Write methods to access and modify these fields appropriately. Demonstrate access control in a main method.

class Library {
    private String bookTitle;       // Private field: accessible only within this class
    protected String author;        // Protected field: accessible within this class, subclasses, and the same 
    public String ISBN;             // Public field: accessible from anywhere

    // Constructor to initialize fields
    public Library(String bookTitle, String author, String ISBN) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Getter method for bookTitle (private field)
    public String getBookTitle() {
        return bookTitle;
    }

    // Setter method for bookTitle (private field)
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Getter method for author (protected field)
    public String getAuthor() {
        return author;
    }

    // Setter method for author (protected field)
    public void setAuthor(String author) {
        this.author = author;
    }

    // No need for getter/setter for ISBN since it's public,
    // but it's added for completeness and encapsulation
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Title: " + getBookTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
    }
}

public class AccessControl {
    public static void main(String[] args) {
        // Creating an instance of the Library class
        Library book = new Library("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");

        // Accessing and displaying the details of the book using public methods
        System.out.println("\n--- Book Details Before Modification ---");
        book.displayBookDetails();

        // Modifying fields using setter methods
        book.setBookTitle("1984");  // Modifying private field using public setter
        book.setAuthor("George Orwell");  // Modifying protected field using public setter
        book.setISBN("879-0451524935");  // Modifying public field using public setter

        // Accessing fields directly where possible (ISBN is public)
        System.out.println("\nDirectly accessing public ISBN field: " + book.ISBN);
        // System.out.println("\nDirectly accessing public ISBN field: " + book.bookTitle); You cannot access private field of any object directly without any getter or setter.
        System.out.println("\nDirectly accessing protected author field: " + book.author);

        // Displaying the updated details of the book
        System.out.println("\n--- Book Details After Modification ---");
        book.displayBookDetails();
    }
}
