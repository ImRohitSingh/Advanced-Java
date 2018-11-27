package studentjdbc;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Rohit
 */
public class StudentJDBC 
{
    final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    final static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String USERNAME = "uname";
    final static String PASSWORD = "pass"; // use your own usernames and passwords
    public static void main(String[] args) 
    {
        String createQuery, name;
        ResultSet rs;
        double m1, m2, m3, highestMarks = 0.0, totalMarks;
        int choice, id, highestId = -1, studentId;
        boolean found;
        try
        {
            Class.forName(JDBC_DRIVER);
            
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            Statement stmt = conn.createStatement();
            
            /*createQuery = "CREATE TABLE STUDENT ( "
                    + "STU_ID INT PRIMARY KEY, "
                    + "STU_NAME VARCHAR2(30) NOT NULL )";
            out.println(createQuery);
            stmt.executeUpdate(createQuery);
            out.println("\nSTUDENT table successfully created...\n");
            
            createQuery = "CREATE TABLE MARKS ( "
                    + "STU_ID INT NOT NULL, "
                    + "MARKS_SUBJECT1 NUMBER(5,2) NOT NULL, "
                    + "MARKS_SUBJECT2 NUMBER(5,2) NOT NULL, "
                    + "MARKS_SUBJECT3 NUMBER(5,2) NOT NULL, "
                    + "FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID) ON DELETE CASCADE ) ";
            out.println(createQuery);
            stmt.executeUpdate(createQuery);
            out.println("\nMARKS table successfully created...\n");*/
            
            do
            {
                out.println("\n---MENU---\n1.Insert Record\n2.Delete Record\n3.Display Record With Highest Marks\n4.Exit"
                        + "\nEnter Choice:");
                choice = new Scanner(System.in).nextInt();
                switch(choice)
                {
                    case 1: out.println("\nEnter ID: ");
                            id = new Scanner(System.in).nextInt();
                            createQuery = "SELECT * FROM STUDENT WHERE STU_ID = "+id;
                            rs = stmt.executeQuery(createQuery);
                            if( rs.next() )
                                out.println("\nID already exists in database...\n");
                            else
                            {
                                out.println("\nEnter name: ");
                                name = new Scanner(System.in).nextLine();
                                out.println("\nEnter marks in Subject1: ");
                                m1 = new Scanner(System.in).nextDouble();
                                out.println("\nEnter marks in Subject2: ");
                                m2 = new Scanner(System.in).nextDouble();
                                out.println("\nEnter marks in Subject3: ");
                                m3 = new Scanner(System.in).nextDouble();
                                
                                createQuery = "INSERT INTO STUDENT VALUES ( "+id+" , ' "+name+" ' ) ";
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData inserted successfully to STUDENT table...\n");
                                
                                createQuery = "INSERT INTO MARKS VALUES ( "+id+" , "+m1+" , "+m2+" , "+m3+" ) ";
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData inserted successfully to MARKS table...\n");
                            }   
                            break;
                    case 2: out.println("\nEnter ID: ");
                            id = new Scanner(System.in).nextInt();
                            createQuery = "SELECT * FROM STUDENT WHERE STU_ID = "+id;
                            rs = stmt.executeQuery(createQuery);
                            if( !rs.next() )
                                out.println("\nID does not exist in database...\n");
                            else
                            {
                                createQuery = "DELETE FROM STUDENT WHERE STU_ID = "+id;
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData deleted successfully from both tables...\n");
                            }
                            break;
                    case 3: createQuery = "SELECT * FROM MARKS";
                            rs = stmt.executeQuery(createQuery);
                            found = false;
                            while( rs.next() )
                            {
                                studentId = rs.getInt(1);
                                totalMarks = rs.getDouble(2) + rs.getDouble(3) + rs.getDouble(4);
                                
                                if ( !found )
                                {
                                    found = true;
                                    highestId = studentId;
                                    highestMarks = totalMarks;
                                }
                                else
                                {
                                    if( totalMarks > highestMarks )
                                    {
                                        highestId = studentId;
                                        highestMarks = totalMarks;
                                    }
                                }       
                            }
                            out.println(highestId+" "+highestMarks);
                            if( !found )
                                out.println("\nDatabase empty...\n");
                            else
                            {
                                createQuery = "SELECT * FROM STUDENT WHERE STU_ID = "+highestId;
                                rs = stmt.executeQuery(createQuery);
                                rs.next();
                                out.println("\nSTUDENT DETAILS:\nId: "+highestId+"\nName: "+rs.getString(2)+"\n"
                                        + "Marks Obtained: "+highestMarks);
                            }
                            break;
                    case 4: out.println("\nProcess ended by user...\n");
                            break;
                    default: out.println("\nInvalid choice. Re-enter please...\n");
                             break;
                }
            }
            while(choice!=4);
        }
        catch(ClassNotFoundException cnfe)
        {
            out.println("\nCould not connect to Oracle Driver...\n");
        }
        catch(SQLException sqe)
        {
            out.println("\nError accessing database!\n");
        }
    }
    
}
