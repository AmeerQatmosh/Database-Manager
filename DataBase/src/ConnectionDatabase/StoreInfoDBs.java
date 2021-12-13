package profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ConnectionDatabase.InfoDataBase;

public class StoreInfoDBs {
//	private String email  ; 
	private static String root = InfoDataBase.getRoot();
	 private static String password =InfoDataBase.getPass() ;
	 private static int port=InfoDataBase.getPort();
	 private static String locahost=InfoDataBase.getLocalhost();
	 
	public static void StoreInfoDB (Connection db) {

		
		try {
			String sql = "insert into dbinformation (localHost,password,root,port,type) VALUES (?,? ,?,?,?)";

			PreparedStatement ps;
			ps = db.prepareStatement(sql);

//			ps.setString(1, Email) ;
			try {
				ps.setString(1, root) ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setString(2, password) ;
			ps.setInt(4, port) ;
			ps.setString(5, locahost) ;
//			ps.setInt(6, type) ;
			int row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
