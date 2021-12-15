package ConnectionDatabase;

import java.sql.*;
import java.util.Properties;
import logger.logger;
public class ConnectionDatabase {
	 private static String Root;
	 private static String pass;
	 private static String locahost;
	 private static int port;
	
	public static Connection getConnection() {
		insert();
		Connection connection = null;
		try {
			if(connection==null) {
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", Root);
	    connectionProps.put("password", pass);
	    	connection = DriverManager.getConnection(
	                   "jdbc:" + "mysql" + "://" +
	                   locahost +
	                   ":" + port + "/",
	                   connectionProps);
	    System.out.println("The connection to database is done ");
	    logger.logInfo("Connected To DataBase Successfully");
	}
	} catch (SQLException e) {
	    System.out.print(e.getMessage());
	    logger.logError(e.getMessage());
		e.printStackTrace();
		
	}
		return connection;
	}
	//insert information database 
	public static void insert() {
	 Root=InfoDataBase.getRoot();
	 pass=InfoDataBase.getPass();
	 port=InfoDataBase.getPort();
	 locahost=InfoDataBase.getLocalhost();
	 
	}


}
