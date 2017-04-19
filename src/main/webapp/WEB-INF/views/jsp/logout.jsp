<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/15/2017
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <style>
        #btn-primary{
            margin:auto;
            display:block;
        }

        /* BUTTON STYLES */
        #btn-primary{
            padding:16px 32px;
            font-family:helvetica;
            font-size:16px;
            font-weight:100;
            color:#fff;
            background: #587286;
            border:0;
            font-weight:100;
        }
        #btn-primary:hover{
            background: #3B5C76;
        }
        /* END OF BUTTON STYLES */


        #btn-block {
            width: 100%;
            display: block;
        }

        #btn-primary:visited {
            text-decoration: none;
        }

        #btn-primary:active {
            text-decoration: none;
        }

        a:link {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        a:active {
            text-decoration: none;
        }
    </style>

    <title>Logout Page</title>
</head>
<body>
<%--<security:authorize access="! isAuthenticated()">--%>
    <%--<a href="<spring:url value="/login"/>">--%>
        <%--<li id="btn-primary" class="${current == 'login' ? 'active' : '' }">Login</li>--%>
    <%--</a>--%>
<%--</security:authorize>--%>
<h2>
    Logout Successful!
</h2>

</body>
</html>
