<%-- 
    Document   : index
    Created on : Nov 25, 2018, 6:57:20 PM
    Author     : Rohit
--%>

<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <form action = "calculate.jsp" method = "post">
            <input type = "number" name = "x" required /><br/><br/>
            <input type = "number" name = "y" required /><br/><br/>
            <select name = "operator" >
                <option value = "+">+</option>
                <option value = "-">-</option>
                <option value = "*">*</option>
                <option value = "/">/</option>
                <option value = "%">%</option>
            </select>&nbsp;
            <input type = "submit" value = "Submit"  /><br/><br/>
        </form>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
</html>
