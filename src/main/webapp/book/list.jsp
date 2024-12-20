<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2024
  Time: 11:50 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Book List</title>
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">All Books</h1>
    <p class="text-center">
        <c:if test='${requestScope.message != null}'>
            <span class="text-danger fw-bold">${requestScope.message}</span>
        </c:if>
    </p>
    <form action="/books" method="GET">
        <input type="hidden" name="bookId" value="borrow">
        <table class="table table-hover">
            <tr>
                <td>Book ID</td>
                <td>Name</td>
                <td>Author</td>
                <td>Quantity</td>
                <td>Description</td>
                <td>Action</td>
                <%--        <td>Update</td>--%>
                <%--        <td>Delete</td>--%>
            </tr>
            <c:forEach items='${requestScope["books"]}' var="book">
                <tr>
                    <td>${book.getId()}</td>
                    <td>${book.getName()}</td>
                    <td>${book.getAuthor()}</td>
                    <td>${book.getQuantity()}</td>
                    <td>${book.getDescription()}</td>
                    <td>
                        <button><a class="btn btn-primary text-decoration-none"
                                   href="/books?action=borrow&bookId=${book.getId()}">Borrow</a></button>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
