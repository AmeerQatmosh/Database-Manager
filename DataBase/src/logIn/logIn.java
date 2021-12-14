package logIn;
import java.sql.Statement; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

//import com.mysql.cj.xdevapi.Statement;

public class logIn {
	
	public static  int logIn(Connection connection)
	{

		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter your ID : ");
	    String inpID = keyboard.nextLine();
		System.out.println("Enter your Password : ");
	    String inpPassword = keyboard.nextLine();
	    
      try {
    	  Statement statement= connection.createStatement();  
    	  ResultSet resultSet= statement.executeQuery("select * from user");  

    	  while(resultSet.next())
    	  {
    		  if(resultSet.getString(1).equals(inpID)&&resultSet.getString(3).equals(inpPassword)) {
    		  System.out.println(resultSet.getString(1)+" "+resultSet.getString(3)+" "+resultSet.getInt(4));
        	  return resultSet.getInt(4);

    		  }
    	  }
    	  return 3;
		
	} catch (Exception e) {
		System.out.print(e.getMessage());
		return 3;
	}
	
	}
	
	
}
