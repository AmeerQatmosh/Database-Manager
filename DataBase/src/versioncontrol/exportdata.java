package versioncontrol;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import ManagingDB.SchemaName;
import logger.logger;

public class exportdata extends SchemaName implements version {
	
	
	public void getnametable(Connection connection)
	{
	     try {
	    	 DatabaseMetaData md = connection.getMetaData();
	            String[] types = {"TABLE"};
	            ResultSet rs1 = md.getTables(getSchemaName(), null, null, types);
	            while (rs1.next()) {
	            	exportdata(connection,rs1.getString("TABLE_NAME"));
	            }
	            
	         

	        } catch (SQLException e) {
	            logger.logError(e.getMessage());
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	
	
	public void exportdata(Connection connection,String table)
	{
        
        try {
        Date date = new Date(); 
        String name = "C:\\Users\\MSI\\Desktop\\test2\\version\\"+table+" "+date.toString().replace(' ','-').replace(':', ';')+".csv";
        CSVWriter writer = new CSVWriter(new FileWriter(name, false),',',
        CSVWriter.NO_QUOTE_CHARACTER,
        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
        CSVWriter.DEFAULT_LINE_END);
        
        Boolean includeHeaders = true;
        Statement stmt = connection.createStatement();
        ResultSet myResultSet = stmt.executeQuery("SELECT * FROM "+getSchemaName()+"."+table);

        writer.writeAll(myResultSet, includeHeaders);
        
        writer.close();
        logger.logInfo("CSV File For Table "+ table +" Is Created Successfully.");
        System.out.println("CSV File For Table "+ table +" Is Created Successfully.");
      } catch (Exception e) {
        logger.logError(e.getMessage());
        e.printStackTrace();
    }
	}

	@Override
	public void operation(Connection database) {
		getnametable(database);
	}

}
