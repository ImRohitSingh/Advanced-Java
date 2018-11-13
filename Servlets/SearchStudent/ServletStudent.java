import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author Rohit
 */
public class ServletStudent extends HttpServlet 
{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "jdbc";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        out = response.getWriter();
        
        String createQuery;
        ResultSet rs;
        
        try
        {
            Class.forName(JDBC_DRIVER);
			
            Connection conn = DriverManager.getConnection(JDBC_URL+DB_NAME,USERNAME,PASSWORD);
		
            Statement stmt = conn.createStatement();
            
            int id = Integer.parseInt(request.getParameter("id"));
            if(id < 1)
                throw new NumberFormatException();
            
            createQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+id;
            rs = stmt.executeQuery(createQuery);
            
            if(rs.next())
            {
                HttpSession session = request.getSession();
                session.setAttribute("sId", id);
                
                RequestDispatcher rd = request.getRequestDispatcher("ServletStudentInfo");
                rd.forward(request, response);
            }
            else
            {
                out.println("Searched ID not found.<br><br>");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
        }
        catch(ClassNotFoundException cnfe)
        {
            out.println("Error loading JDBC Driver.<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        catch(SQLException se)
        {
            out.println("Error accessing Database.<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        catch(NumberFormatException nfe)
        {
            out.println("Please enter valid values.<br><br>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }     
    }
}
