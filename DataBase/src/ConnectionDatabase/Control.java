package ConnectionDatabase;

import java.sql.Connection;
import java.util.Scanner;

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
		connectionDataBase();
		mysql x = new mysql ();
		Connection MySQL  = x.getconnectio();
		System.out.println("sign up : 1");
		System.out.println("log up : 2");
		System.out.println("exist : 0");
		Scanner option= new Scanner(System.in);
		int x1  = option.nextInt();
		while (x1!= 0) {
			switch(x1) {
			  case 1:
			 signUp.signup(MySQL);
			    break;
			  case 2:
			  logIn.logIn(MySQL);
			    break;
			  default:
				  System.out.println("Uncorrect input ... ");
			}
			System.out.println("sign up : 1");
			System.out.println("log up : 2");
			System.out.println("exist : 0");
			x1  = option.nextInt();

		}
		System.out.println("Exist ...");
	
	}
}
