<%-- 
    Document   : calError
    Created on : Nov 25, 2018, 7:18:47 PM
    Author     : Rohit
--%>

<%@page import="java.util.Date"%>
<%@page isErrorPage = "true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <h3>Division by 0 error!</h3>
        <a href = "index.jsp">Return to home page</a>
        <br/><br/>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
    
</html>
