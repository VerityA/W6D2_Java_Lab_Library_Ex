import com.sun.tools.javah.Gen;

public class Book {

    private Genre genre;

    public Book(Genre genre) {
        this.genre = genre;
    }


    public Genre getGenre() {
        return genre;
    }
}
