<%-- 
    Document   : validate
    Created on : Nov 27, 2018, 10:55:58 PM
    Author     : Rohit
--%>

<%@include file = "header.jsp"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate Page</title>
    </head>
    <body>
        <% int refreshes = Integer.parseInt(session.getAttribute("refreshes")+"");
           ++refreshes;
           session.setAttribute("refreshes", refreshes+"");
           
            if( refreshes > 3)
                response.sendRedirect("index.jsp");
            
            boolean errorFound = false;
            
            String name = request.getParameter("name");
            if( name.length() == 0 && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Name field cannot be left empty!</h4><br/>");
                response.sendRedirect("index.jsp");
            }
            
            String password = request.getParameter("password");
            if( password.length() == 0 && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Password field cannot be left empty!</h4><br/>");
                response.sendRedirect("index.jsp");
            }
            
            String confirmPassword = request.getParameter("confirmPassword");
            if( confirmPassword.length() == 0 && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Confirm Password field cannot be left empty!</h4><br/>");
                response.sendRedirect("index.jsp");
            }
            
            if( !confirmPassword.equals(password) && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Passwords do not match!</h4><br/>");
                response.sendRedirect("index.jsp");
            }
            
            String mobile = request.getParameter("mobile");
            if( mobile.length() == 0 && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Mobile Number field cannot be left empty!</h4></br>");
                response.sendRedirect("index.jsp");
            }
            
            if( mobile.length() != 10 && !errorFound )
            {
                errorFound = true;
                session.setAttribute("errorMsg", "<h4>Mobile Number must contain exactly 10 digits!</h4></br>");
                response.sendRedirect("index.jsp");
            }
            
            if( !errorFound )
            {
                try
                {
                    Integer.parseInt(mobile);
                    if( mobile.charAt(0) == '-' )
                        throw new NumberFormatException();
                }
                catch(NumberFormatException nfe)
                {
                    errorFound = true;
                    session.setAttribute("errorMsg", "<h4>Mobile Number must contain digits only!</h4></br>");
                    response.sendRedirect("index.jsp");
                }
            }
            out.print("<html><body>");
            out.print("<div align = 'center'>");
            out.println("<b>Name: "+name+"</b><br/>");
            
            String gender = request.getParameter("gender");
            if( gender.equals("Male") || gender.equals("Female") )
                out.println("<b>Gender: "+gender+"</b><br/>");
            
            out.println("<b>Mobile Number: "+mobile+"</b><br/>");
            try
            {
                int age = Integer.parseInt(request.getParameter("age"));
                if( age > 100 || age <= 0 )
                    throw new NumberFormatException();
                out.println("<b>Voting Eligibilty: </b>");
                if( age >= 18 )
                    out.print("<i>Yes</i>");
                else
                    out.print("<i>No</i>");
            }
            catch(NumberFormatException nfe)
            {
                out.println("<br/><u>Invalid age entered!</u><br/>");
            }
            out.print("<hr/></div></body></html>");
        %>
    </body>
</html>
<%@include file = "footer.jsp"  %>