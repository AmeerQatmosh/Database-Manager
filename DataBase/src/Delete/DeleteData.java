package Delete;

import ManagingDB.*;
import logger.logger;
import java.sql.*;
import java.util.Scanner;

public class DeleteData extends SchemaName implements ManagingDatabase {
    public static void deleteData(Connection connection) {
        try {
            // get table name and id number to delete
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();
            System.out.println("Enter id To Delete");
            int id = sc.nextInt();

            String sqlQuery = "DELETE FROM "+ getSchemaName() +"."+table+" WHERE id = "+id;
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery); {
                // execute the delete statement
                pstmt.executeUpdate();
                logger.logInfo("Rows Deleted From "+ table +" Successfully");
            }
        } catch (SQLException e) {
            logger.logError(e.getMessage());
            e.printStackTrace();
        }
    }
    public void ManagingTable(Connection databaseConnection) {
        deleteData(databaseConnection);
    }
}
