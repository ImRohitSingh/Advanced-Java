<%-- 
    Document   : calculate
    Created on : Nov 25, 2018, 7:07:21 PM
    Author     : Rohit
--%>

<%@page errorPage = "calError.jsp" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculated</title>
    </head>
    <body>
        <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <jsp:useBean id = "obj" class = "packageCal.Calculator" />
        <jsp:setProperty name = "obj" property = "*" />
        
        <!--String c = request.getParameter("operator"); This could also may have been done. 
            But then the switch case would have to implemented in a different way. -->
        <% char c = request.getParameter("operator").charAt(0); %>
        
        <%=obj.getX()%>&nbsp;<%=c%>&nbsp;<%=obj.getY()%>&nbsp;=&nbsp;
        
        <%
            switch(c)
            {
                case '+':   out.print(obj.add());
                            break;
                case '-':   out.print(obj.minus());
                            break;
                case '*':   out.print(obj.multiply());
                            break;
                case '/':   out.print(obj.divide());
                            break;
                case '%':   out.print(obj.modulus());
                            break;
            }
            
        %>
        <br/><br/>
        <a href = "index.jsp">Return to home page</a>
        <br/><br/>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
</html>
