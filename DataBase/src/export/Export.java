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
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs1 = md.getTables(null, getGetName(), table, null);

            int countC = 0;
            while (rs1.next()) {
                countC++;
            }

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);

            while (rs.next()) {
                for (int i =0;i<countC;i++){
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
