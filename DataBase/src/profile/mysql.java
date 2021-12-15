package profile;
import logger.logger;

import java.sql.*;
public class mysql {
	public Connection getConnection() {
	try{  
		 
		Connection connection=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","qwe123!@#");  
		Statement stmt=connection.createStatement();  
		
		return connection ;
		}
	catch(Exception e){
		logger.logError(e.getMessage());
		System.out.println(e);
	}
		return null ;
	}
}

