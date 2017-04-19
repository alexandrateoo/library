<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/15/2017
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="../../fragments/headerUser.jsp" />
<div class="container">

    <form method="post" name="frm" action="/users/search/{criteria}">
        <table border="0" width="300" align="center" bgcolor="#e9f">
            <tr><td colspan=2 style="font-size:12pt;" align="center">
                <h3>Search Book</h3></td></tr>
            <tr>
                <td>: <input  type="text" name="criteria" id="criteria">
                </td></tr>
            <tr><td colspan=2 align="center">
                <input  type="submit" name="submit" value="criteria"></td></tr>
        </table>
    </form>

    <c:if test="${not empty bookSearchCriteria}">
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
            <c:forEach var="book" items="${bookSearchCriteria}">
                <tr>
                    <td>${book.ISBN}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>
                        <spring:url value="books/search" var="bookUrl"/>

                        <button class="btn btn-info" onclick="location.href='${bookUrl}'">Buy this book</button>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:if>

    </div>

    <jsp:include page="../../fragments/footer.jsp" />

</body>
</html>
