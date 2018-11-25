package empjdbc;
import java.sql.*;
import static java.lang.System.out;
import java.util.Scanner;
/**
 *
 * @author Rohit
 */
public class EmpJDBC 
{
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USERNAME = "jeet93";
    static final String PASSWORD = "3j4doNKW#$";
    public static void main(String[] args) 
    {
        ResultSet rs;
        String createQuery, name;
        int choice, id;
        float sal;
        boolean dropped = false, check;
        try
        {
            Class.forName(JDBC_DRIVER);
            
            Connection conn = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
            
            Statement stmt = conn.createStatement();
            
            /*createQuery = "CREATE TABLE EMPL ( "
                    + "EMP_ID INT PRIMARY KEY,"
                    + "EMP_NAME VARCHAR2(30),"
                    + "EMP_SALARY FLOAT)";
            out.println(createQuery);
            stmt.executeUpdate(createQuery);
            out.println("\nEMPL table successfully created...\n");*/
            do
            {
                out.println("\n----MENU---\n1.Insert Record\n2.Delete Record\n3.Update Record\n4.DROP TABLE\n5.Exit\n"
                        + "Enter choice:");
                choice = new Scanner(System.in).nextInt();
                switch(choice)
                {
                    case 1: if(dropped)
                            {
                                out.println("\nEMPL table has already been dropped...\n");
                                break;
                            }
                            out.println("\nEnter ID: ");
                            id = new Scanner(System.in).nextInt();
                            check = false;
                            createQuery = "SELECT * FROM EMPL WHERE EMP_ID ="+id;
                            rs = stmt.executeQuery(createQuery);
                            
                            if(rs.next())
                                check = true;
                            
                            if(check)
                                out.println("\nID already exists in database...\n");
                            else
                            {
                                out.println("\nEnter Name: ");
                                name = new Scanner(System.in).nextLine();
                                out.println("\nEnter Salary: ");
                                sal = new Scanner(System.in).nextFloat();
                                
                                createQuery = "INSERT INTO EMPL VALUES ( "+id+" , '"+name+"' , "+sal+")";
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData successfully inserted...\n");
                            }
                            
                            
                            break;
                    case 2: if(dropped)
                            {
                                out.println("\nEMPL table has already been dropped...\n");
                                break;
                            }
                            out.println("\nEnter ID: ");
                            id = new Scanner(System.in).nextInt();
                            createQuery = "SELECT * FROM EMPL WHERE EMP_ID ="+id;
                            rs = stmt.executeQuery(createQuery);
                            
                            if(!rs.next())
                                out.println("\nID not found in database...\n");
                            else
                            {   
                                createQuery = "DELETE FROM EMPL WHERE EMP_ID = "+id;
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData successfully deleted...\n");
                            }
                            break;
                    case 3: if(dropped)
                            {
                                out.println("\nEMPL table has already been dropped...\n");
                                break;
                            }
                            out.println("\nEnter ID: ");
                            id = new Scanner(System.in).nextInt();
                            createQuery = "SELECT * FROM EMPL WHERE EMP_ID ="+id;
                            rs = stmt.executeQuery(createQuery);
                            
                            if(!rs.next())
                                out.println("\nID not found in database...\n");
                            else
                            {   
                                out.println("\nEnter New Salary: ");
                                sal = new Scanner(System.in).nextFloat();
                                createQuery = "UPDATE EMPL SET EMP_SALARY = "+sal+" WHERE EMP_ID = "+id;
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nData successfully updated...\n");
                            }
                            break;
                    case 4: if(dropped)
                                out.println("\nEMPL table has already been dropped...\n");
                            else
                            {
                                dropped = true;
                                createQuery = "DROP TABLE EMPL";
                                out.println(createQuery);
                                stmt.executeUpdate(createQuery);
                                out.println("\nEMPL table successfully dropped...\n");
                            }
                            break;
                    case 5: out.println("\nProccess ended by user...\n");
                            break;
                    default: out.println("\nInvalid Choice. Re-enter please...\n");
                             break;
                }
            }
            while(choice!=5);
        }
        catch(ClassNotFoundException cnfe)
        {
            out.println("\nError loading Oracle Driver...\n");
        }
        catch(SQLException sqe)
        {
            out.println("\nError accessing Database...\n");
        }
    }
    
}
