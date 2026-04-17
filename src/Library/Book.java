package Library;

public class Book {
   private final int id;
    private String title;
    private String author;
    private int quantity;

    public Book(int id, String title, String author, int quantity) {
        if(id < 1) throw new RuntimeException("ID must be greater than 0");
        if(title == null || title.isEmpty()) throw new RuntimeException("Title cannot be null nor empty");
        if(author == null || author.isEmpty()) throw new RuntimeException("Author cannot be null nor empty");
        if(quantity < 1) throw new RuntimeException("Quantity must be greater than 0");
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()) throw new RuntimeException("Title cannot be null nor empty");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isEmpty()) throw new RuntimeException("Author cannot be null nor empty");
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0) throw new RuntimeException("Quantity must be greater than 0");
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity;
    }
}
