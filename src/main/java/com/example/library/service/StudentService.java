package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private final String SELECT_STUDENT = "SELECT * FROM students";
    private final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE student_id = ?";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_STUDENT);
                ResultSet rs = preparedStatement.executeQuery();
        ) {

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("full_name");
                String className = rs.getString("class");
                Student student = new Student(id, name, className);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student searchById(int id) {
        Student student = null;
        try (
                Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_STUDENT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("full_name");
                String className = rs.getString("class");
                student = new Student(id, name, className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}
