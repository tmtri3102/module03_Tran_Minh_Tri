package com.example.library.model;

import java.util.Date;

public class BorrowCard {
    private int borrowId;
    private String bookId;
    private int studentId;
    private boolean status; // true = borrowed, false = returned
    private String borrowDate;
    private String returnDate;

    public BorrowCard(int borrowId, String bookId, int studentId, boolean status, String borrowDate, String returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = String.valueOf(borrowDate);
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = String.valueOf(returnDate);
    }
}
