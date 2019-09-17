package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        double median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(median, 0, 0);
    }

    @Test
    public void publicationYearMedianTestWithBook() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        Book newBook = new Book("Author", "title", 1999, "464664");
        bookSet.add(newBook);
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        double median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(1999, median, 0);
    }
}
