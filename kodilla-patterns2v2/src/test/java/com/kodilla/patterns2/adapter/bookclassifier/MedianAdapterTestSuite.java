package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1", "Title1", 2000, "A1"));
        books.add(new Book("Author2", "Title2", 2010, "A2"));
        books.add(new Book("Author3", "Title3", 1990, "A3"));
        books.add(new Book("Author4", "Title4", 2020, "A4"));
        books.add(new Book("Author5", "Title5", 1980, "A5"));

        MedianAdapter adapter = new MedianAdapter();

        // When
        int median = adapter.publicationYearMedian(books);

        // Then
        assertEquals(2000, median);
    }
}
