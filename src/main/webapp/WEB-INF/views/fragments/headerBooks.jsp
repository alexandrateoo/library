<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/18/2017
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/CRUDBooks" var="urlHome" />
<spring:url value="books/add" var="urlAddBooks" />

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Admin's page</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddBooks}">Add new book</a></li>
            </ul>
        </div>
    </div>
</nav>
