import java.sql.*;
import static java.lang.System.out;

public class PreparedStatements 
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_NAME = "jdbc";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	public static void main(String[] args) 
	{
		String createQuery;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName(JDBC_DRIVER);
			
			Connection conn = DriverManager.getConnection(JDBC_URL + DB_NAME, USERNAME, PASSWORD);
			
			createQuery = "SELECT * FROM STUDENT";
			out.println(createQuery);
			stmt = conn.prepareStatement(createQuery);
			rs = stmt.executeQuery();
			System.out.println("\n\nID \t\t NAMES \t\t\t\t\t JAVA \t\t ALGO \t\t CRYPTO \n");
			while(rs.next())
				System.out.print(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t"+rs.getDouble(4)+"\t\t"+rs.getDouble(5)+"\n");
			
			stmt = conn.prepareStatement("SELECT * FROM STUDENT WHERE MARKS_JAVA > ? AND MARKS_CRYPTO > ?");
			stmt.setDouble(1, 85);
			stmt.setDouble(2, 80);
			rs = stmt.executeQuery();
			System.out.println("\n\nID \t\t NAMES \t\t\t\t\t JAVA \t\t ALGO \t\t CRYPTO \n");
			while(rs.next())
				System.out.print(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t"+rs.getDouble(4)+"\t\t"+rs.getDouble(5)+"\n");
			
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

}
