package insert;

import ManagingDB.*;

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
            
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM "+getGetName()+"."+table);
            ResultSetMetaData rsmd = rs2.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String Values = "(";
            // INSERT INTO FDSFS VALUES (1, OAMR)
            for (int i =1;i<=columnCount;i++){
                System.out.println("insert into "+rsmd.getColumnName(i));
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

            stmt2.executeUpdate("INSERT INTO "+getGetName()+"."+table+" VALUES "+Values); 
            System.out.println();

        } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }


    public void ManagingTable(Connection databaseConnection) {
        insert(databaseConnection);
    }
}
