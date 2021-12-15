package ConnectionDatabase;

import java.sql.*;
import java.util.Properties;
import logger.logger;
public class ConnectionDatabase {
	 private static String User;
	 private static String Password;
	 private static String URL;
	 private static int Port;
	
	public static Connection getConnection() {
		SetDataInfo();
		Connection connection = null;
		try {
			if(connection==null) {
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", User);
	    connectionProps.put("password", Password);
	    	connection = DriverManager.getConnection(
	                   "jdbc:" + "mysql" + "://" +
	                   URL +
	                   ":" + Port + "/",
	                   connectionProps);
	    System.out.println("Connected To DataBase Successfully");
	    logger.logInfo("Connected To DataBase Successfully");
	}
	} catch (SQLException e) {
	    System.out.print(e.getMessage());
	    logger.logError(e.getMessage());
	}
		return connection;
	}
	//set information database
	public static void SetDataInfo() {
	 User=InfoDataBase.getUser();
	 Password=InfoDataBase.getPassword();
	 Port=InfoDataBase.getPort();
	 URL=InfoDataBase.getURL();
	 
	}
}
