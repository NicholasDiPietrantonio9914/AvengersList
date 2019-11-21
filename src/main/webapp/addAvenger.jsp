<%-- 
    Document   : addAvenger
    Created on : Nov 14, 2019, 3:30:15 PM
    Author     : Nicholas Di Pietrantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="avng" uri="/WEB-INF/tlds/avengers_tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
        <title>Add Avenger</title>
    </head>
    <body>
        <div>
            <h1>Add an Avenger</h1>
            <form method='POST' action='AddAvenger.do'>
                <label>Name: </label><input type='text' name='avengerName'>
                <br>
                <label>Description: </label><input type='text' name='avengerDesc'>
                <br>
                <label>Power Source: </label><avng:powerSourceList></avng:powerSourceList>
                <br>
                <br>
                <input type='submit' class='submit'>
                <br>
                <br>
                <input type='submit' class='back' value='Back' formaction='index.html'>

            </form>
        </div>

    </body>
</html>
