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

            String sqlQuery = "DROP TABLE "+ getSchemaName()+ "."+table;
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery); {
                // execute the drop statement
                pstmt.executeUpdate();
                logger.logInfo("Table "+ table +" Deleted From "+ getSchemaName() +" Successfully");
            }
        } catch (SQLException e) {
            logger.logError(e.getMessage());
            e.printStackTrace();
        }
    }
    public void ManagingTable(Connection databaseConnection) {
        deleteTable(databaseConnection);
    }
}
