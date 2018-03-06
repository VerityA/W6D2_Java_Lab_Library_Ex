import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Library library;
    Book book;
    Borrower borrower;

    @Before
    public void before() {
        library = new Library();
        book = new Book(Genre.ADVENTURE);
        borrower = new Borrower();
    }

    @Test
    public void canGetCollectionCount() {
        assertEquals(0, borrower.getCollectionCount());
    }

    @Test
    public void canAddBookToCollection () {
        borrower.addBookToCollection(book);
        assertEquals(1, borrower.getCollectionCount());
    }

    @Test
    public void canMoveBookFromLibraryToCollection() {
        library.addBook(book);
        assertEquals(1, library.getBookCount());
        borrower.moveBookFromLibraryToCollection(library);
        assertEquals(0, library.getBookCount());
        assertEquals(1, borrower.getCollectionCount());

    }
}
