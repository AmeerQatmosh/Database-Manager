package ConnectionDatabase;

public class Control {
	
	   private static  void connectionDataBase()
	   {
		   	 String root="root";
		 	  String pass="qwe123!@#";
			  String localhost="localhost";
			  int port=3306;
			  
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
		connectionDataBase();



	
	}
}
