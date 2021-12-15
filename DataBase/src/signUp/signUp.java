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
	static int  type; 
	static logger log ;
	public static void signup (Connection db) {
		Scanner in= new Scanner(System.in);
		System.out.print("enter ID :");
		ID = in.nextLine();
		 try {
	    	  Statement statement= db.createStatement();  
	    	  ResultSet resultSet= statement.executeQuery("select * from user");  
	    	  while(resultSet.next())
	    	  {
	    		  if(resultSet.getString(1).equals(ID)) {
	    			  logger.logWarning("Sign-Up Into System Failed");
	    			  System.out.println("The ID already exitsed , Try another one");
	    			  return ;
	    		  }
	    	  }
		} catch (Exception e) {
			  logger.logError(e.getMessage());
			  System.out.print(e.getMessage());
		}
		System.out.print("enter name :");
		Name = in.nextLine();

		System.out.print("enter password :");
		Password = in.nextLine();

		System.out.print("enter type :");
		type = in.nextInt();
		
		
		try {
			String sql = "insert into user (id,name,password,type) VALUES (?,?,? ,?)";

			PreparedStatement ps;

			ps = db.prepareStatement(sql);


			ps.setString(1, ID) ;
			ps.setString(2, Name) ;
			ps.setString(3, Password) ;
			ps.setInt(4, type) ;
			int row = ps.executeUpdate();
			logger.logInfo("Sign-Up new user into system Successfully");
			
		} catch (SQLException e) {
			logger.logError(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
