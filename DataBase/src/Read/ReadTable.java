package Read;

import ManagingDB.*;

import java.util.*;
import java.sql.*;

public class ReadTable extends SchemaName implements ManagingDatabase {


    public void getTable(Connection connection){
        try {
            int count = 0;
            // Show all tables from selected schema
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs1 = md.getTables(null, getGetName(), "%", null);
            while (rs1.next()) {
                System.out.println(rs1.getString(3));
            }

            //Get table name from user
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();

            //Show all columns names for selected table
            Statement stmt = connection.createStatement();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);
            ResultSetMetaData rsmd = rs2.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i =1;i<=columnCount;i++){
                System.out.print(rsmd.getColumnName(i)+"\t");
            }
            while (rs2.next()) {
                for (int i =1;i<=columnCount;i++){
                    System.out.print(rs2.getString(i)+"\t");
                }
            }
        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public void ManagingTable(Connection databaseConnection) {
        getTable(databaseConnection);

    }

}
