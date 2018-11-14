import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Rohit
 */
public class CookieDisplay extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        Cookie ck[] = request.getCookies();
        out.println("<h3>Requested Cookies are: <br/></h3>");
        for(Cookie c : ck)
            out.println("<div><b>"+c.getName()+"</b> : <i>"+c.getValue()+"</i></div>");
            
        out.println("</body></html>");
    }

}
