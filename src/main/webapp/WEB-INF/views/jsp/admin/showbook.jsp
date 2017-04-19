<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/18/2017
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../fragments/headerBooks.jsp" />

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Book's Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ISBN</label>
        <div class="col-sm-10">${book.ISBN}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Title</label>
        <div class="col-sm-10">${book.title}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Author</label>
        <div class="col-sm-10">${book.author}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Quantity</label>
        <div class="col-sm-10">${book.quantity}</div>
    </div>



</div>

<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>