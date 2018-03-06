import com.sun.tools.javah.Gen;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;
    Book book;

    @Before
    public void before() {
        library = new Library();
        book = new Book(Genre.ADVENTURE);
    }

    @Test
    public void canGetBookCount() {
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void canAddBook() {
        library.addBook(book);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void showLibraryNotAtCapacity() {
        library.addBook(book);
        assertTrue(library.isNotAtCapacity());
    }

    @Test
    public void showLibraryIsAtCapacity() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertFalse(library.isNotAtCapacity());
    }

    @Test
    public void canAddBookWhenNotAtCapacity() {
        library.addBookIfNotAtCapacity(book);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void cannotAddBookWhenAtCapacity() {
        library.addBookIfNotAtCapacity(book);
        library.addBookIfNotAtCapacity(book);
        library.addBookIfNotAtCapacity(book);
        library.addBookIfNotAtCapacity(book);
        library.addBookIfNotAtCapacity(book);
        library.addBookIfNotAtCapacity(book);
        assertEquals(5, library.getBookCount());
    }

    @Test
    public void canRemoveBookIfLibraryContainsBooks() {
        library.addBookIfNotAtCapacity(book);
        library.removeBook();
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void cannotRemoveBookIfLibraryDoesNotContainBooks() {
        library.removeBook();
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void canCountThreeCrimeBooks() {
        Book book1 = new Book(Genre.ROMCOM);
        Book book2 = new Book(Genre.CRIME);
        Book book3 = new Book(Genre.CRIME);
        Book book4 = new Book(Genre.CRIME);
        library.addBookIfNotAtCapacity(book1);
        library.addBookIfNotAtCapacity(book2);
        library.addBookIfNotAtCapacity(book3);
        library.addBookIfNotAtCapacity(book4);
        assertEquals(3, library.countBooksOfGenre(Genre.CRIME));
    }

    @Test
    public void canCreateGenreCountHash() {
        Book book1 = new Book(Genre.ROMCOM);
        Book book2 = new Book(Genre.ROMCOM);
        Book book3 = new Book(Genre.CRIME);
        Book book4 = new Book(Genre.CRIME);
        Book book5 = new Book(Genre.THRILLER);
        library.addBookIfNotAtCapacity(book1);
        library.addBookIfNotAtCapacity(book2);
        library.addBookIfNotAtCapacity(book3);
        library.addBookIfNotAtCapacity(book4);
        library.addBookIfNotAtCapacity(book5);
        HashMap<Genre, Integer> testHashMap = new HashMap<>();
        testHashMap.put(Genre.ADVENTURE, 0);
        testHashMap.put(Genre.CRIME, 2);
        testHashMap.put(Genre.THRILLER, 1);
        testHashMap.put(Genre.ROMCOM, 2);
        testHashMap.put(Genre.CHILDRENS, 0);
        assertEquals(testHashMap, library.createGenreCountHash(book));
    }

}
