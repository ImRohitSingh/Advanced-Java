import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author Rohit
 */
public class ServletStudentInfo extends HttpServlet 
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
        PrintWriter out = response.getWriter();
        
        String createQuery;
        ResultSet rs;
        
        try
        {
            Class.forName(JDBC_DRIVER);
			
            Connection conn = DriverManager.getConnection(JDBC_URL+DB_NAME,USERNAME,PASSWORD);
		
            Statement stmt = conn.createStatement();
        
            HttpSession session = request.getSession();
            int id = (int)session.getAttribute("sId");
            
            createQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+id;
            rs = stmt.executeQuery(createQuery);
            
            RequestDispatcher rd = request.getRequestDispatcher("studentinfo.html");
            rd.include(request, response);
            
            rs.next();
            
            out.println("<h4> Student ID: "+rs.getInt("STUDENT_ID")+"</h2><br/>");
            out.println("<h4> Student Name: "+rs.getString("STUDENT_NAME")+"</h2><br/>");
            out.println("<h4> Marks in JAVA: "+rs.getDouble("MARKS_JAVA")+"</h2><br/>");
            out.println("<h4> Marks in ALGO: "+rs.getDouble("MARKS_ALGO")+"</h2><br/>");
            out.println("<h4> Marks in CRYPTO: "+rs.getDouble("MARKS_CRYPTO")+"</h2><br/>");
            double totMarks = rs.getDouble("MARKS_JAVA") + rs.getDouble("MARKS_ALGO") +rs.getDouble("MARKS_CRYPTO");
            double avMarks = totMarks/3;
            out.println("<h4> Total Marks: "+totMarks+"</h2><br/>");
            out.println("<h4> Average Marks: "+avMarks+"</h2><br/><br/><br/>");
            
            out.println("<a href='index.html'> GO TO HOMEPAGE </a>");
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
    }
}
