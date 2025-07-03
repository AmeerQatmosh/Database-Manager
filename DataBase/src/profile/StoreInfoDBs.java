package profile;

import ConnectionDatabase.*;
import logIn.logIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreInfoDBs {
	private static String User = InfoDataBase.getUser();
	 private static String Password =InfoDataBase.getPassword() ;
	 private static int Port=InfoDataBase.getPort();
	 private static String URL=InfoDataBase.getURL();
	 static String user_id = logIn.ID;
	public static void StoreInfoDB (Connection connection) {

		
		try {
			String sql = "insert into dbinformation (user_id,url,password,user,port) VALUES (?,?,? ,?,?)";

			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			
			
			ps.setString(1, user_id) ;		
			ps.setString(2, URL) ;
			ps.setString(3, Password) ;
			ps.setString(4, User) ;
			ps.setInt(5, Port) ;
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
