import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Rohit
 */
public class Validate extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        
        String name = request.getParameter("name");
        if( name.length() == 0 )
        {
            out.println("<br/><b><i>Name field cannot be left empty!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        String uname = request.getParameter("uname");
        if( uname.length() == 0 )
        {
            out.println("<br/><b><i>Username field cannot be left empty!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        String password = request.getParameter("password");
        if( password.length() == 0 )
        {
            out.println("<br/><b><i>Password field cannot be left empty!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        String confirmPassword = request.getParameter("confirmPassword");
        if( confirmPassword.length() == 0 )
        {
            out.println("<br/><b><i>Confirm Password field cannot be left empty!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        if( !password.equals(confirmPassword))
        {
            out.println("<br/><b><i>Passwords do not match!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        String mobile = request.getParameter("mobile");
        if( mobile.length() == 0 )
        {
            out.println("<br/><b><i>Mobile Number field cannot be left empty!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        if( mobile.length() != 10 )
        {
            out.println("<br/><b><i>Mobile Number needs to be of exactly 10 digits!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        try
        {
            Integer.parseInt(mobile);
            if ( mobile.charAt(0) == '-' )
                throw new NumberFormatException();
        }
        catch(NumberFormatException nfe)
        {
            out.println("<br/><b><i>Mobile Number needs to be composed of digits only!</i></b><hr>");
            rd.include(request, response);
            return;
        }
        
        Cookie cookieList[] = request.getCookies();
        int index = 1;
        if ( cookieList != null )
        {
            for( Cookie c: cookieList)
            {
                String currCookie = c.getValue();
                if( currCookie.equals(uname) )
                {
                    out.println("<br/><b><i>Username already taken!</i></b><hr>");
                    rd.include(request, response);
                    return;
                }
                ++index;
            }
        }
        Cookie set = new Cookie( index + "" , uname );
        response.addCookie(set);
        
        rd = request.getRequestDispatcher("/Display");
        rd.forward(request, response);
    }

    

}
