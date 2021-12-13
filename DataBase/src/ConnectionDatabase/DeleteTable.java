package ConnectionDatabase;

import java.sql.*;
import java.util.Scanner;

public class DeleteTable implements ManagingDatabase{
    public void deleteData(Connection connection) {
        try {
            // get table name and id number to delete

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Table Name");
            String table = sc.nextLine();
            System.out.println("Enter id To Delete");
            int id = sc.nextInt();

            String sql = "DELETE FROM "+table+" WHERE id = "+id;
            PreparedStatement pstmt = connection.prepareStatement(sql); {

                // execute the delete statement
                pstmt.executeUpdate();

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ManagingTable(Connection databaseConnection) {
        deleteData(databaseConnection);
    }
}
