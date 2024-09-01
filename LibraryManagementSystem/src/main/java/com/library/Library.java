package com.library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Boolean> availability = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        availability.put(book.getId(), true);
    }

    public boolean isBookAvailable(String id) {
        return availability.getOrDefault(id, false);
    }

    public void borrowBook(String id) throws Exception {
        if (!isBookAvailable(id)) {
            throw new Exception("Book not available");
        }
        availability.put(id, false);
    }

    public void returnBook(Book book) {
        availability.put(book.getId(), true);
    }
}
