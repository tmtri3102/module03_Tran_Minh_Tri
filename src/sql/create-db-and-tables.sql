create database library;
use library;

CREATE TABLE books (
    book_id VARCHAR(10) NOT NULL, 
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    description TEXT,
    quantity INT DEFAULT 0,
    PRIMARY KEY (book_id)
);


CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    class VARCHAR(50)
);
 
CREATE TABLE borrow_cards (
    borrow_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id VARCHAR(10) NOT NULL, -- Foreign key referencing books.book_id
    student_id INT NOT NULL, -- This references students.student_id
    status TINYINT(1) NOT NULL, -- 1 for borrowed, 0 for returned
    borrow_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

INSERT INTO books (book_id, title, author, description, quantity) 
VALUES ('MS-1001', 'Java Programming', 'John Doe', 'A guide to Java.', 10);