package ConnectionDatabase;
import java.util.*;
import java.sql.*;

public class ReadTable implements ManagingDatabase{


    public void getTable(Connection connection){
        try {

            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs1 = md.getTables(null, null, "%", null);
            while (rs1.next()) {
                System.out.println(rs1.getString(3));
            }

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();
            Statement stmt = connection.createStatement();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM "+table);

            while (rs2.next()) {
                int id = rs2.getInt("null");
                String name = rs2.getString("null");
                String job = rs2.getString("null");
                System.out.println(id+"   "+name+"    "+job);
            }
        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public void ManagingTable(Connection databaseConnection) {
        getTable(databaseConnection);

    }

}
