package export;

import ManagingDB.SchemaName;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;

public class Export extends SchemaName {

    public static void exportData(Connection connection){
        String filename =
                "C:\\Documents and Settings\\admin\\My Documents\\NetBeansProjects\\AutomateExcelDatabase\\myjdbcfile.csv";
        try {

            FileWriter fw = new FileWriter(filename);

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();



            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i =1;i<=columnCount;i++){
                    fw.append(rs.getString(i));
                    fw.append(',');
                }
                fw.append('\n');
            }

            fw.flush();
            fw.close();
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
