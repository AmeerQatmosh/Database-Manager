package ConnectionDatabase;

public class InfoDataBase {
	
	private static String User;
	private static String Password;
	private static String URL;
	private static int Port;
	
	 public InfoDataBase()
	 {
		 super();
	 }
	 public InfoDataBase(String User,String Password,String URL,int Port)
	 {
		 setUser(User);
		 setPassword(Password);
		 setURL(URL);
		 setPort(Port);
	 }
	public static String getPassword() {
		return Password;
	}
	public static void setPassword(String Password) {
		
		InfoDataBase.Password = Password;
	}
	public static String getUser() {

		return User;
	}
	public static void setUser(String User) {
		InfoDataBase.User = User;
	}
	public static int getPort() {
		return Port;
	}
	public static void setPort(int Port) {
		InfoDataBase.Port = Port;
	}
	public static String getURL() {

		return URL;
	}
	public static void setURL(String URL) {
		InfoDataBase.URL = URL;
	}

}
