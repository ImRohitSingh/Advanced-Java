<%-- 
    Document   : header
    Created on : Nov 27, 2018, 9:41:25 PM
    Author     : Rohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h3 align = "center" >Rohit Singh | 16303010031</h3><br/>
            <%=session.getAttribute("errorMsg")%>
            <hr>
        </header>
    </body>
</html>
