package signUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import logger.logger;

public class signUp {
	static String  ID ,Name ,Password ;
	static int  type; 
	static logger log ;
	public static void signup (Connection db) {
		Scanner in= new Scanner(System.in);
		System.out.print("enter ID :");
		ID = in.nextLine();
		log.logInfo("id "+ID);

		System.out.print("enter name :");
		Name = in.nextLine();
		log.logInfo("name "+Name);

		System.out.print("enter password :");
		Password = in.nextLine();
		log.logInfo("password "+Password);

		System.out.print("enter type :");
		type = in.nextInt();
		log.logInfo("Type "+type);
		
		
		try {
			String sql = "insert into user (id,name,password,type) VALUES (?,?,? ,?)";

			PreparedStatement ps;
			log.logError ("sql"+sql);
			ps = db.prepareStatement(sql);
			log.logError ("ps"+ps);

			ps.setString(1, ID) ;
			ps.setString(2, Name) ;
			ps.setString(3, Password) ;
			ps.setInt(4, type) ;
			int row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
