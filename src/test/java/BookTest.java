import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before() {
        book = new Book(Genre.CRIME);
    }

    @Test
    public void hasGenre() {
        assertEquals(Genre.CRIME, book.getGenre());
    }

//    @Test
//    public void canGetAllGenres() {
//        Genre[] genres = Genre.
//    }
}
