package Read;

import ManagingDB.*;

import java.util.*;
import java.sql.*;

public class ReadTable extends SchemaName implements ManagingDatabase {


    public void getTable(Connection connection){
        try {
            int count = 0;
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs1 = md.getTables(null, getGetName(), table, null);
            while (rs1.next()) {
                System.out.println(rs1.getString(3));
                count++;
            }


            Statement stmt = connection.createStatement();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);

            while (rs2.next()) {
                for (int i =0;i<count;i++){
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
