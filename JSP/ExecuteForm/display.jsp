<%-- 
    Document   : display
    Created on : Nov 15, 2018, 10:01:29 PM
    Author     : Rohit
--%>
<%@page errorPage = "error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
    </head>
    <body>
        <% 
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            
            session.setAttribute("n1", n1);
            session.setAttribute("n2", n2);
            
            int n3 = Integer.parseInt(config.getInitParameter("n3"));
            int result = n1/n2;
            
            out.println(n1 + " / " + n2 + " = " + result + "<br><br>");
            
            if (result > n3)
                out.println(result + " is less than " + n3);
            else if (result < n3)
                out.println(result + " is greater than " + n3);
            else
                out.println(result + " is equal to " + n3);
        %>
    </body>
</html>
