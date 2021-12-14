package export;

import ManagingDB.SchemaName;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class Export extends SchemaName {

    public static void exportData(Connection connection){
//        String filename =
//                "C:\\Documents and Settings\\admin\\My Documents\\NetBeansProjects\\AutomateExcelDatabase\\myjdbcfile.csv";
        try {

//            CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
//            Boolean includeHeaders = true;
//
//            java.sql.ResultSet myResultSet = .... //your resultset logic here
//
//            writer.writeAll(myResultSet, includeHeaders);
//
//            writer.close();

        	 PrintWriter pw= new PrintWriter(new File("C:\\Users\\MSI\\Desktop\\test2\\test3.csv"));
        	    StringBuilder sb=new StringBuilder();

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();



            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i =1;i<=columnCount;i++){
                    sb.append(rs.getString(i));
                    sb.append(",");
                }
                sb.append("\r\n");
            }

            pw.write(sb.toString());
            pw.close();
            System.out.println("finished");
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
