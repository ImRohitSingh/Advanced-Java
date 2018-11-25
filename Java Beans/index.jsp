<%-- 
    Document   : index
    Created on : Nov 25, 2018, 2:26:00 PM
    Author     : Rohit
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Details</title>
    </head>
    <body>
         <header>
            <h3>Name: Rohit Singh</h4>
            <h4>ID: 56EFJL3</h5>
        </header>
        <form action = "accept.jsp" method = "post">
            <p>Enter ID:</p>
            <input type = "text" name = "empId" required/>
            <p>Enter Name:</p>
            <input type = "text" name = "empName" required />
            <p>Marks in Algorithm: </p>
            <input type = "text" name = "marks1" required />
            <p>Marks in Java: </p>
            <input type = "text" name = "marks2" required />
            <p>Marks in Cryptography: </p>
            <input type = "text" name = "marks3" required /><br/><br/>
            <input type = "submit" value = "Submit" />
        </form>
        <br/><br/>
        <footer>
            <i><% Date d = new Date(); 
                  out.println(d);
               %></i>
        </footer>
    </body>
</html>
