
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Rohit
 */
public class Display extends HttpServlet 
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
        
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        int age = Integer.parseInt(request.getParameter("age"));
        
        out.print("<html><body>");
            out.println("<div align = 'center'>Name: "+name+"<br/>"
                    + "Mobile Number: "+mobile+"<br/>");
        if( age < 18 )
            out.println("<i>Not eligible to vote!</i>");
        else
            out.println("<i>Eligible to vote!</i>");
        out.print("</div></body></html>");
    }
}
