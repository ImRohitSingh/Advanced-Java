<%-- 
    Document   : calculate
    Created on : Nov 18, 2018, 10:19:09 AM
    Author     : Rohit
--%>
<%@page errorPage = "error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate</title>
    </head>
    <body>
        <jsp:useBean id = "obj" class = "myPack.Calculator" />
        <jsp:setProperty name = "obj" property = "*" />
        <!-- property '*' automatically maps the form inputs to the bean variables -->
        <% char choice = request.getParameter("operation").charAt(0); %>
        
        <%=obj.getX()%>&nbsp;<%=choice%>&nbsp;<%=obj.getY()%>&nbsp;=&nbsp;
        <!-- will print 2 + 3 = 5 -->
        <%
            switch(choice)
            {
                case '+': out.println(obj.add());
                          break;
                case '-': out.println(obj.sub());
                          break;
                case '*': out.println(obj.mul());
                          break;     
                case '/': out.println(obj.div());
                          break;
                case '%': out.println(obj.mod());
                          break;
            }
          %>
          <br/><br/>
          <a href = "index.jsp">Return to home page</a>
          
    </body>
</html>
