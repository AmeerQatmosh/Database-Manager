package ConnectionDatabase;

import java.sql.*;
import java.util.Properties;
import logger.logger;
public class ConnectionDatabase {
	
	 private String Root;
	 private String pass;
	 private String locahost;
	 private int port;
	

	public Connection getConnection() {
		insert();
		Connection connection = null;
		try {
			if(connection==null) {
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.Root);
	    connectionProps.put("password", this.pass);
	    	connection = DriverManager.getConnection(
	                   "jdbc:" + "mysql" + "://" +
	                   this.locahost +
	                   ":" + this.port + "/",
	                   connectionProps);
	    System.out.print("The connection to database is done");
			}
			else {
				connection.close();
			}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	    System.out.print(e.getMessage());
	    logger.logError(e.getMessage());
		e.printStackTrace();
	}
		return connection;

	}
	
	
	//insert information database 
	public void insert() {
	 this.Root=InfoDataBase.getRoot();
	 this.pass=InfoDataBase.getPass();
	 this.port=InfoDataBase.getPort();
	 this.locahost=InfoDataBase.getLocalhost();
	}


}
