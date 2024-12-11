package com.example.library.service;

import com.example.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/center_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private final String SELECT_BOOK = "SELECT * FROM books";

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public List<Book> listBooks() {
        List<Book> books = new ArrayList<Book>();
        try (
                Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BOOK);
                ResultSet rs = preparedStatement.executeQuery();
        ) {

            while (rs.next()) {
                String id = rs.getString("book_id");
                String name = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                Book book = new Book(id, name, author, description, quantity);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public Book searchById(int id) {
        return null;
    }

    @Override
    public void updateBook(int id, Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }
}
