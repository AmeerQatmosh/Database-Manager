package signUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import logger.logger;

public class signUp {
	static String  ID ,Name ,Password ;
	static int  Type;
	static logger log ;
	public static void signup (Connection connection) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter ID :");
		ID = sc.nextLine();
		 try {
	    	  Statement statement= connection.createStatement();
	    	  ResultSet resultSet= statement.executeQuery("select * from user");
	    	  while(resultSet.next())
	    	  {
	    		  if(resultSet.getString(1).equals(ID)) {
	    			  logger.logWarning("Sign-Up Into System Failed");
	    			  System.out.println("The ID Already Existed, Try Another One");
	    			  return ;
	    		  }
	    	  }
		} catch (Exception e) {
			  logger.logError(e.getMessage());
			  System.out.print(e.getMessage());
		}
		System.out.println("Enter Name :");
		Name = sc.nextLine();

		System.out.println("Enter Password :");
		Password = sc.nextLine();

		System.out.println("Enter Type :");
		Type = sc.nextInt();

		try {
			String sqlQuery = "insert into user (id,name,password,Type) VALUES (?,?,? ,?)";
			PreparedStatement ps;
			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, ID) ;
			ps.setString(2, Name) ;
			ps.setString(3, Password) ;
			ps.setInt(4, Type) ;
			ps.executeUpdate();
			logger.logInfo("Sign-Up new user into system Successfully");
			
		} catch (SQLException e) {
			logger.logError(e.getMessage());
			e.printStackTrace();
		}
	}
}
