<%-- 
    Document   : error
    Created on : Nov 25, 2018, 3:00:08 PM
    Author     : Rohit
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
         <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <h3>Please enter integer values for Student ID and floating point values for Marks!</h3>
        <a href = "index.jsp" >Return to homepage</a>
        <br/><br/>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
</html>
