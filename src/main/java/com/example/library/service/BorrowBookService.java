package com.example.library.service;

import com.example.library.model.BorrowCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowBookService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private final String ADD_CARD = "INSERT INTO borrow_cards (book_id, student_id, status, borrow_date, return_date) VALUES (book_id, student_id, status, borrow_date, return_date)";
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public boolean add(BorrowCard borrowCard) {
        try (
                Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareCall(ADD_CARD)
        ) {
            preparedStatement.setString(1, borrowCard.getBookId());
            preparedStatement.setInt(2, borrowCard.getStudentId());
            preparedStatement.setBoolean(3, borrowCard.isStatus());
            preparedStatement.setString(4, borrowCard.getBorrowDate().toString());
            preparedStatement.setString(5, borrowCard.getReturnDate().toString());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Insert failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return true;
    }

}
