package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Main Library");

        Book book1 = new Book("Metro 2033", "Dimitry Glukhovsky", LocalDate.of(2005, 1,2));
        Book book2 = new Book("Lord of the rings", "J.R.R. Tolkien", LocalDate.of(1954, 8,10));
        Book book3 = new Book("1984", "George Orwell", LocalDate.of(1949, 6,8));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //When
        Library shallowCopy = library.shallowCopy();
        Library deepCopy = library.deepCopy();

        shallowCopy.getBooks().remove(book1);

        //Then
        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowCopy.getBooks().size());
        assertEquals(3, deepCopy.getBooks().size());
    }
}
