<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<div class="container">
<h1 class="text-center my-4">Borrow a book</h1>
<form method="post">
        <table class="table table-hover">
            <tr>
                <td>Book ID:</td>
                <td>${requestScope.book.getId()}</td>
            </tr>
            <tr>
                <td>Book Name:</td>
                <td>${requestScope.book.getName()}</td>
            </tr>
            <tr>
                <td>Student Name</td>
                <td>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Select student</option>
                        <option value="1">Student A</option>
                        <option value="2">Student B</option>
                        <option value="3">Student C</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Borrowed Date:</td>
                <td><input type="datetime-local" id="borrowedDate" name="borrowedDate"></td>
            </tr>
            <tr>
                <td>Returned Date</td>
                <td><input type="datetime-local" id="returnedDate" name="returnedDate"></td>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Borrow</button>
                </td>
                <td>
                    <c:if test='${requestScope["message"] != null}'>
                        <span class="message" style="color: green">${requestScope["message"]}</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/books" class="btn btn-primary">Cancel</a>
                </td>
                <td>
                    <c:if test='${requestScope["message"] != null}'>
                        <span class="message">${requestScope["message"]}</span>
                    </c:if>
                </td>
            </tr>
        </table>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
