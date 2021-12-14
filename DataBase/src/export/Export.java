package export;

import ManagingDB.SchemaName;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import com.opencsv.CSVWriter;

public class Export extends SchemaName {

    public static void exportData(Connection connection){
        try {

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();

            Date date = new Date(); 
            String name = "C:\\Users\\MSI\\Desktop\\test2\\"+table+" "+date.toString().replace(' ','-').replace(':', ';')+".csv";
            CSVWriter writer = new CSVWriter(new FileWriter(name, false),',',
            CSVWriter.NO_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
            CSVWriter.DEFAULT_LINE_END);
            
            Boolean includeHeaders = true;
            Statement stmt = connection.createStatement();
            ResultSet myResultSet = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);

            writer.writeAll(myResultSet, includeHeaders);
            
            writer.close();
            
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
