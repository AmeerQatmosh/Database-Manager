package export;

import ManagingDB.ManagingDatabase;
import ManagingDB.SchemaName;
import com.opencsv.CSVWriter;
import logger.logger;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Export extends SchemaName implements ManagingDatabase {

    public static void exportData(Connection connection){
        try {

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();

            Date date = new Date(); 
            String name = "~\\Desktop\\test2\\"+table+" "+date.toString().replace(' ','-').replace(':', ';')+".csv";
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

    public void ManagingTable(Connection databaseConnection) {
        exportData(databaseConnection);
    }
}
