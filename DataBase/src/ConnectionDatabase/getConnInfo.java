package ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import logIn.logIn;
import logger.logger;

public class getConnInfo {
	private static String User;
	private static String Password;
	private static String URL ;
	private static int Port;


	public static void getNewinfo() {
		Scanner sc= new Scanner(System.in);
	System.out.println("Enter The Data Base Information You Need To Connect With : ");
	System.out.println("Enter User : ");
   	User= sc.nextLine();
   	System.out.println("Enter Password : ");
 	  Password=sc.nextLine();
 	 System.out.println("Enter URL : ");
	   URL=sc.nextLine();
	  System.out.println("Enter Port number : ");
	  Port=sc.nextInt();
	}
	
	public static void getOldinfo(Connection connection) {
		String ID=logIn.ID;
		Scanner sc= new Scanner(System.in);
		try {
			Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM dbinformation WHERE user_id='"+ID+"'");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();
	        for (int i =1;i<=columnCount;i++){
	        	if(i!=2) {
	        		System.out.print(rsmd.getColumnName(i)+"\t");
	        	}
            }
	        System.out.println();
	        while (rs.next()) {
                for (int i =1;i<=columnCount;i++){
                	if(i!=2) {
                		System.out.print(rs.getString(i)+"\t");
                	}
                }
                System.out.println();
            }
	        System.out.println("Enter Connection ID");
	        int dbID = sc.nextInt();
	        Statement stmt2 = connection.createStatement();
	        ResultSet rs2 = stmt2.executeQuery("SELECT * FROM dbinformation WHERE id='"+dbID+"'"); 
	        while(rs2.next()) {
	        	 User= rs2.getString(5);
	 	     	Password=rs2.getString(4);
	 	    	URL=rs2.getString(3);
	 	    	Port=rs2.getInt(6);
	        }
		}
		catch(SQLException e) {
            logger.logError(e.getMessage());
            System.out.println("SQL Exception Occurred" + e);
        }
	}
	public static String getUser() {
		return User ;
		}
	public static String getPassword() {
		return Password ;
		}
	public static String getURL() {
		return URL ;
		}
	public static int getPort() {
		return Port ;
		}	
}
