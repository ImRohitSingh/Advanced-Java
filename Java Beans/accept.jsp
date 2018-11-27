<%-- 
    Document   : accept
    Created on : Nov 25, 2018, 2:33:15 PM
    Author     : Rohit
--%>
<%@page errorPage = "error.jsp" %>
<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>       
        <%  try
            {
                int x = Integer.parseInt(request.getParameter("empId"));
            }
            catch(NumberFormatException nfe)
            {
                session.setAttribute("error", "id");
                throw nfe;
            }
            try
            {
                float m1 = Float.parseFloat(request.getParameter("marks1"));
                float m2 = Float.parseFloat(request.getParameter("marks2"));
                float m3 = Float.parseFloat(request.getParameter("marks3"));
            }
            catch(NumberFormatException nfe)
            {
                session.setAttribute("error", "marks");
                throw nfe;
            }
        %>
        <jsp:useBean id = "obj" class = "myPackage.Student">
            <jsp:setProperty name = "obj" property = "*" />
        </jsp:useBean>
        
        <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <h5>Requested Details</h5>
        <p>ID: <%=obj.getEmpId()%></p>
        <p>Name: <%=obj.getEmpName()%></p>
        <p>Marks in Algorithm: <%=obj.getMarks1()%></p>
        <p>Marks in Java: <%=obj.getMarks2()%></p>
        <p>Marks in Cryptography: <%=obj.getMarks3()%></p>
        <p>Average Marks: <%=obj.average()%></p>
        <a href = "index.jsp" >Return to homepage</a>
        <br/><br/>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
</html>
