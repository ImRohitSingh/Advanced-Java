<%-- 
    Document   : error
    Created on : Nov 15, 2018, 10:17:51 PM
    Author     : Rohit
--%>
<%@page isErrorPage = "true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <% 
            String n1 = session.getAttribute("n1") + "";
            String n2 = session.getAttribute("n2") + "";
            out.println(n1 + "/" + n2 + ": Division by zero error!"); 
        %>
    </body>
</html>
