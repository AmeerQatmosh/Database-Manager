package ConnectionDatabase;

import java.sql.*;
import java.util.Scanner;

public class ReadSchema extends SchemaName implements ManagingDatabase {
    public void getSchema(Connection connection){
        try {
            // getting Database Schema Names
            ResultSet rs = connection.getMetaData().getCatalogs();
            while (rs.next()) {
                System.out.println("Schema Name : " + rs.getString("TABLE_CAT"));
            }
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Schema Name");
            String Schema = sc.nextLine();
            setGetName(Schema);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ManagingTable(Connection databaseConnection) {
        getSchema(databaseConnection);

    }
}
