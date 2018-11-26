import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Rohit
 */
public class LogoutServlet extends HttpServlet 
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
        
        RequestDispatcher rd = request.getRequestDispatcher("loggedOutLinks.html");
        rd.include(request, response);
        
        Cookie ck = new Cookie("name", "");
        ck.setMaxAge(0);
        response.addCookie(ck);
        
        out.println("<br/>You are successfully logged out!<br/>");
    }
}
