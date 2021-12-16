package Import;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class sql implements Imports{
	
	
//	public void sql(Connection connection,String file)
//    {
//    	 String Sql=null;    	
//    	try  {
//    		BufferedReader bufferedreader = null;
//			try {
//				bufferedreader = new BufferedReader(new FileReader(file));
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//    	   
//    	    try {
//				while ((Sql = bufferedreader.readLine()) != null) {
//					PreparedStatement ps = connection.prepareStatement(Sql);
//					ps.execute(Sql);
//
//				}
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//    	}catch (SQLException e) {
//    		 System.out.println("SQL Exception Occurred" + e);
//			
//		}
//    }


	@Override
	public void File(Connection Database) {

//    	System.out.println("Enter File Path:");
//		 Scanner sc = new Scanner (System.in);
//		 String file = sc.nextLine();
//	
//	  sql(Database,file);
		
	}

}
