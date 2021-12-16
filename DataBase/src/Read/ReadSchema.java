package Read;

import ManagingDB.*;
import logger.logger;

import java.sql.*;
import java.util.Scanner;

public class ReadSchema extends SchemaName implements ManagingDatabase {
    public static void getSchema(Connection connection){
        try {
            // getting Database Schema Names
            ResultSet rs = connection.getMetaData().getCatalogs();
            while (rs.next()) {
                System.out.println("Schema Name : " + rs.getString("TABLE_CAT"));
            }
            logger.logInfo("All Schema Showed Successfully");
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Schema Name");
            String Schema = sc.nextLine();
            setSchemaName(Schema);
            logger.logInfo("Schema "+ Schema +" Selected Successfully");

        } catch (SQLException e) {
            logger.logError(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ManagingTable(Connection databaseConnection) {
        getSchema(databaseConnection);

    }
}
