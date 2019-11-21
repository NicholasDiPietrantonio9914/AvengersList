<%-- 
    Document   : avengerRemoved
    Created on : Nov 20, 2019, 12:37:56 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Avenger Removed</title>
    </head>
    <body>
        <div>
            <c:if test="${!empty error}">
                <h2>Error: ${error}</h2>
            </c:if>
            <c:if test="${empty error}">
                <h1>Avenger Removed</h1>
            </c:if>
            <br>
            <form action='index.html'>
                <input class='back' type='submit' value='Back'>
            </form>
        </div>
    </body>
</html>
