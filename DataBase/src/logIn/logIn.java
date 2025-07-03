package logIn;

import logger.logger;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class logIn {
	public static String ID ;
	
	public static int logIn(Connection connection)
	{
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter Your ID : ");
		ID = sc.nextLine();
		System.out.println("Enter Your Password : ");
	    String Password = sc.nextLine();
	    
      try {
    	  Statement statement= connection.createStatement();  
    	  ResultSet resultSet= statement.executeQuery("select * from user");  

    	  while(resultSet.next())
    	  {
    		  if(resultSet.getString(1).equals(ID) && resultSet.getString(3).equals(Password)) {
				  logger.logInfo("Log-in Into System Successfully");
				  return resultSet.getInt(4);
    		  }
    	  }
		  logger.logWarning("Log-in Into System Failed");
    	  return 3;
		
	} catch (Exception e) {
		  logger.logError(e.getMessage());
		  System.out.print(e.getMessage());
		  return 3;
	}
	
	}
	
	
}
