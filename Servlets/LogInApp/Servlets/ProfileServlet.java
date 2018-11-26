import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Rohit
 */
public class ProfileServlet extends HttpServlet 
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
        
        Cookie ck[] = request.getCookies();
        
        if ( ck == null )
        {
            out.println("Please Login first!<hr/>");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("loggedInLinks.html");
            rd.include(request, response);
            
            out.println("Welcome to Profile:<br/>");
            out.println("Name: "+ck[0].getValue());
        }
    }
}
