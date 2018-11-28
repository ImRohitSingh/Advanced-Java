<%-- 
    Document   : index
    Created on : Nov 27, 2018, 9:41:09 PM
    Author     : Rohit
--%>
<%@include file = "header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%
            session.setAttribute("refreshes", "0");
            session.setAttribute("errorMsg", "");
        %>
        
        <form  action = "validate.jsp" method = "POST">
            Name: *&nbsp; <input type = "text" name = "name" /><br/><br/>
            Password: *&nbsp; <input type = "password" name = "password" /><br/><br/>
            Confirm Password: *&nbsp; <input type = "password" name = "confirmPassword" /><br/><br/>
            Age: &nbsp; <input type = "text" name = "age" /><br/><br/>
            Mobile Number: *&nbsp; <input type = "text" name = "mobile" /><br/><br/>
            <select name = "gender">
                <option value = "Male">Male</option>
                <option value = "Female">Female</option>
                <option value = "undefined">Do not wish to specify</option>
            </select><br/><br/>
            <input type = "submit" value = "Register" /><br/>
        </form>
        <hr>
    </body>
</html>
<%@include file = "footer.jsp" %>