package Library;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {

    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) throw new DuplicateBookException("Book with ID:"+ book.getId() +" already exists");
        books.put(book.getId(), book);
    }

    public void removeBook(int id) {
        if(!books.containsKey(id)) throw new BookNotFoundException("Book with id "+id+" not found");
        books.remove(id);

    }

    public Book getBook(int id) {
        Book book = books.get(id);
        if (book == null) {throw new RuntimeException("Book not found with id " + id);}
        return book;
    }

    public void borrowBook(int id) {
        Book book = getBook(id);
        int quantity = book.getQuantity();
        if(quantity < 1) System.out.println("Book Not Available: "+book.getTitle());
        book.setQuantity(quantity-1);
    }

    public void returnBook(int id) {
        Book book = getBook(id);
        int quantity = book.getQuantity();
        book.setQuantity(quantity+1);
    }

    public Collection<Book> getBooks() {
        return books.values();
    }

    public Collection<Book> sortBooks() {
        return books.values();
        //needs work
    }
}
