package ConnectionDatabase;

import java.sql.*;

public class ReadSchema implements ManagingDatabase {
    public void getSchema(Connection connection){
        try {
            // getting Database Schema Names
            ResultSet rs = connection.getMetaData().getCatalogs();
            while (rs.next()) {
                System.out.println("Schema Name - " + rs.getString("TABLE_CAT"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ManagingTable(Connection databaseConnection) {
        getSchema(databaseConnection);

    }
}
