import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Rohit
 */
public class ServletDemo extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            
            Cookie ck0 = new Cookie("demo","X");
            Cookie ck1 = new Cookie("ID",id+"");
            Cookie ck2 = new Cookie("name",name);
            Cookie ck3 = new Cookie("dept","");
            Cookie ck4 = new Cookie("clg","H.I.T.K");
            
            ck3.setValue("MCA");
            
            ck0.setMaxAge(0);
            
            response.addCookie(ck1);
            response.addCookie(ck2);
            response.addCookie(ck3);
            response.addCookie(ck4);
            
            RequestDispatcher rd = request.getRequestDispatcher("CookieDisplay");
            rd.forward(request,response);
            
        }
        catch(NumberFormatException nfe)
        {
            out.println("<br>Please enter valid values only.<br/>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        
    }

}
