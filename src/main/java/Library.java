import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<Genre, Integer> genreCountHash;

    public Library() {
        this.books = new ArrayList<>();
        this.capacity = 5;
        this.genreCountHash = new HashMap<>();
    }


    public int getBookCount() {
        return this.books.size();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean isNotAtCapacity() {
        return this.getBookCount() < this.capacity;
    }

    public void addBookIfNotAtCapacity(Book book) {
        if (this.isNotAtCapacity()) {
            this.addBook(book);
        }
    }

    public Book removeBook() {
        if (this.getBookCount() > 0) {
            return this.books.remove(0);
        }
        return null;
    }

    public int countBooksOfGenre(Genre genre) {
        int genreCount = 0;
        for (Book book : this.books) {
            if (genre == book.getGenre()) {
                genreCount += 1;
            }
        }
        return genreCount;
    }

    public HashMap<Genre, Integer> createGenreCountHash(Book book) {
        Genre[] genres = Genre.values();
        for (Genre genre : genres) {
            genreCountHash.put(genre, this.countBooksOfGenre(genre));
        }
        return genreCountHash;
    }
}