import java.sql.*;
import static java.lang.System.out;
import java.util.Scanner;

public class StudentDatabaseMySQL 
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_NAME = "jdbc";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	public static void main(String[] args) 
	{
		String createQuery, sName;
		ResultSet rs;
		int id, choice, rows, i = 0, ids[], maxInd;
		double mJava, mAlgo, mCrypto, totalM[], max;
		Scanner obj = new Scanner(System.in);
		boolean check, dropped = false;
		
		try
		{
			Class.forName(JDBC_DRIVER);
			
			Connection conn = DriverManager.getConnection(JDBC_URL+DB_NAME,USERNAME,PASSWORD);
		
			Statement stmt = conn.createStatement();
			
			/*
			// creating table
			createQuery = "CREATE TABLE STUDENT ( " +
							"STUDENT_ID INTEGER PRIMARY KEY,"+
								"STUDENT_NAME VARCHAR(30),"+
									"MARKS_JAVA DOUBLE,"+
										"MARKS_ALGO DOUBLE,"+
											"MARKS_CRYPTO DOUBLE )";
			out.println(createQuery);
			stmt.executeUpdate(createQuery);
			out.println("STUDENT table successfully created..."); 
			*/
			
			do
			{
				out.println("\n----MENU----\n1.Display all Records"
						+ "\n2. Add a record\n"
						+ "3. Delete a record\n"
						+ "4. Display records of best student\n"
						+ "5. Scale up marks in Algorithm\n"
						+ "6. Delete all rows\n"
						+ "7. DROP table\n"
						+ "8. Exit\n"
						+ "Enter choice: ");
				choice = obj.nextInt();
				switch(choice)
				{
					case 1: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
							createQuery = "SELECT * FROM STUDENT";
							rs = stmt.executeQuery(createQuery);
							check = false;
							if(rs.next())
								check = true;
							
							if(check)
							{
								createQuery = "SELECT * FROM STUDENT";
								out.println("\n"+createQuery+"\n");
								rs = stmt.executeQuery(createQuery);
								System.out.println("\n\nID \t\t NAMES \t\t\t\t\t JAVA \t\t ALGO \t\t CRYPTO \n");
		            			while(rs.next())
		            				System.out.print(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t\t"+rs.getDouble(3)+"\t\t"+rs.getDouble(4)+"\t\t"+rs.getDouble(5)+"\n");
							}
							else
								out.println("\nNothing to display...\n");
							break;
					case 2: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
					
							out.println("\nEnter ID: ");
							id = obj.nextInt();
							
							createQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+id;
							rs = stmt.executeQuery(createQuery);
							check = false;
							
							if(rs.next())
								check = true;
							
							if(check)
								out.println("\nID already exists...\n");
							else
							{
								out.println("\nEnter Name: ");
								obj.nextLine();
								sName = obj.nextLine();
								out.println("\nEnter marks in JAVA: ");
								mJava = obj.nextDouble();
								out.println("\nEnter marks in ALGORITHM: ");
								mAlgo = obj.nextDouble();
								out.println("\nEnter marks in CRYPTOGRAPHY: ");
								mCrypto = obj.nextDouble();
								createQuery = "INSERT INTO STUDENT VALUES ( "+id+" , '"+sName+"' , "+mJava+" , "+mAlgo+" , "+mCrypto+" )";
								out.println(createQuery);
								stmt.executeUpdate(createQuery);
								out.println("\nRecord successfully inserted...\n");
							}
							break;
					case 3: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
							out.println("\nEnter ID: ");
							id = obj.nextInt();
					
							createQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+id;
							rs = stmt.executeQuery(createQuery);
							check = false;
							
							if(rs.next())
								check = true;
							
							if(!check)
								out.println("\nID does not exists...\n");
							else
							{
								createQuery = "DELETE FROM STUDENT WHERE STUDENT_ID = "+id;
								out.println(createQuery);
								stmt.executeUpdate(createQuery);
								out.println("\nRecord successfully deleted...\n");
							}
							break;
					case 4: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
							createQuery = "SELECT * FROM STUDENT";
							rs = stmt.executeQuery(createQuery);
							check = false;
							if(rs.next())
								check = true;
							
							if(!check)
								out.println("\nNo data retrieved...\n");
							else
							{
								rows = 0;
								createQuery = "SELECT * FROM STUDENT";
								rs = stmt.executeQuery(createQuery);
								while(rs.next())
									++rows;
								
								totalM = new double[rows];
								ids = new int[rows];
								
								createQuery = "SELECT * FROM STUDENT";
								rs = stmt.executeQuery(createQuery);
								while(rs.next())
								{
									totalM[i] = rs.getDouble(3) + rs.getDouble(4) + rs.getDouble(5);
									ids[i] = rs.getInt(1);
									++i;
								}	
								
								i = 0;
								max = totalM[0];
								maxInd = ids[0];
								for( i = 0; i < totalM.length; ++i )
									if( totalM[i] > max )
									{
										max = totalM[i];
										maxInd = ids[i];
									}
								
								createQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+maxInd;
								out.println(createQuery);
								rs = stmt.executeQuery(createQuery);
								
								System.out.println("\n\nID \t\t NAME \n");
		            			while(rs.next())
		            				System.out.print(rs.getInt(1)+"\t\t"+rs.getString(2)+"\n");
							}
							break;
					case 5: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
					
							createQuery = "UPDATE STUDENT SET MARKS_ALGO = MARKS_ALGO + 5 WHERE MARKS_ALGO < 96";
							out.println(createQuery);
							stmt.executeUpdate(createQuery);
							out.println("\nUpdated successfully...\n");
							break;
					case 6: if(dropped)
							{
								out.println("\nSTUDENT table does not exist in database...\n");
								break;
							}
					
							createQuery = "DELETE FROM STUDENT";
							out.println(createQuery);
							stmt.executeUpdate(createQuery);
							out.println("\nSTUDENT table emptied...\n");
							break;
					case 7: if(!dropped)
							{	
								dropped = true;
							createQuery = "DROP TABLE STUDENT";
					
							out.println(createQuery);
							stmt.executeUpdate(createQuery);
							out.println("STUDENT table successfully dropped...");
							}
							else
								out.println("\nSTUDENT table does not exist in database...\n");
							break;
					case 8: out.println("\nPLEASURE TO SERVE YOU!!\n");
							break;
					default: out.println("\nINVALID CHOICE...\n");
				}
			}
			while(choice != 8);
		}
		catch(ClassNotFoundException cnfe)
		{
			out.println("Error loading MySQL Driver!");
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			out.println("Error accessing Database!");
		}
	}

}
