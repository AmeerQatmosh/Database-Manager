package Delete;

import ManagingDB.*;
import logger.logger;

import java.sql.*;
import java.util.Scanner;

public class DeleteTable extends SchemaName implements ManagingDatabase {
    public static void deleteTable(Connection connection) {
        try {
            // get table name to drop
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name To drop");
            String table = sc.nextLine();

            String sql = "DROP TABLE "+getGetName()+"."+table;
            PreparedStatement pstmt = connection.prepareStatement(sql); {
                // execute the drop statement
                pstmt.executeUpdate();
                logger.logInfo("Table "+ table +" Deleted From "+ getGetName() +" Successfully");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.logError(e.getMessage());
            e.printStackTrace();
        }
    }
    public void ManagingTable(Connection databaseConnection) {
        deleteTable(databaseConnection);
    }
}
