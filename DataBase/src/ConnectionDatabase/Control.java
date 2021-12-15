package ConnectionDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Delete.DeleteData;
import Delete.DeleteTable;
import ManagingDB.*;
import Read.*;
import export.Export;
import insert.InsertData;
import logIn.logIn;
import logger.logger;
import profile.*;
import signUp.*;

public class Control {
	
	   private static  Connection connectionDataBase()
	   {
		   Scanner sc= new Scanner(System.in);
			System.out.println("Enter The Data Base Information You Need To Connect With : ");
			System.out.println("Enter User : ");
		   	 String User= sc.nextLine();
		   	System.out.println("Enter Password : ");
		 	  String Password=sc.nextLine();
		 	 System.out.println("Enter URL : ");
			  String URL=sc.nextLine();
			  System.out.println("Enter Port number : ");
			  int Port=sc.nextInt();
			  
			  InfoDataBase info = new InfoDataBase(
						 User,
						 Password, 
						 URL,
						 Port);
			  try {
				  return ConnectionDatabase.getConnection();
			  }
			  catch(Exception e){
				  System.out.print(e.getMessage());
				    logger.logError(e.getMessage());
			  }
			return null;
	   }
	public static void main(String args[])
	{
		System.out.println("Connection DataBase");
		mysql sql = new mysql ();
		Connection connectionMySQL  = sql.getConnection();
		System.out.println("Sign Up : 1");
		System.out.println("Log In : 2");
		System.out.println("Exit : 0");
		Scanner sc= new Scanner(System.in);
		int Option1  = sc.nextInt();
		factoryManaging factoryManaging = new factoryManaging();
		ManagingDatabase Table = factoryManaging.Data("ReadTable");
		ManagingDatabase Schema = factoryManaging.Data("ReadSchema");
		ManagingDatabase Drop = factoryManaging.Data("DeleteTable");
		ManagingDatabase Delete = factoryManaging.Data("DeleteData");
		ManagingDatabase Insert = factoryManaging.Data("InsertData");
		ManagingDatabase Export = factoryManaging.Data("ExportData");
		while (Option1!= 0) {
			switch(Option1) {
			  case 1:
			 signUp.signup(connectionMySQL);
			    break;
			  case 2:
			  int UserType = logIn.logIn(connectionMySQL);
			  if (UserType == 0) {
				  Connection connection = connectionDataBase();
				  if(connection != null) 
					  StoreInfoDBs.StoreInfoDB(connectionMySQL);
				  Schema.ManagingTable(connection);
				  System.out.println("ReadTable : 1");
				  System.out.println("Insert data : 2");
				  System.out.println("DeleteData : 3");
				  System.out.println("DropTable : 4");
				  System.out.println("ExportTable : 5");
				  System.out.println("LogOut : 0");
				  int Option2 = sc.nextInt();
				  while(Option2!=0) {
					  switch(Option2) {
						  case 1:
							  Table.ManagingTable(connection);
							  break;
						  case 2 :
							  Insert.ManagingTable(connection);
							  break;
						  case 3 :
							  Delete.ManagingTable(connection);
							  break;
						  case 4 :
							  Drop.ManagingTable(connection);
							  break;
						  case 5:
							  Export.ManagingTable(connection);
							  break;
					  	case 0:
							  logger.logInfo("User Signed-Out From System");
							  break;
						  default:
							  logger.logWarning("User's Input Incorrect");
							  System.out.println("Incorrect input ... ");
						  }
						  System.out.println("ReadTable : 1");
						  System.out.println("Insert data : 2");
						  System.out.println("DeleteData : 3");
						  System.out.println("DropTable : 4");
						  System.out.println("LogOut : 0");
						  Option2 = sc.nextInt();
				  }
			  }
			  else if (UserType == 1) {
				  Connection connection=  connectionDataBase();
				  StoreInfoDBs.StoreInfoDB(connectionMySQL);
				  Schema.ManagingTable(connection);

				  System.out.println("ReadTable : 1");
				  System.out.println("Insert data : 2");
				  System.out.println("LogOut : 0");
				  int Option2 = sc.nextInt();
				  while(Option2!=0) {
					  switch(Option2) {
					  case 1:			  
						  Table.ManagingTable(connection);
						  break;
					  case 2 :
						  Insert.ManagingTable(connection);
						  break ;
					  case 0:
						  logger.logInfo("User Signed-Out From System");
						  break;
					  default:
						  logger.logWarning("User's Input Incorrect");
						  System.out.println("Incorrect Input ... ");
					  }
					  System.out.println("ReadTable : 1");
					  System.out.println("Insert data : 2");
					  System.out.println("LogOut : 0");
					  Option2 = sc.nextInt();
				  } 
			  }
			  else if (UserType == 2) {
				  Connection connection = connectionDataBase();
				  StoreInfoDBs.StoreInfoDB(connectionMySQL);
				  Schema.ManagingTable(connection);
				  System.out.println("ReadTable : 1");
				  System.out.println("LogOut : 0");
				  int Option2 = sc.nextInt();
				  while(Option2!=0) {
					  switch(Option2) {
					  case 1:			  
						  Table.ManagingTable(connection);
						  break;
					  case 0:  
						  break;
					  default:
						  logger.logWarning("User's Input Incorrect");
						  System.out.println("Incorrect Input ... ");
					  }
					  System.out.println("ReadTable : 1");
					  System.out.println("LogOut : 0");
					  Option2 = sc.nextInt();
				  }
				  logger.logInfo("User Signed-Out From Systemtem");
			  }
			  else if (UserType == 3) {
				  System.out.println("Incorrect Password Or ID");
				  break;
			  }
				case 0:
				  break;
			  default:
				  logger.logWarning("User's Input Incorrect");
				  System.out.println("Incorrect Input ... ");
			}
			System.out.println("Sign up : 1");
			System.out.println("log in : 2");
			System.out.println("Exit : 0");
			Option1  = sc.nextInt();
		}
		logger.logInfo("User Closed the sys");
		System.out.println("Exit ...");
	}
}