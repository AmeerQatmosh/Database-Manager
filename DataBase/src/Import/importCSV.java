package Import;

import java.io.*;
import java.sql.*;

import ManagingDB.SchemaName;

public class importCSV extends SchemaName implements Imports {

	
	
	public void importcsv (Connection connection) {

		
//		            String line = "";
//		            int count;
//		            String splitBy = ",";  
//		            String lines = " ";  
//		            String Values = "(";
//		          //parsing a CSV file into BufferedReader class constructor  
//	    			  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MSI\\Desktop\\test2\\version\\"));  
//	    			  while ((line = br.readLine()) != null)   //returns a Boolean value  
//	    			  {  
//	    			  String[] values = line.split(splitBy);
//	    			   if(line.split(lines))
//	    			   {
//	    			      count++;
//	    			   }
//	    			 
//	    			
//	    			  
////	                   System.out.println("Insert Into "+rsmd.getColumnName(i));
//	                   }
//		            for (int i =1;i<=values.count();i++){
//		            	  
//		    			  Values += values[i]+", ";
//		    			    
//
//		 
//		    			  }
//		            Values += ")";
//                    Values = Values.replace(", )", ")");
//                    System.out.print(Values);
//
//    			    Statement stmt2 = connection.createStatement();
//                    stmt2.executeUpdate("INSERT INTO abed.test VALUES "+Values);
	}
	public void File(Connection Database) {
		// TODO Auto-generated method stub
		importcsv(Database);
		
	}


  }
