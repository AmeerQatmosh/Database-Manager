package logIn;
import logger.logger;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

//import com.mysql.cj.xdevapi.Statement;

public class logIn {

	public static String inpID ;
	public static  int logIn(Connection connection)
	{
		
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter your ID : ");
		inpID = keyboard.nextLine();
		System.out.println("Enter your Password : ");
	    String inpPassword = keyboard.nextLine();
	    
      try {
    	  Statement statement= connection.createStatement();  
    	  ResultSet resultSet= statement.executeQuery("select * from user");  

    	  while(resultSet.next())
    	  {
    		  if(resultSet.getString(1).equals(inpID)&&resultSet.getString(3).equals(inpPassword)) {
				  logger.logInfo("Log-in into system Successfully");
				  return resultSet.getInt(4);
    		  }
    	  }
		  logger.logWarning("Log-in into system Failed");
    	  return 3;
		
	} catch (Exception e) {
		  logger.logError(e.getMessage());
		  System.out.print(e.getMessage());
		  return 3;
	}
	
	}
	
	
}
