package profile;
import logger.logger;

import java.sql.*;
public class mysql {
	public Connection getconnectio() {
	try{  
		 
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","qwe123!@#");  
		Statement stmt=con.createStatement();  
		
		return con ;
		}
	catch(Exception e){
		logger.logError(e.getMessage());
		System.out.println(e);
		
	}
		return null ;
	}

}

