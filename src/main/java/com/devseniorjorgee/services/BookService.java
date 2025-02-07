package com.devseniorjorgee.services;

import java.util.ArrayList;
import java.util.List;

import com.devseniorjorgee.exception.NotFoundException;
import com.devseniorjorgee.model.Book;

public class BookService {

    private List<Book> books;

    public BookService(){
        books = new ArrayList<>();
    }

    public void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
    }

    public List<Book> getAllBooks() {
        return null;
    }

    public Book getBookByIsbn(String isbn) throws NotFoundException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }

        }
        throw new NotFoundException("No fue encontrado el libro con isbn: " + isbn);
    }

    public void deleteBook(String isbn) throws NotFoundException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
            }
        }
        throw new NotFoundException("No se puede eliminar el libro con isbn: " + isbn);

    }

}
