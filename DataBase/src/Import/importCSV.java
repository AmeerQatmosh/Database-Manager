package Import;

import ManagingDB.SchemaName;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class importCSV extends SchemaName {
    public static void importData(Connection connection){
        try {

//            Scanner sc= new Scanner(System.in);
//            System.out.println("Enter Table Name");
//            String table = sc.nextLine();
//
//            Date date = new Date();
//            String name = "C:\\Users\\MSI\\Desktop\\test2\\"+table+" "+date.toString().replace(' ','-').replace(':', ';')+".csv";
//            CSVWriter writer = new CSVWriter(new FileWriter(name, false),',',
//                    CSVWriter.NO_QUOTE_CHARACTER,
//                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                    CSVWriter.DEFAULT_LINE_END);
//
//            Boolean includeHeaders = true;
//            Statement stmt = connection.createStatement();
//            ResultSet myResultSet = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);
//
//            writer.writeAll(myResultSet, includeHeaders);
//
//            writer.close();
//
//            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
