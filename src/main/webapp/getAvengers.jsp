<%-- 
    Document   : getAvengers
    Created on : Nov 14, 2019, 3:30:45 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Get Avengers</title>
    </head>
    <body>
        <div>
            <h1> Here are the avengers:</h1>

            <c:if test="${!empty error}">
                <h2>Error: ${error}</h2>
            </c:if>

            <c:forEach var = "avenger" items = "${avengers}">
                <h2>${avenger.avengerName}, ${avenger.description}</h2>
                <p>Power Source: ${avenger.powerSource.description}</p>
            </c:forEach>
            <br>
            <form action='index.html'>
                <input class='back' type='submit' value='Back'>
            </form>
        </div>
    </body>
</html>
