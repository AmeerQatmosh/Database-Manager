package profile;

import ConnectionDatabase.*;
import logIn.logIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreInfoDBs {
//	private String email  ; 
	private static String root = InfoDataBase.getUser();
	 private static String password =InfoDataBase.getPassword() ;
	 private static int port=InfoDataBase.getPort();
	 private static String locahost=InfoDataBase.getURL();
	 static String user_id = logIn.inpID;
	public static void StoreInfoDB (Connection db) {

		
		try {
			String sql = "insert into dbinformation (user_id,localHost,password,root,port) VALUES (?,?,? ,?,?)";

			PreparedStatement ps;
			ps = db.prepareStatement(sql);

//			ps.setString(1, Email) ;
			
			ps.setString(1, user_id) ;		
			ps.setString(2, locahost) ;
			ps.setString(3, password) ;
			ps.setString(4, root) ;
			ps.setInt(5, port) ;
			int row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
