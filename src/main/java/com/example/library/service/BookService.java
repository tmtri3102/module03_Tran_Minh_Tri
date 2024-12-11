package com.example.library.service;

import com.example.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private final String SELECT_BOOK = "SELECT * FROM books";
    private final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE book_id = ?";


    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }


    public List<Book> listBooks() {
        List<Book> books = new ArrayList<>();
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





    public Book searchById(String id) {
        Book book = null;
        try (
                Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BOOK_BY_ID);
        ) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                book = new Book(id, title, author, description, quantity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


}
