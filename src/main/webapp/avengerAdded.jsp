<%-- 
    Document   : avengerAdded
    Created on : Nov 14, 2019, 3:31:06 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Avenger Added</title>
    </head>
    <body>
        <div>
        <%--My clunky else if--%>
        <c:if test="${!empty error}">
            <h2>Error: ${error}</h2>
        </c:if>
            <c:if test="${empty error}">
            <h1>Avenger Added</h1>
        </c:if>
            <br>
            <form action='index.html'>
                <input class='back' type='submit' value='Back'>
            </form>
        </div>
</body>
</html>
