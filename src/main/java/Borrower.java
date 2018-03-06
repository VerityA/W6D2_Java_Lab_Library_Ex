import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> collection;

    public Borrower() {
        this.collection = new ArrayList<>();
    }


    public int getCollectionCount() {
        return this.collection.size();
    }

    public void addBookToCollection(Book book) {
        this.collection.add(book);
    }

    public void moveBookFromLibraryToCollection(Library library) {
        Book book = library.removeBook();
        this.addBookToCollection(book);
    }
}
