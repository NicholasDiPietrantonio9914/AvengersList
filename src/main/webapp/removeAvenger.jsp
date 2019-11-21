<%-- 
    Document   : removeAvenger
    Created on : Nov 20, 2019, 11:58:59 AM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Remove Avenger</title>
    </head>
    <body>
        <div>
        <h1>Enter Avenger to Remove</h1>
        <form method="POST" action="RemoveAvenger.do">
            <label>Password: </label><input type="text" name="password">
            <br>
            <br>
            <label>Avenger Name: </label><input type="text" name="avengerName">
            <br>
            <br>
            <input class='submit' type="submit">
            <br>
            <br>
            <input type='submit' class='back' value='Back' formaction='index.html'>
        </form>
        </div>
    </body>
</html>
