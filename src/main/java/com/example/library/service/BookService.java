package com.example.library.service;

import com.example.library.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookService {
    Connection getConnection() throws SQLException;

    List<Book> listBooks();
    void createBook(Book book);
    Book searchById(String id);
    void updateBook(int id, Book book);
    void deleteBook(int id);
}
