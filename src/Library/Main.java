package Library;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book(1, "Book 1", "Author 1", 1);
        Book b2 = new Book(2, "Book 2", "Author 2", 2);
        Book b3 = new Book(3, "Book 3", "Author 3", 3);
        Book b4 = new Book(4, "Book 4", "Author 4", 4);
        Book b5 = new Book(5, "Book 5", "Author 5", 5);
        Book b6 = new Book(6, "Book 6", "Author 6", 6);

        LibraryService myLibrary = new LibraryService();
        myLibrary.addBook(b1);
        myLibrary.addBook(b2);
        myLibrary.addBook(b3);
        myLibrary.addBook(b4);

        System.out.println(myLibrary.getBooks());

        myLibrary.removeBook(3);
        System.out.println(myLibrary.getBooks());

        Book myFavoriteBook = myLibrary.getBook(2);
        System.out.println("This is my Favorite Book: "+myFavoriteBook);

        myLibrary.borrowBook(2);
        myLibrary.borrowBook(2);
        //myLibrary.borrowBook(3); //Cannot invoke "Library.Book.getQuantity()" because "book" is null
        System.out.println(myLibrary.getBooks());

        myLibrary.returnBook(2);
        myLibrary.returnBook(2);
        System.out.println(myLibrary.getBooks());

        myLibrary.removeBook(4);
        System.out.println(myLibrary.getBooks());

        // myLibrary.addBook(b1);
        System.out.println(myLibrary.getBooks());
    }
}
