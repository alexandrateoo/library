<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/17/2017
  Time: 11:38 PM
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

    <c:choose>
        <c:when test="${bookForm['new']}">
            <h1>Add Book</h1>
        </c:when>
        <c:otherwise>
            <h1>Update Book</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/books" var="bookActionUrl" />

    <form:form class="form-horizontal" method="post"  action="${bookActionUrl}" modelAttribute="bookForm">

        <spring:bind path="ISBN">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">ISBN</label>
                <div class="col-sm-10">
                    <form:input path="ISBN" type="text" class="form-control " id="ISBN" placeholder="ISBN" />
                    <form:errors path="ISBN" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <form:input path="title" type="text" class="form-control " id="title" placeholder="title" />
                    <form:errors path="title" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="author">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Author</label>
                <div class="col-sm-10">
                    <form:input path="author" class="form-control" id="author" placeholder="Author" />
                    <form:errors path="author" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="genre">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Genre</label>
                <div class="col-sm-5">
                    <form:select path="genre" items="${genreList}" multiple="true" size="5" class="form-control" />
                    <form:errors path="genre" class="control-label" />
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="quantity">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Quantity</label>
                <div class="col-sm-10">
                    <form:input path="quantity" rows="5" class="form-control" id="quantity" placeholder="Quantity" />
                    <form:errors path="quantity" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Price</label>
                <div class="col-sm-10">
                    <form:input path="price" rows="5" class="form-control" id="price" placeholder="Price" />
                    <form:errors path="price" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${userForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../../fragments/footer.jsp" />

</body>
</html>