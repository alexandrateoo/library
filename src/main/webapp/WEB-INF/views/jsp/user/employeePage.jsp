<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/17/2017
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../fragments/headerUser.jsp"/>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Books</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.ISBN}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.quantity}</td>
                <td>
                    <spring:url value="books/${book.ISBN}/buybook" var="buyUrl"/>

                    <button class="btn btn-danger" onclick="this.disabled=true;post('${buyUrl}')">Buy this book</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../../fragments/footer.jsp"/>

</body>
</html>