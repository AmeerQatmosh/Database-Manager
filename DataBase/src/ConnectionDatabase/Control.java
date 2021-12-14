package ConnectionDatabase;

import java.sql.Connection;
import java.util.Scanner;

import Delete.DeleteData;
import Delete.DeleteTable;
import ManagingDB.*;
import Read.*;
import export.Export;
import insert.InsertData;
import logIn.logIn;
import profile.*;
import signUp.*;

public class Control {
	
	   private static  void connectionDataBase()
	   {
		   Scanner dbinfo= new Scanner(System.in);
			System.out.println("enter the data base infromation you need to connection with : ");
			System.out.println("enter root : ");
		   	 String root= dbinfo.nextLine();
		   	System.out.println("enter password : ");
		 	  String pass=dbinfo.nextLine();
		 	 System.out.println("enter localhost : ");
			  String localhost=dbinfo.nextLine();
			  System.out.println("enter port number : ");
			  int port=dbinfo.nextInt();
			  
			  InfoDataBase x = new InfoDataBase(
						 root,
						 pass, 
						 localhost,
						 port);

			ConnectionDatabase rs = new ConnectionDatabase();
			rs.getConnection();

			
	   }
	public static void main(String args[])
	{
		System.out.println("Connection DataBase");
		mysql x = new mysql ();
		Connection MySQL  = x.getconnectio();
		System.out.println("sign up : 1");
		System.out.println("log in : 2");
		System.out.println("exist : 0");
		Scanner option= new Scanner(System.in);
		int x1  = option.nextInt();
		factoryManaging factoryManaging = new factoryManaging();
		ManagingDatabase Table = factoryManaging.tables("ReadTable");
		ManagingDatabase Schema = factoryManaging.tables("ReadSchema");
		ManagingDatabase Drop = factoryManaging.tables("DeleteTable");
		ManagingDatabase Delete = factoryManaging.tables("DeleteData");
		ManagingDatabase Insert = factoryManaging.tables("InsertData");
		while (x1!= 0) {
			switch(x1) {
			  case 1:
			 signUp.signup(MySQL);
			    break;
			  case 2:
			  int Type = logIn.logIn(MySQL);
			  if (Type == 0) {
				  connectionDataBase();
				  StoreInfoDBs.StoreInfoDB(MySQL);
				  Schema.ManagingTable(MySQL);
				  System.out.println("ReadTable : 1");
				  System.out.println("Insert data : 2");
				  System.out.println("DeleteData : 3");
				  System.out.println("DropTable : 4");
				  System.out.println("Log out : 0");
				  Scanner option2= new Scanner(System.in);
				  int x2 = option.nextInt();
				  
				  while(x2!=0) {
					  switch(x2) {
					  case 1:			  
						  Table.ManagingTable(MySQL);
						  break;
					  case 2 :
						  Insert.ManagingTable(MySQL);
						  break ;
					  case 3 : 
						  Delete.ManagingTable(MySQL);
						  break ;
					  case 4 :  
						  Drop.ManagingTable(MySQL);
					  case 0: 
						  break;
					  default:
						  System.out.println("Uncorrect input ... ");
					  }
					  System.out.println("ReadTable : 1");
					  System.out.println("Insert data : 2");
					  System.out.println("DeleteData : 3");
					  System.out.println("DropTable : 4");
					  System.out.println("Log out : 0");
					  x2 = option.nextInt();
				  }
				  
				  
				
			  }
			  else if (Type == 1) {
				  connectionDataBase();
				  StoreInfoDBs.StoreInfoDB(MySQL);
				  Schema.ManagingTable(MySQL);
				  
				  System.out.println("ReadTable : 1");
				  System.out.println("Insert data : 2");
				  System.out.println("Log out : 0");
				  Scanner option2= new Scanner(System.in);
				  int x2 = option.nextInt();
				  
				  while(x2!=0) {
					  switch(x2) {
					  case 1:			  
						  Table.ManagingTable(MySQL);
						  break;
					  case 2 :
						  Insert.ManagingTable(MySQL);
						  break ;
					  case 0: 
						  break;
					  default:
						  System.out.println("Uncorrect input ... ");
					  }
					  System.out.println("ReadTable : 1");
					  System.out.println("Insert data : 2");
					  System.out.println("Log out : 0");
					  x2 = option.nextInt();
				  } 

			  }
			  else if (Type == 2) {
				  connectionDataBase();
				  StoreInfoDBs.StoreInfoDB(MySQL);
				  Schema.ManagingTable(MySQL);
				  
				  System.out.println("ReadTable : 1");
				  System.out.println("Log out : 0");
				  Scanner option2= new Scanner(System.in);
				  int x2 = option.nextInt();
				  
				  while(x2!=0) {
					  switch(x2) {
					  case 1:			  
						  Table.ManagingTable(MySQL);
						  break;
					  case 0: 
						  break;
					  default:
						  System.out.println("Uncorrect input ... ");
					  }
					  System.out.println("ReadTable : 1");
					  System.out.println("Log out : 0");
					  x2 = option.nextInt();
				  }
				  

			  }
			  else if (Type == 3) {
				  System.out.println("Uncorrect password or id");
				  break;
			  }
			  case 0: 
				  break;
			  default:
				  System.out.println("Uncorrect input ... ");
			}
			System.out.println("sign up : 1");
			System.out.println("log in : 2");
			System.out.println("exist : 0");
			x1  = option.nextInt();

		}
		
		System.out.println("Exist ...");
	
	}
}
