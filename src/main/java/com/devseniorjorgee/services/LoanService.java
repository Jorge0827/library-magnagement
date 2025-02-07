package com.devseniorjorgee.services;

import java.util.ArrayList;
import java.util.List;

import com.devseniorjorgee.exception.NotFoundException;
import com.devseniorjorgee.model.Loan;
import com.devseniorjorgee.model.LoanState;

public class LoanService {

    private List<Loan> loans;
    private BookService bookService;
    private UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loans = new ArrayList<>();
    }

    public void addLoan(String id, String isbn) throws NotFoundException {
        var user = userService.getUserById(id);
        var book = bookService.getBookByIsbn(isbn);
        loans.add(new Loan(user, book));
    }

    public void returnBook(String id, String isbn) throws NotFoundException {
        for (Loan loan : loans) {
            if (loan.getUser().getId().equals(id)
                    && loan.getBook().getIsbn().equals(isbn)
                    && loan.getLoanDate().equals(LoanState.STARTED)) {
                loan.setState(LoanState.FINISHED);
                return;

            }
        }
        throw new NotFoundException("No hay un prestamo del libro: " + isbn + " Para el usuario: " + id);
    }

}
