package com.library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void testAddBook() {
        Library library = new Library();
        Book book = new Book("1", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        assertTrue(library.isBookAvailable("1"));
    }

    @Test
    void testBorrowBook() throws Exception {
        Library library = new Library();
        Book book = new Book("1", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("1");
        assertFalse(library.isBookAvailable("1"));
    }

    @Test
    void testBorrowBookNotAvailable() {
        Library library = new Library();
        assertThrows(Exception.class, () -> {
            library.borrowBook("1");
        });
    }

    @Test
    void testReturnBook() throws Exception {
        Library library = new Library();
        Book book = new Book("1", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("1");
        library.returnBook(book);
        assertTrue(library.isBookAvailable("1"));
    }
}
