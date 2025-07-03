package insert;

import ManagingDB.*;
import logger.logger;
import java.sql.*;
import java.util.Scanner;

public class InsertData extends SchemaName implements ManagingDatabase {
    public static void insert(Connection connection){
        try {
            //Get table name from user
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();

            //Show all columns names for selected table
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+getSchemaName()+"."+table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // eg. INSERT INTO Table_name VALUES (1, 'OMAR', 6)
            // get values to insert from user
            String Values = "(";
            for (int i =1;i<=columnCount;i++){
                System.out.println("Insert Into "+rsmd.getColumnName(i));
                if(rsmd.getColumnTypeName(i)=="INT"){
                    Values += sc.nextLine()+", ";
                }
                else{
                    Values += "'"+sc.nextLine()+"', ";
                }
            }
            Values += ")";
            Values = Values.replace(", )", ")");
           
            Statement stmt2 = connection.createStatement();
            stmt2.executeUpdate("INSERT INTO "+getSchemaName()+"."+table+" VALUES "+Values);
            System.out.println();
            logger.logInfo("Inserted Into "+ table +" Successfully");

        } catch(SQLException e) {
            logger.logError(e.getMessage());
            System.out.println("SQL Exception Occurred" + e);
        }
    }

    public void ManagingTable(Connection databaseConnection) {
        insert(databaseConnection);
    }
}
