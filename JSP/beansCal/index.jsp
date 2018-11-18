<%-- 
    Document   : index
    Created on : Nov 18, 2018, 9:59:09 AM
    Author     : Rohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <form action = "calculate.jsp" method = "post">
            <p>Enter 2 numbers:</p><br/>
            <input type = "number" name = "x"/>&nbsp;
            <input type = "number" name = "y"/><br/><br/>
            <select name = "operation">
                <option value = "+">ADD</option>
                <option value = "-">SUBTRACT</option>
                <option value = "*">MULTIPLY</option>
                <option value = "/">DIVIDE</option>
                <option value = "%">MODULUS</option>
            </select><br/><br>
            <input type = "submit" value = "Submit"/>
        </form>
    </body>
</html>
