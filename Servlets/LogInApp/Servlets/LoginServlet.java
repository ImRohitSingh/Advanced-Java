import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Rohit
 */
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        if( password.equals("aaleya") )
        {
            RequestDispatcher rd = request.getRequestDispatcher("loggedInLinks.html");
            rd.include(request, response);
            
            out.println("<h4>Welcome "+name+"!</h4><br/>You have successfully logged in!");
            
            Cookie ck = new Cookie("name",name);
            response.addCookie(ck);
        }
        else
        {
            out.println("<br/>Username or Password error!<br/>");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }
}
