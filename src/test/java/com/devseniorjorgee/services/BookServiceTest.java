package com.devseniorjorgee.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devseniorjorgee.exception.NotFoundException;

public class BookServiceTest {

    private BookService service;

    @BeforeEach
    void setup() {
        service = new BookService();
    }

    @Test
    void testAddBook() throws NotFoundException {
        // GIVEN - preparar los datos de la prueba

        var isbn = "123456789";
        var title = "Aprendiendo java";
        var author = "Jorge Echavarría";

        // WHEN - Ejecutar el metodo a probar
        service.addBook(isbn, title, author);

        // THEN - Verificaciones que el método se ejecutó bien
        var book = service.getBookByIsbn(isbn);
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());

    }

    @Test
    void testDeleteExistingdBook() throws NotFoundException {
        // GIVEN
        var isbn = "123456789";
        var title = "Aprendiendo java";
        var author = "Jorge Echavarría";
        service.addBook(isbn, title, author);

        // WHEN
        service.deleteBook(isbn);

        // THEN
        try {
            service.getBookByIsbn(isbn);
            fail();
        } catch (NotFoundException e) {
            assertTrue(true);
        }

    }

    @Test
    void testDeleteENonExistingdBook() {
        // GIVEN
        var isbn = "123456789";

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.deleteBook(isbn);
                });

    }

    @Test
    void testGetAllBooks() {

    }

    @Test
    void testGetBookByIsbn() {

    }
}
