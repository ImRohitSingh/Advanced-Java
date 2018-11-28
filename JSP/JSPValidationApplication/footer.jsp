<%-- 
    Document   : footer
    Created on : Nov 27, 2018, 9:43:34 PM
    Author     : Rohit
--%>

<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <footer align = "center">
            <i><% out.println(new Date().toString()); %></i>
        </footer>
    </body>
</html>
