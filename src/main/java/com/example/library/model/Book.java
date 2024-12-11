package com.example.library.model;

public class Book {
    private String id;
    private String name;
    private String author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(String id, String name, String author, String description, int quantity) {
        if (!isValidBookId(id)) {
            throw new IllegalArgumentException("Invalid Book ID. Format must be MS-XXXX with X as digits.");
        }
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!isValidBookId(id)) {
            throw new IllegalArgumentException("Invalid Book ID. Format must be MS-XXXX with X as digits.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private boolean isValidBookId(String id) {
        return id != null && id.matches("MS-\\d{4}"); // Check if id matches "MS-XXXX" format
    }
}
