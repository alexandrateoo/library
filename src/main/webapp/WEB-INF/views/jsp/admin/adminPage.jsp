<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/17/2017
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>
         function openInNewTab(url) {
            var win = window.open(url, '_blank');
            win.focus();
        }
    </script>

    <style>
        #button1,#button2,#button3 {
            margin: auto;
            display: inline-block;
        }

        /* BUTTON STYLES */
        #button1,#button2,#button3 {
            padding: 16px 32px;
            font-family: helvetica;
            font-size: 16px;
            font-weight: 100;
            color: #fff;
            background: #587286;
            border: lightgrey;
            font-weight: 100;
            display: inline-block;
            margin-left: 100px;
        }

        #button2:hover, #button1:hover,#button3:hover {
            background: #3B5C76;
        }

        #container{
            text-align: center;
        }
    </style>

    <title>Admin's page</title>
    <div id="container">
        <button onclick="openInNewTab('admin/CRUDBooks')" type="button book-button" id="button1" >Book operations</button>
        <button onclick="openInNewTab('admin/CRUDUsers')" type="button user-button" id="button2">Users operations</button>
        <button onclick="openInNewTab('admin/generateReport')" type="button generate-button" id="button3">Generate reports</button>

    </div>
</head>
</body>
</html>
