package versioncontrol;

import java.io.*;
import java.sql.*;

public class rescive implements version {
    String path = "C:\\Users\\MSI\\Desktop\\test2\\version";

	public  void importfile(Connection database)
	{
		File directoryPath = new File(path);
	      File filesList[] = directoryPath.listFiles();
	      String AbsolutePath;
	      
	      for(File file : filesList) {
	         AbsolutePath=file.getAbsolutePath();
	         String TableName =file.getName();
	  
	         String[] parts = TableName.split(" ");
	         String getTableName = parts[0];
	         
	        csvfile(database,getTableName);
	      }

	}
	      public void csvfile(Connection database,String getTableName)
	      {
	    	  // we didn't implement the code here , check Import.ImportCSV.java
	      }
	public void operation(Connection database) {
		importfile(database);
		
	}

}
