package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> booksMap = new HashMap<>();
            booksMap = bookSet.stream()
                    .collect(Collectors.toMap(e -> new BookSignature(e.getSignature()), e -> new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(e.getAuthor(), e.getTitle(), e.getPublicationYear())));
        return medianPublicationYear(booksMap);
    }
}
