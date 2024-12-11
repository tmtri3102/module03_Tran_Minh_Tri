package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.example.library.service.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "borrow":
                showUpdatePage(request, response);
                break;
            case "delete":
                showDeletePage(request, response);
                break;
            case "view":
                viewDetail(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }
    private void listBooks(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = this.bookService.listBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) {
        String bookId = request.getParameter("bookId");
        Book book = this.bookService.searchById(bookId);
        RequestDispatcher dispatcher;
//        if (book == null || book.getQuantity() == 0) {
//            dispatcher = request.getRequestDispatcher("error.jsp");
//        }

            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("book/borrow.jsp");

        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeletePage(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Book book = this.bookService.searchById(id);
//        RequestDispatcher dispatcher;
//        if (book == null) {
//            dispatcher = request.getRequestDispatcher("error.jsp");
//        } else {
//            request.setAttribute("book", book);
//            dispatcher = request.getRequestDispatcher("book/delete.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Book book = this.bookService.searchById(id);
//        RequestDispatcher dispatcher;
//        if (book == null) {
//            dispatcher = request.getRequestDispatcher("error.jsp");
//        } else {
//            request.setAttribute("book", book);
//            dispatcher = request.getRequestDispatcher("book/view.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }



//====================================================================================================================================================================================================================================================================================================================================================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                break;
        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 100);
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book();
        this.bookService.createBook(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/borrow.jsp");
        request.setAttribute("message",  "New book was created");
        try{
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response) {
//        int id = (int) (Math.random() * 100);
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//        double price = Double.parseDouble(request.getParameter("price"));
//
//        Book book = new Book(id, name, description, price);
//        RequestDispatcher dispatcher;
//
//        if (book == null) {
//            dispatcher = request.getRequestDispatcher("error.jsp");
//        }
//        else {
//            book.setName(name);
//            book.setDescription(description);
//            book.setPrice(price);
//            this.bookService.updateBook(id, book);
//            request.setAttribute("book", book);
//            request.setAttribute("message", "Update book successfully");
//            dispatcher = request.getRequestDispatcher("book/update.jsp");
//        }
//        try{
//            dispatcher.forward(request,response);
//        }
//        catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
//        String id = Integer.parseInt(request.getParameter("id"));
//        Book book = this.bookService.searchById(id);
//        RequestDispatcher dispatcher;
//        if (book == null) {
//            dispatcher = request.getRequestDispatcher("error.jsp");
//        } else {
//            this.bookService.deleteBook(id);
//            try {
//                response.sendRedirect("/books");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
